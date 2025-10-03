package ca.hccis.recordstore.manager;


import ca.hccis.recordstore.entity.RecordSale;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SalesManager {

    private static final String PATH = "C:\\CIS2232\\";
    private static final String FILE_NAME = "data_farhan_farhan.json";

    private static final Path FILE_PATH = Paths.get(PATH + FILE_NAME);
    private static final AtomicInteger saleCount = new AtomicInteger(0);

    static {
        // Ensure directory exists
        try {
            Files.createDirectories(Paths.get(PATH));
            if (!Files.exists(FILE_PATH)) {
                Files.createFile(FILE_PATH);
            }
        } catch (IOException e) {
            System.out.println(" Failed to create path or file: " + e.getMessage());
        }
    }

    public synchronized static void writeSale(RecordSale sale) {
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write(sale.toJson());
            writer.newLine();  // Equivalent to System.lineSeparator()
            int currentCount = saleCount.incrementAndGet();
            System.out.println(" Sale recorded. Total sales so far: " + currentCount);
        } catch (IOException e) {
            System.out.println(" Error writing sale: " + e.getMessage());
        }
    }

    public static int getSaleCount() {
        return saleCount.get();
    }

    public static void displayAllSales() {
        try {
            List<String> lines = Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8);
            if (lines.isEmpty()) {
                System.out.println(" No sales found.");
            } else {
                System.out.println(" Sales found:");
                for (String line : lines) {
                    System.out.println(line);
                    System.out.println("----------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println(" Error reading from file: " + e.getMessage());
        }
    }
}
