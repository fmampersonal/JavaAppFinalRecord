package info.hccis.recordstore.entity;

import info.hccis.recordstore.jpa.entity.ArtistSaleList;
import java.util.ArrayList;

/**
 * Model class to hold report input and results for record store sales.
 *
 * @author BJM
 * @since 20251024
 */
public class ReportRecordStore {

    // --- Input field(s) ---
    private String artistName;

    // --- Output field(s) ---
    private ArrayList<ArtistSaleList> recordSales = new ArrayList<>();

    // --- Constructors ---
    public ReportRecordStore() {
        // default constructor
    }

    public ReportRecordStore(String artistName) {
        this.artistName = artistName;
    }

    // --- Getters & Setters ---
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public ArrayList<ArtistSaleList> getRecordSales() {
        return recordSales;
    }

    public void setRecordSales(ArrayList<ArtistSaleList> recordSales) {
        this.recordSales = recordSales;
    }

    // --- Utility methods (optional) ---
    public boolean hasSales() {
        return recordSales != null && !recordSales.isEmpty();
    }

    @Override
    public String toString() {
        return "ReportRecordStore{" +
                "artistName='" + artistName + '\'' +
                ", recordSales=" + recordSales +
                '}';
    }
}
