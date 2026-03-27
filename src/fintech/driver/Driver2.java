package fintech.driver;
import fintech.model.*;
import java.util.*;

/** 
 * @author 12S24043 Desnita Pardosi
 */

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new LinkedHashMap<>();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("---")) break;

            String[] parts = line.split("#");

            switch (parts[0]) {
                case "create-account":
                    accounts.put(parts[2], new Account(parts[1], parts[2]));
                    break;
                case "deposit":
                    Account depAcc = accounts.get(parts[1]);
                    DepositTransaction deposit = new DepositTransaction(parts[1],
                            Double.parseDouble(parts[2]), parts[3], parts[4]);
                    depAcc.deposit(Double.parseDouble(parts[2]), deposit);
                    break;
                case "withdraw":
                    Account withAcc = accounts.get(parts[1]);
                    WithdrawTransaction withdraw = new WithdrawTransaction(parts[1],
                            Double.parseDouble(parts[2]), parts[3], parts[4]);
                    try {
                        withAcc.withdraw(Double.parseDouble(parts[2]), withdraw);
                    } catch (NegativeBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        for (Account acc : accounts.values()) {
            System.out.println(acc.getUsername() + "|" + acc.getName() + "|" + acc.getBalance());
        }
    }
}