package info.hccis.recordstore.soap;

import info.hccis.recordstore.jpa.entity.ArtistSaleList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface RecordSaleServiceSOAP {

    @WebMethod
    List<ArtistSaleList> getAllSales();

    @WebMethod
    ArtistSaleList getSaleById(int id);

    @WebMethod
    List<ArtistSaleList> getTransactions();


}
