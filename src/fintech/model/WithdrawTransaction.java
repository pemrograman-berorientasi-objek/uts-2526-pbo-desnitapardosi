package fintech.model;

public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(String username, double amount, String timestamp, String description) {
        super(username, -amount, timestamp, description);
    }

    @Override
    public String getType() {
        return "withdraw";
    }
}