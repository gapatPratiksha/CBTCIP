import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public boolean createAccount(String accountId, String accountHolder) {
        if (accounts.containsKey(accountId)) {
            return false;
        }
        accounts.put(accountId, new Account(accountId, accountHolder));
        return true;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public boolean transferFunds(String fromAccountId, String toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            return false;
        }

        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public void printAccounts() {
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }
}
