package info.hccis.recordstore.jpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * JPA Entity to represent a record store sale for an artist.
 *
 * @author BJM
 * @since 20251024
 */
@Entity
@Table(name = "recordsale")
@XmlRootElement
public class ArtistSaleList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "artistName")
    private String artistName;

    @Basic(optional = false)
    @Column(name = "albumName")
    private String albumName;

    @Basic(optional = false)
    @Column(name = "dateOfSale")
    private String dateOfSale;

    @Basic(optional = false)
    @Column(name = "unitsSold")
    private int unitsSold;

    @Basic(optional = false)
    @Column(name = "saleAmount")
    private BigDecimal saleAmount;

    // --- Getters & Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getArtistName() { return artistName; }
    public void setArtistName(String artistName) { this.artistName = artistName; }

    public String getAlbumName() { return albumName; }
    public void setAlbumName(String albumName) { this.albumName = albumName; }

    public String getDateOfSale() { return dateOfSale; }
    public void setDateOfSale(String dateOfSale) { this.dateOfSale = dateOfSale; }

    public int getUnitsSold() { return unitsSold; }
    public void setUnitsSold(int unitsSold) { this.unitsSold = unitsSold; }

    public BigDecimal getSaleAmount() { return saleAmount; }
    public void setSaleAmount(BigDecimal saleAmount) { this.saleAmount = saleAmount; }

    @Override
    public String toString() {
        return "ArtistSaleList{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", dateOfSale='" + dateOfSale + '\'' +
                ", unitsSold=" + unitsSold +
                ", saleAmount=" + saleAmount +
                '}';
    }
}
