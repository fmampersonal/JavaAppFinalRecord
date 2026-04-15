package org.example;

import org.example.soaprecord.ArtistSaleList;
import org.example.soaprecord.RecordSaleServiceSOAP;
import org.example.soaprecord.RecordSaleServiceSOAPImplService;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String WSDL_URL =
            "http://localhost:8083/recordsalesoapservice?wsdl";

    // ---------------- MENU -----------------
    public static final String MENU =
            "\nRecord Store SOAP Client\n" +
                    "=========================\n" +
                    "A) Get ALL Sales (SOAP)\n" +
                    "G) Get Sale By ID (SOAP)\n" +
                    "X) Exit\n";

    // ============ MAIN LOOP ==============
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String option;

        do {
            System.out.println(MENU);
            System.out.print("Enter option: ");
            option = input.nextLine().toUpperCase();

            switch (option) {

                case "A":
                    getAllSalesSOAP();
                    break;

                case "G":
                    getSaleByIdSOAP(input);
                    break;

                case "X":
                    System.out.println("Exiting client...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (!option.equals("X"));

        input.close();
    }

    // ============ GET ALL SALES (SOAP) ============
    public static void getAllSalesSOAP() {
        try {
            URL wsdl = new URL(WSDL_URL);

            RecordSaleServiceSOAPImplService service =
                    new RecordSaleServiceSOAPImplService(wsdl);

            RecordSaleServiceSOAP port =
                    service.getRecordSaleServiceSOAPImplPort();

            List<ArtistSaleList> list = port.getAllSales();

            System.out.println("\n=== ALL SALES (SOAP) ===");
            if (list == null || list.isEmpty()) {
                System.out.println("No sales returned.");
                return;
            }

            for (ArtistSaleList sale : list) {
                System.out.println(
                        "ID: " + sale.getId() +
                                " | Artist: " + sale.getArtistName() +
                                " | Customer: " + sale.getCustomerName() +
                                " | Date: " + sale.getDateOfSale() +
                                " | Total: $" + sale.getTotalCost()
                );
            }

        } catch (Exception e) {
            System.out.println("❌ SOAP ERROR: Could not connect to service.");
        }
    }

    // ============ GET SALE BY ID (SOAP) ============
    public static void getSaleByIdSOAP(Scanner input) {

        System.out.print("Enter sale ID: ");

        try {
            int id = Integer.parseInt(input.nextLine());

            URL wsdl = new URL(WSDL_URL);

            RecordSaleServiceSOAPImplService service =
                    new RecordSaleServiceSOAPImplService(wsdl);

            RecordSaleServiceSOAP port =
                    service.getRecordSaleServiceSOAPImplPort();

            ArtistSaleList sale = port.getSaleById(id);

            if (sale != null) {
                System.out.println("\n=== SALE FOUND ===");
                System.out.println("ID: " + sale.getId());
                System.out.println("Date: " + sale.getDateOfSale());
                System.out.println("Customer: " + sale.getCustomerName());
                System.out.println("Artist: " + sale.getArtistName());
                System.out.println("Format: " + sale.getFormatType());
                System.out.println("Album Price: $" + sale.getAlbumPrice());
                System.out.println("Gift Wrapped: " + sale.isGiftWrapped());
                System.out.println("Subtotal: $" + sale.getSubtotal());
                System.out.println("Total Cost: $" + sale.getTotalCost());
                System.out.println("Units Sold: " + sale.getUnitsSold());
            } else {
                System.out.println("❌ No sale found for ID = " + id);
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer ID.");
        } catch (Exception e) {
            System.out.println("❌ SOAP ERROR: Could not retrieve sale.");
        }
    }
}
