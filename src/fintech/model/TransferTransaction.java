package fintech.model;

public class TransferTransaction extends Transaction {
    private String receiver;

    public TransferTransaction(String sender, String receiver, double amount, String timestamp, String description) {
        super(sender, -amount, timestamp, description);
        this.receiver = receiver;
    }

    public String getReceiver() { return receiver; }

    @Override
    public String getType() {
        return "transfer";
    }
}