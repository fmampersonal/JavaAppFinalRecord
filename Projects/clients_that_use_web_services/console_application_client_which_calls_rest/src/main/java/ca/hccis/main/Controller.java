package ca.hccis.main;

import ca.hccis.student.util.UtilityRest;
import com.google.gson.Gson;
import ca.hccis.model.jpa.RecordSaleClient;

import org.json.JSONArray;

import java.util.Scanner;

public class Controller {

    final public static String MENU = "\nRecord Store - Main Menu \n"
            + "A) Add Sale (REST)\n"
            + "U) Update Sale (REST)\n"
            + "V) View All Sales (REST)\n"
            + "R) Read Sale by ID (REST)\n"
            + "G) Get by ID (SOAP)\n"
            + "D) Delete Sale (REST)\n"
            + "X) Exit";

    final static Scanner input = new Scanner(System.in);

    // Your REST base URL
    private static final String URL_STRING = "http://localhost:8080/api/RecordSaleService/sales";

    public static void main(String[] args) {

        boolean endProgram = false;

        do {
            System.out.println(MENU);
            System.out.print("Enter choice: ");
            String choice = input.nextLine();

            RecordSaleClient sale;
            String url = URL_STRING;

            switch (choice.toUpperCase()) {

                // ---------------- ADD ----------------
                case "A":
                    sale = create();
                    System.out.println("Sending sale to: " + url);

                    Object response = UtilityRest.addUsingRest(url, sale);
                    if (response != null) {
                        System.out.println("Sale successfully added!");
                    }
                    break;

                // ---------------- UPDATE ----------------
                case "U":
                    System.out.print("Enter ID of sale to update: ");
                    int idToUpdate = Integer.parseInt(input.nextLine());

                    RecordSaleClient updatedSale = create(); // re-enter all fields
                    updatedSale.setId(idToUpdate);           // assign ID for update

                    System.out.println("Updating sale with ID: " + idToUpdate);

                    RecordSaleClient updatedResponse =
                            (RecordSaleClient) UtilityRest.updateUsingRest(url, updatedSale);

                    if (updatedResponse != null) {
                        System.out.println("Updated Sale:");
                        System.out.println(updatedResponse.toString());
                    }
                    break;

                // ---------------- READ BY ID ----------------
                case "R":
                    System.out.print("Enter ID of sale to retrieve via REST: ");
                    try {
                        int idToGet = Integer.parseInt(input.nextLine());

                        RecordSaleClient saleForIdView =
                                (RecordSaleClient) UtilityRest.getByIdUsingRest(URL_STRING, idToGet);

                        if (saleForIdView != null) {
                            System.out.println("\n✔ Retrieved via REST:");
                            System.out.println(saleForIdView.toString());
                        } else {
                            System.out.println("❌ No sale found with ID " + idToGet);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;

                // ---------------- DELETE ----------------
                case "D":
                    System.out.print("Enter ID to delete: ");
                    try {
                        int id = Integer.parseInt(input.nextLine());
                        UtilityRest.deleteUsingRest(url, id);
                        System.out.println("Delete request sent.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format.");
                    }
                    break;

                // ---------------- VIEW ALL ----------------
                case "V":
                    String jsonReturned = UtilityRest.getJsonFromRest(url);

                    if (jsonReturned == null || jsonReturned.isEmpty()) {
                        System.out.println("No data available or server unreachable.");
                        break;
                    }

                    System.out.println("\n--- Current Record Sales ---\n");

                    JSONArray jsonArray = new JSONArray(jsonReturned);
                    Gson gson = new Gson();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        RecordSaleClient current =
                                gson.fromJson(jsonArray.getJSONObject(i).toString(), RecordSaleClient.class);
                        System.out.println(current.toString());
                    }
                    break;

                // ---------------- SOAP REDIRECT ----------------
                case "G":
                    System.out.println("\nPlease run the SOAP client application.\n");
                    break;

                case "X":
                    endProgram = true;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("INVALID OPTION!");
            }

        } while (!endProgram);
    }

    /**
     * Helper to create a RecordSaleClient and fill data.
     */
    public static RecordSaleClient create() {
        RecordSaleClient sale = new RecordSaleClient();
        sale.getInformation();
        return sale;
    }
}
