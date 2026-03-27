package fintech.model;

public class DepositTransaction extends Transaction {
    public DepositTransaction(String username, double amount, String timestamp, String description) {
        super(username, amount, timestamp, description);
    }

    @Override
    public String getType() {
        return "deposit";
    }
}