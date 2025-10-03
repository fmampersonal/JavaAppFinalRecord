package ca.hccis.recordstore;

import ca.hccis.recordstore.manager.SalesManager;
import ca.hccis.recordstore.threads.Thread1;
import ca.hccis.recordstore.threads.Thread2;
import ca.hccis.recordstore.util.CisUtility;

/**
 * @author Farhan
 * @since 2025-09
 */
// Controller was modified to implement threads====

public class Controller {
    public static void main(String[] args) {
        System.out.println(" Welcome to the Record Sale Program ");

        Thread1 thread1 = new Thread1(); // Console
        Thread2 thread2 = new Thread2(); // GUI

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println(" All entries complete.");
        System.out.println(" Total entries recorded: " + SalesManager.getSaleCount());

        // Tried to add this to keep my functionality of viewing sales like assignment 2. But needs further improvements for smoother functionality  =====
        boolean viewSales = CisUtility.getInputBoolean("Would you like to view all sales?");
        if (viewSales) {
            SalesManager.displayAllSales();
        }

        System.out.println(" Program finished. Goodbye!");

    }
}

