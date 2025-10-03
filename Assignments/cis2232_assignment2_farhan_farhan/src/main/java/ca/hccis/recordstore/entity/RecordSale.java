package ca.hccis.recordstore.entity;

import ca.hccis.recordstore.util.CisUtility;
import com.google.gson.Gson;

/**
 * * @author Farhan
 * @since 2025-09
 */

public class RecordSale {
    // ===== Constants (for format pricing, tax, and gift wrap fee) =====
    private static final double VINYL_PRICE = 15.0;
    private static final double CD_PRICE = 10.0;
    private static final double CASSETTE_PRICE = 5.0;
    private static final double TAX_RATE = 0.15;
    private static final double GIFT_WRAP_FEE = 2.0;

    // ===== Static ID tracking =====
    private static int nextId = 1;

    // ===== Fields =====
    private int id;
    private String transactionDate;
    private String customerName;
    private String albumTitle;
    private String artistName;
    private String formatType; // Vinyl, CD, or Cassette
    private double albumPrice;
    private boolean giftWrapped;
    private double subtotal;
    private double totalCost;

    // ===== Constructor =====
    public RecordSale() {
        this.id = nextId++;
    }

    // ===== Input Method =====
    public void getInformation() {
        transactionDate = CisUtility.getInputString("Enter transaction date (yyyy-MM-dd): ");
        customerName = CisUtility.getInputString("Enter customer name: ");
        albumTitle = CisUtility.getInputString("Enter album title: ");
        artistName = CisUtility.getInputString("Enter artist name: ");

        do {
            formatType = CisUtility.getInputString("Enter format (Vinyl, CD, Cassette): ").trim();
        } while (!formatType.equalsIgnoreCase("Vinyl") &&
                !formatType.equalsIgnoreCase("CD") &&
                !formatType.equalsIgnoreCase("Cassette"));

        switch (formatType.toLowerCase()) {
            case "vinyl":
                albumPrice = VINYL_PRICE;
                break;
            case "cd":
                albumPrice = CD_PRICE;
                break;
            case "cassette":
                albumPrice = CASSETTE_PRICE;
                break;
        }

        giftWrapped = CisUtility.getInputString("Gift wrap? (Y/N): ").equalsIgnoreCase("Y");

        calculateTotals();
    }

    // ===== Calculation Logic =====
    public void calculateTotals() {
        subtotal = albumPrice + (giftWrapped ? GIFT_WRAP_FEE : 0);
        totalCost = subtotal * (1 + TAX_RATE);
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getAlbumPrice() {
        return albumPrice;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
        switch (formatType.toLowerCase()) {
            case "vinyl": albumPrice = VINYL_PRICE; break;
            case "cd": albumPrice = CD_PRICE; break;
            case "cassette": albumPrice = CASSETTE_PRICE; break;
        }
    }

    public void setGiftWrapped(boolean giftWrapped) {
        this.giftWrapped = giftWrapped;
    }


    // ===== JSON Serialization =====
    public String toJson() {
        return new Gson().toJson(this);
    }

    // ===== ToString for Display =====
    @Override
    public String toString() {
        return "Transaction ID: " + id +
                "\nDate: " + transactionDate +
                "\nCustomer: " + customerName +
                "\nAlbum: " + albumTitle +
                "\nArtist: " + artistName +
                "\nFormat: " + formatType +
                "\nAlbum Price: $" + albumPrice +
                "\nGift Wrapped: " + (giftWrapped ? "Yes" : "No") +
                "\nSubtotal: $" + String.format("%.2f", subtotal) +
                "\nTotal Cost (with tax): $" + String.format("%.2f", totalCost);
    }
}
