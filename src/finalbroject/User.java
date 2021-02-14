package finalbroject;

import static finalbroject.storage.Books;
import java.util.Stack;

public class User {

    private String ID;
    private String name;
    private String password;

    public User(String ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    public String getType() {
        return null;
    }

    Stack<Book> borrowingHistory = new Stack();

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void borrow(String ISBN) {
        if (storage.findBook(ISBN) != null) {
            Book tempBook = storage.findBook(ISBN);
            if (tempBook.getStatus().equals("available")) {
                tempBook.setCurrentOwner(this);
                tempBook.setStatus("borrowed");
                tempBook.borrowingHistory.push(this);
                this.borrowingHistory.push(tempBook);
            } else {
                System.out.println("this book is borrowed");
            }
        }
    }

    public void showBorrowHistory() {
        for (Book obj : borrowingHistory) {
            System.out.println("    -" + obj.getName());
        }
    }

    public void clearBorrowHistory() {
        borrowingHistory.clear();
    }

    public Book findBookByName(String name) {
        if (storage.findBook(name) == null) {
            for (int i = 0; i < Books.size(); i++) {
                if (name.equalsIgnoreCase(Books.get(i).getName())) {
                    return Books.get(i);
                }
            }
        }
        return storage.findBook(name);
    }
}
