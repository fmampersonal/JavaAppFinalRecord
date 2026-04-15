package info.hccis.recordstore.rest;

import info.hccis.recordstore.exception.AllAttributesNeededException;
import com.google.gson.Gson;
import info.hccis.recordstore.repositories.RecordSaleRepository;
import info.hccis.recordstore.util.CisUtility;
import info.hccis.recordstore.jpa.entity.ArtistSaleList;

import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.jws.WebService;
import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * REST service for managing record store sales.
 * Replaces old TicketOrderService.
 *
 * @author BJM
 * @since 20251024
 */
@Path("/RecordSaleService/sales")
public class RecordSaleService {

    private final RecordSaleRepository recordSaleRepo;

    @Autowired
    public RecordSaleService(RecordSaleRepository recordSaleRepo) {
        this.recordSaleRepo = recordSaleRepo;
    }

    /**
     * Get all sales records.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ArtistSaleList> getAll() {
        return (ArrayList<ArtistSaleList>) recordSaleRepo.findAll();
    }

    /**
     * Get a single sale by its ID.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSaleById(@PathParam("id") Integer id) throws URISyntaxException {
        Optional<ArtistSaleList> sale = recordSaleRepo.findById(id);
        if (!sale.isPresent()) {
            return Response.status(204).build();
        } else {
            return Response.status(200).entity(sale).build();
        }
    }

    /**
     * Delete a sale record by ID.
     */
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            Optional<ArtistSaleList> saleOptional = recordSaleRepo.findById(id);
            if (!saleOptional.isPresent()) {
                // Return 204 No Content if record not found
                return Response.status(HttpURLConnection.HTTP_NO_CONTENT).build();
            } else {
                recordSaleRepo.delete(saleOptional.get());
            }
        } catch (Exception e) {
            // Return 406 Not Acceptable if delete fails
            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(e.getMessage()).build();
        }

        // Return 200 OK if delete succeeds
        return Response.status(HttpURLConnection.HTTP_OK)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build();
    }


    /**
     * Create a new sale record.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String saleJson) {
        try {
            String temp = save(saleJson);
            return Response.status(HttpURLConnection.HTTP_OK).entity(temp)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (AllAttributesNeededException aane) {
            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(aane.getMessage()).build();
        } catch (Exception e) {
            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(e.getMessage()).build();
        }
    }

    /**
     * Update an existing sale record by ID.
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSale(@PathParam("id") int id, String saleJson) throws URISyntaxException {
        try {
            String temp = save(saleJson);
            return Response.status(201).entity(temp)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (AllAttributesNeededException aane) {
            return Response.status(400).entity(aane.getMessage()).build();
        }
    }

    /**
     * Save or update a sale record.
     * Validates required fields and sets current dateOfSale.
     */
    public String save(String json) throws AllAttributesNeededException {
        Gson gson = new Gson();
        ArtistSaleList sale = gson.fromJson(json, ArtistSaleList.class);

        // --- Changed: set dateOfSale instead of dateOfOrder ---
        sale.setDateOfSale(CisUtility.getCurrentDate("yyyy-MM-dd"));

        if (sale.getId() == null) {
            sale.setId(0);
        }

        sale = recordSaleRepo.save(sale);

        return gson.toJson(sale);
    }
}
