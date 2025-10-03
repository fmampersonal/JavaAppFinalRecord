package ca.hccis.recordstore.threads;


import ca.hccis.recordstore.entity.RecordSale;
import ca.hccis.recordstore.manager.SalesManager;

// ===== Thread 1 =====
public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println(" Thread 1 (Console) started.");
        while (true) {
            RecordSale sale = new RecordSale();
            sale.getInformationConsole();
            SalesManager.writeSale(sale);

            String more = ca.hccis.recordstore.util.CisUtility.getInputString("Add another via console? (Y/N): ");
            if (!more.equalsIgnoreCase("Y")) break;
        }
        System.out.println(" Thread 1 (Console) finished.");
    }
}
