package fintech.model;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private String username;
    private double balance;
    private List<Transaction> transactions;

    public Account(String name, String username) {
        this.name = name;
        this.username = username;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getUsername() { return username; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactions() { return transactions; }

    public void deposit(double amount, Transaction transaction) {
        balance += amount;
        transactions.add(transaction);
    }

    public void withdraw(double amount, Transaction transaction) throws NegativeBalanceException {
        if (balance - amount < 0) {
            throw new NegativeBalanceException("Insufficient balance for withdrawal!");
        }
        balance -= amount;
        transactions.add(transaction);
    }

    public void transferTo(Account receiver, double amount, Transaction transaction) throws NegativeBalanceException {
        if (balance - amount < 0) {
            throw new NegativeBalanceException("Insufficient balance for transfer!");
        }
        balance -= amount;
        receiver.deposit(amount, transaction);
        transactions.add(transaction);
    }
}