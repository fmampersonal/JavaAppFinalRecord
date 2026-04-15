package info.hccis.recordstore.jpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "RecordStoreSalesTracker")
public class ArtistSaleList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dateOfSale", nullable = false, length = 10)
    private String dateOfSale;  // matches "dateOfSale" column in database

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "customerName", nullable = false, length = 50)
    private String customerName;  // matches "customerName" column in database

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "artistName", nullable = false, length = 50)
    private String artistName;  // matches "artistName" column in database

    @Size(max = 10)
    @Column(name = "formatType", length = 10)
    private String formatType;  // matches "formatType" column in database

    @Column(name = "albumPrice")
    private Float albumPrice;  // matches "albumPrice" column in database

    @Column(name = "giftWrapped")
    private Boolean giftWrapped;  // matches "giftWrapped" column in database

    @Column(name = "subtotal")
    private Integer subtotal;  // matches "subtotal" column in database

    @Column(name = "totalCost")
    private Float totalCost;  // matches "totalCost" column in database

    @Column(name = "unitsSold")
    private Integer unitsSold;  // matches "unitsSold" column in database

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getFormatType() {
        return formatType;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }

    public Float getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(Float albumPrice) {
        this.albumPrice = albumPrice;
    }

    public Boolean getGiftWrapped() {
        return giftWrapped;
    }

    public void setGiftWrapped(Boolean giftWrapped) {
        this.giftWrapped = giftWrapped;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(Integer unitsSold) {
        this.unitsSold = unitsSold;
    }

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
                ", unitsSold=" + unitsSold +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArtistSaleList)) return false;
        ArtistSaleList that = (ArtistSaleList) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
