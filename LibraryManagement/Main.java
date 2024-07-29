import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Library Admin", "A001");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Add a user");
            System.out.println("3. Display all books");
            System.out.println("4. Issue a book");
            System.out.println("5. Return a book");
            System.out.println("6. Send a user query");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = scanner.nextLine();
                    Book book = new Book(title, author, ISBN);
                    admin.addBook(library, book);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    User user = new User(name, userId);
                    admin.addUser(library, user);
                    break;
                case 3:
                    System.out.println("Books in library:");
                    library.displayBooks();
                    break;
                case 4:
                    System.out.print("Enter book ISBN to issue: ");
                    String issueISBN = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String issueUserId = scanner.nextLine();
                    library.issueBook(issueISBN, issueUserId);
                    break;
                case 5:
                    System.out.print("Enter book ISBN to return: ");
                    String returnISBN = scanner.nextLine();
                    library.returnBook(returnISBN);
                    break;
                case 6:
                    System.out.print("Enter user ID to send query: ");
                    String queryUserId = scanner.nextLine();
                    System.out.print("Enter query: ");
                    String query = scanner.nextLine();
                    for (User u : library.users) {
                        if (u.getUserId().equals(queryUserId)) {
                            u.sendQuery(query);
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}





