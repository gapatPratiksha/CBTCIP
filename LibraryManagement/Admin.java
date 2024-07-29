
public class Admin {
    private String name;
    private String adminId;

    public Admin(String name, String adminId) {
        this.name = name;
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public String getAdminId() {
        return adminId;
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }

    public void removeBook(Library library, String ISBN) {
        library.removeBook(ISBN);
    }

    public void addUser(Library library, User user) {
        library.addUser(user);
    }

    public void removeUser(Library library, String userId) {
        library.removeUser(userId);
    }
}