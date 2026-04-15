package info.hccis.recordstore.soap;

import info.hccis.recordstore.dao.RecordSaleDAO;
import info.hccis.recordstore.jpa.entity.ArtistSaleList;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "info.hccis.recordstore.soap.RecordSaleServiceSOAP", targetNamespace = "http://www.hccis.info/recordstore")
public class RecordSaleServiceSOAPImpl implements RecordSaleServiceSOAP {

    private final RecordSaleDAO recordSaleDAO;

    public RecordSaleServiceSOAPImpl() {
        this.recordSaleDAO = new RecordSaleDAO();
    }

    @Override
    public List<ArtistSaleList> getAllSales() {
        return recordSaleDAO.selectSalesByArtistName("");  // Fetching all sales (you can modify this logic if needed)
    }

    @Override
    public ArtistSaleList getSaleById(int id) {
        return recordSaleDAO.selectSaleById(id);
    }

    @Override
    public List<ArtistSaleList> getTransactions() {
        return recordSaleDAO.selectSalesByArtistName("");  // Modify this based on how you want to fetch transactions
    }
}
