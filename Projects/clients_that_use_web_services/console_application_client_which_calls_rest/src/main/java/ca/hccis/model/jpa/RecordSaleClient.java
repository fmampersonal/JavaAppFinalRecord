package ca.hccis.model.jpa;

import java.util.Scanner;

/**
 * Console-based client object for entering or updating a Record Sale.
 * Mirrors the fields in ArtistSaleList and is intended for REST operations.
 *
 * @author
 */
public class RecordSaleClient {

    private Integer id = 0;
    private String dateOfSale;
    private String customerName;
    private String artistName;
    private String formatType;
    private float albumPrice;
    private boolean giftWrapped;
    private int subtotal;
    private float totalCost;
    private int unitsSold;

    /**
     * Collects input from the user for all fields EXCEPT id,
     * because ID is assigned by REST or provided in update.
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Enter Record Sale Details ---");

        System.out.print("Customer Name: ");
        this.customerName = input.nextLine();

        System.out.print("Artist Name: ");
        this.artistName = input.nextLine();

        System.out.print("Format Type (CD, Vinyl, Digital): ");
        this.formatType = input.nextLine();

        // Units Sold
        while (true) {
            System.out.print("Units Sold: ");
            try {
                this.unitsSold = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number. Try again.");
            }
        }

        // Album Price
        while (true) {
            System.out.print("Album Price: ");
            try {
                this.albumPrice = Float.parseFloat(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid price. Try again.");
            }
        }

        // Gift Wrapped
        while (true) {
            System.out.print("Gift Wrapped (true/false): ");
            String gw = input.nextLine().trim().toLowerCase();
            if (gw.equals("true") || gw.equals("false")) {
                this.giftWrapped = Boolean.parseBoolean(gw);
                break;
            } else {
                System.out.println("❌ Enter 'true' or 'false'.");
            }
        }

        System.out.println("\n(📌 subtotal and totalCost will be calculated by the server.)\n");
    }

    // ---------------- GETTERS & SETTERS ----------------

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

    public float getAlbumPrice() { return albumPrice; }
    public void setAlbumPrice(float albumPrice) { this.albumPrice = albumPrice; }

    public boolean isGiftWrapped() { return giftWrapped; }
    public void setGiftWrapped(boolean giftWrapped) { this.giftWrapped = giftWrapped; }

    public int getSubtotal() { return subtotal; }
    public void setSubtotal(int subtotal) { this.subtotal = subtotal; }

    public float getTotalCost() { return totalCost; }
    public void setTotalCost(float totalCost) { this.totalCost = totalCost; }

    public int getUnitsSold() { return unitsSold; }
    public void setUnitsSold(int unitsSold) { this.unitsSold = unitsSold; }

    @Override
    public String toString() {
        return "\nRecordSaleClient {" +
                "\n  id = " + id +
                "\n  dateOfSale = '" + dateOfSale + '\'' +
                "\n  customerName = '" + customerName + '\'' +
                "\n  artistName = '" + artistName + '\'' +
                "\n  formatType = '" + formatType + '\'' +
                "\n  albumPrice = $" + albumPrice +
                "\n  giftWrapped = " + giftWrapped +
                "\n  subtotal = " + subtotal +
                "\n  totalCost = $" + totalCost +
                "\n  unitsSold = " + unitsSold +
                "\n}";
    }
}
