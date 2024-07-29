import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Display Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Account ID: ");
                    String accountId = scanner.nextLine();
                    System.out.print("Enter Account Holder: ");
                    String accountHolder = scanner.nextLine();
                    if (bank.createAccount(accountId, accountHolder)) {
                        System.out.println("Account created successfully.");
                    } else {
                        System.out.println("Account ID already exists.");
                    }
                    break;
                case "2":
                    System.out.print("Enter Account ID: ");
                    accountId = scanner.nextLine();
                    Account account = bank.getAccount(accountId);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    scanner.nextLine();  // Consume newline
                    break;
                case "3":
                    System.out.print("Enter Account ID: ");
                    accountId = scanner.nextLine();
                    account = bank.getAccount(accountId);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    scanner.nextLine();  // Consume newline
                    break;
                case "4":
                    System.out.print("Enter from Account ID: ");
                    String fromAccountId = scanner.nextLine();
                    System.out.print("Enter To Account ID: ");
                    String toAccountId = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    if (bank.transferFunds(fromAccountId, toAccountId, transferAmount)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed.");
                    }
                    scanner.nextLine();  // Consume newline
                    break;
                case "5":
                    bank.printAccounts();
                    break;
                case "6":
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (!choice.equals("6"));

        scanner.close();
    }
}
