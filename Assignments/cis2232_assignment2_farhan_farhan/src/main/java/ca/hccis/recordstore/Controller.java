package ca.hccis.recordstore;

import ca.hccis.recordstore.entity.RecordSale;
import ca.hccis.recordstore.util.CisUtility;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;

/**
 * @author Farhan
 * @since 2025-09
 */

public class Controller {

    public static final int EXIT = 0;
    public static final String MENU = "1) Add Sale" + System.lineSeparator()
            +"2) View Sales" + System.lineSeparator()
            + EXIT + ") Exit"
            + System.lineSeparator();
    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye!";
    public static final String MESSAGE_SUCCESS = "Success";
    public static final String PATH = "C:\\CIS2232\\";
    public static final String FILE_NAME = "data_farhan_farhan.json";

    private static Path journalPath = Paths.get(PATH);
    private static FileWriter journalWriter = null;

    public static void main(String[] args) {

        journalPath = Paths.get(PATH + FILE_NAME);

//        // Creating a directory if it doesn't exist
         File directory = new File(PATH);

        if (!directory.exists()) {
            directory.mkdir();
        }

        try {
            journalWriter = new FileWriter(journalPath.toString(), true);
        } catch (IOException e) {
            System.out.println("Error opening file.");
            throw new RuntimeException(e);
        }

        int menuOption;
        do {
            menuOption = CisUtility.getInputInt(MENU);
            switch (menuOption) {
                case 1:
                    processAdd();
                    break;
                case 2:
                    processShow();
                    break;
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);

        try {
            journalWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void processAdd() {
        RecordSale sale = new RecordSale();
        sale.getInformation();

        try {
            journalWriter.write(sale.toJson() + System.lineSeparator());
            journalWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    private static void processShow() {
        Gson gson = new Gson();
        try {
            List<String> lines = Files.readAllLines(Paths.get(PATH + FILE_NAME));
            if (lines.isEmpty()) {
                System.out.println("No sales found.");
            } else {
                System.out.println("Here are the sales we found");
                for (String line : lines) {
                    RecordSale sale = gson.fromJson(line, RecordSale.class);
                    System.out.println(sale);
                    System.out.println("----------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
            throw new RuntimeException(e);
        }
    }
}
