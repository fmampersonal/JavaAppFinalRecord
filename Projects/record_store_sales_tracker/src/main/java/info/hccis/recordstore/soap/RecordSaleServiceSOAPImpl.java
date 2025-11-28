package info.hccis.recordstore.soap;

import info.hccis.recordstore.jpa.entity.ArtistSaleList;
import info.hccis.recordstore.repositories.RecordSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "info.hccis.recordstore.soap.RecordSaleServiceSOAP")
public class RecordSaleServiceSOAPImpl implements RecordSaleServiceSOAP {

    private final RecordSaleRepository recordSaleRepo;

    @Autowired
    public RecordSaleServiceSOAPImpl(RecordSaleRepository recordSaleRepo) {
        this.recordSaleRepo = recordSaleRepo;
    }

    @Override
    public List<ArtistSaleList> getAllSales() {
        return recordSaleRepo.findAll();
    }

    @Override
    public ArtistSaleList getSaleById(int id) {
        Optional<ArtistSaleList> sale = recordSaleRepo.findById(id);
        return sale.orElse(null);  // Return null if not found (SOAP can’t return Optional)
    }
}
