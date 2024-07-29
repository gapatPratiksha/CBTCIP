
import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books;
    ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getISBN() + ") - " + (book.isIssued() ? "Issued" : "Available"));
        }
    }

    public void issueBook(String ISBN, String userId) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && !book.isIssued()) {
                book.issueBook();
                System.out.println("Book issued to user ID: " + userId);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
    }
}