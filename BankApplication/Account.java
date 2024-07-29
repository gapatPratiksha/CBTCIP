

public class Account {
    private String accountId;
    private String accountHolder;
    private double balance;

    public Account(String accountId, String accountHolder) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " into account " + accountId);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from account " + accountId);
            return true;
        }
        System.out.println("Failed to withdraw " + amount + " from account " + accountId);
        return false;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId='" + accountId + '\'' + ", accountHolder='" + accountHolder + '\'' + ", balance=" + balance + '}';
    }
}
