package ca.hccis.recordstore.threads;

// Thread2.java

import ca.hccis.recordstore.entity.RecordSale;
import ca.hccis.recordstore.manager.SalesManager;

import javax.swing.*;

// ===== Thread 2 =====
public class Thread2 extends Thread {
    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, " Thread 2 (GUI) started.");

        while (true) {
            RecordSale sale = new RecordSale();
            sale.getInformationGui();
            SalesManager.writeSale(sale);

            int choice = JOptionPane.showConfirmDialog(null, "Add another via GUI?", "Continue?",
                    JOptionPane.YES_NO_OPTION);
            if (choice != JOptionPane.YES_OPTION) break;
        }

        JOptionPane.showMessageDialog(null, " Thread 2 (GUI) finished.");
    }
}
