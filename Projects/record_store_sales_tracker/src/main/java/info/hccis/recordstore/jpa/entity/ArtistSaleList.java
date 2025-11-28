package info.hccis.recordstore.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RecordStoreSalesTracker")
public class ArtistSaleList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "dateOfSale")
    private String dateOfSale;

    @Basic(optional = false)
    @Column(name = "customerName")
    private String customerName;

    @Basic(optional = false)
    @Column(name = "artistName")
    private String artistName;

    @Basic(optional = false)
    @Column(name = "formatType")
    private String formatType;

    @Basic(optional = false)
    @Column(name = "albumPrice")
    private Float albumPrice;

    @Basic(optional = false)
    @Column(name = "giftWrapped")
    private Boolean giftWrapped;

    @Basic(optional = false)
    @Column(name = "subtotal")
    private Integer subtotal;

    @Basic(optional = false)
    @Column(name = "totalCost")
    private Float totalCost;

    @Column(name = "unitsSold")
    private Integer unitsSold;

    @Column(name = "saleAmount")
    private Float saleAmount;

    @Basic(optional = false)
    @Column(name = "albumName")
    private String albumName;

    // ----- Getters and Setters -----
    // Add getters & setters
    public Integer getUnitsSold() { return unitsSold; }
    public void setUnitsSold(Integer unitsSold) { this.unitsSold = unitsSold; }

    public Float getSaleAmount() { return saleAmount; }
    public void setSaleAmount(Float saleAmount) { this.saleAmount = saleAmount; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDateOfSale() { return dateOfSale; }
    public void setDateOfSale(String dateOfSale) { this.dateOfSale = dateOfSale; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getArtistName() { return artistName; }
    public void setArtistName(String artistName) { this.artistName = artistName; }

    public String getFormatType() { return formatType; }
    public void setFormatType(String formatType) { this.formatType = formatType; }

    public Float getAlbumPrice() { return albumPrice; }
    public void setAlbumPrice(Float albumPrice) { this.albumPrice = albumPrice; }

    public Boolean getGiftWrapped() { return giftWrapped; }
    public void setGiftWrapped(Boolean giftWrapped) { this.giftWrapped = giftWrapped; }

    public Integer getSubtotal() { return subtotal; }
    public void setSubtotal(Integer subtotal) { this.subtotal = subtotal; }

    public Float getTotalCost() { return totalCost; }
    public void setTotalCost(Float totalCost) { this.totalCost = totalCost; }


    public String getAlbumName() { return albumName; }
    public void setAlbumName(String albumName) { this.albumName = albumName; }
    @Override
    public String toString() {
        return "ArtistSaleList{" +
                "id=" + id +
                ", dateOfSale='" + dateOfSale + '\'' +
                ", customerName='" + customerName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", formatType='" + formatType + '\'' +
                ", albumPrice=" + albumPrice +
                ", giftWrapped=" + giftWrapped +
                ", subtotal=" + subtotal +
                ", totalCost=" + totalCost +
                '}';
    }
}
