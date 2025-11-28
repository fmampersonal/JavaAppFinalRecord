package info.hccis.recordstore.soap;

import info.hccis.recordstore.jpa.entity.ArtistSaleList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface RecordSaleServiceSOAP {

    /**
     * Get all sales records.
     */
    @WebMethod
    List<ArtistSaleList> getAllSales();

    /**
     * Get a single sale by its ID.
     */
    @WebMethod
    ArtistSaleList getSaleById(int id);
}
