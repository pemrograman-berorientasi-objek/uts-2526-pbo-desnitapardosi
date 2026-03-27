package fintech.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Transaction {
    private static int counter = 1;
    protected int id;
    protected String username;
    protected double amount;
    protected String timestamp;
    protected String description;

    public Transaction(String username, double amount, String timestamp, String description) {
        this.id = counter++;
        this.username = username;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public double getAmount() { return amount; }
    public String getTimestamp() { return timestamp; }
    public String getDescription() { return description; }

    public abstract String getType();
}