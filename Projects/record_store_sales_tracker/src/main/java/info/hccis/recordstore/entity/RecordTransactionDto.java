package info.hccis.recordstore.entity;

import info.hccis.recordstore.jpa.entity.RecordTransaction;

import java.util.ArrayList;
import java.util.List;

public class RecordTransactionDto {

    private List<RecordTransaction> transactions;

    // Default constructor
    public RecordTransactionDto() {
        this.transactions = new ArrayList<>();
    }

    // Parameterized constructor
    public RecordTransactionDto(List<RecordTransaction> transactions) {
        this.transactions = transactions;
    }

    // Method to add a single transaction to the list
    public void addRecordTransaction(RecordTransaction recordTransaction) {
        this.transactions.add(recordTransaction);
    }

    // Getter and Setter for transactions
    public List<RecordTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<RecordTransaction> transactions) {
        this.transactions = transactions;
    }
}
