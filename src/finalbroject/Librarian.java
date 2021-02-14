package finalbroject;

public class Librarian {

    public Librarian() {
    }

    public Librarian(String ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    private String ID;
    private String name;
    private String password;

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

    public void borrowingRequests() {

    }

    public void acceptReturnedBooks(String ID) {
        if (storage.findBook(ID) != null) {
            storage.findBook(ID).setStatus("available");
        } else {

        }
    }

    public void BorrowHistory(String ID, char bookOrUser) {
        if (bookOrUser == 'U' || bookOrUser == 'u') {
            if (storage.findUser(ID) != null) {
                User tempUser = storage.findUser(ID);
                tempUser.showBorrowHistory();
            }
        } else if (bookOrUser == 'B' || bookOrUser == 'b') {
            if (storage.findBook(ID) != null) {
                Book tempBook = storage.findBook(ID);
                tempBook.showBorrowHistory();
            }
        }
    }

}
