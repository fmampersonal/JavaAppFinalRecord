package info.hccis.recordstore.jpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "RecordStoreSalesTracker")
public class RecordTransaction {

    @Transient
    private String transactionCode;  // Not a column in the database

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(min = 1, max = 10)
    @NotNull
    @Column(name = "dateOfSale", nullable = false, length = 10)  // Matches the database column name
    private String dateOfSale;

    @Size(min = 1, max = 50)
    @NotNull
    @Column(name = "customerName", nullable = false, length = 50)  // Matches the database column name
    private String customerName;

    @Size(min = 1, max = 50)
    @NotNull
    @Column(name = "artistName", nullable = false, length = 50)  // Matches the database column name
    private String artistName;

    @Size(max = 10)
    @Column(name = "formatType", length = 10)
    private String formatType;

    @Column(name = "albumPrice")
    private Float albumPrice;

    @Column(name = "giftWrapped")
    private Boolean giftWrapped;

    @Column(name = "subtotal")
    private Integer subtotal;

    @Column(name = "totalCost")
    private Float totalCost;

    @Column(name = "unitsSold")
    private Integer unitsSold;

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
        return "RecordTransaction{" +
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
        if (!(o instanceof RecordTransaction)) return false;
        RecordTransaction that = (RecordTransaction) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
