package fintech.driver;
import fintech.model.Account;
import java.util.*;

/** 
 * @author 12S24043 Desnita Pardosi
 */

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new LinkedHashMap<>();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("---")) break;

            if (line.startsWith("create-account")) {
                String[] parts = line.split("#");
                String name = parts[1];
                String username = parts[2];
                accounts.put(username, new Account(name, username));
            }
        }

        for (Account acc : accounts.values()) {
            System.out.println(acc.getUsername() + "|" + acc.getName() + "|" + acc.getBalance());
        }
    }
}