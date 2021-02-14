package finalbroject;

import java.util.Iterator;
import java.util.Stack;

public class Book {

    public Book() {
    }

    public Book(String ISBN, String name, String status, User currentOwner) {
        this.ISBN = ISBN;
        this.name = name;
        this.status = status;
    }

    public User getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(User currentOwner) {
        this.currentOwner = currentOwner;
    }

    private String ISBN;
    private String name;
    private String status;//(borrowed or available)
    private User currentOwner;

    Stack<User> borrowingHistory = new Stack();

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void showBorrowHistory() {
        System.out.println("Borrowed by: ");
        for (User obj : borrowingHistory) {
            System.out.println("-" + obj.getName());
        }
    }

    public void clearBorrowHistory() {
        borrowingHistory.clear();
    }

    public void printRebort() {
        System.out.println(this.ISBN + " , " + this.name + " , " + this.status);
        showBorrowHistory();
    }
}
