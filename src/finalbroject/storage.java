package finalbroject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class storage {

    public static ArrayList<Book> Books = new ArrayList();
    public static ArrayList<User> Users = new ArrayList();
    public static ArrayList<Librarian> Librarians = new ArrayList();
    public static Queue<Order> Orders = new LinkedList();

    public static boolean checkPassword(String password, String Id) {
        if (findUser(Id).getPassword().equals(password)) {
            return true;
        } else {
            System.out.println("Wrong password");
            return false;
        }
    }

    public static String checkUserId(String Id) {
        if (findUser(Id) != null) {
            return findUser(Id).getType();
        } else if (findLibrarian(Id) != null) {
            return "Librarian";
        } else {
            System.out.println("Wrong user ID 😓");
            return null;
        }
    }

    public static void showAvailableBooks() {
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).getStatus().equals("available")) {
                System.out.println(i + " book name : " + Books.get(i).getName() + " book ISBN : " + Books.get(i).getISBN());
                Books.get(i).showBorrowHistory();
            }
        }
    }

    public static Book findBook(String ISBN) {
        for (int i = 0; i < Books.size(); i++) {
            if (ISBN.equals(Books.get(i).getISBN())) {
                return Books.get(i);
            }
        }
        return null;
    }

    public static User findUser(String Id) {
        for (int i = 0; i < Users.size(); i++) {
            if (Id.equals(Users.get(i).getID())) {
                return Users.get(i);
            }
        }
        return null;
    }

    public static Librarian findLibrarian(String Id) {
        for (int i = 0; i < Librarians.size(); i++) {
            if (Id.equals(Librarians.get(i).getID())) {
                return Librarians.get(i);
            }
        }
        return null;
    }
}
