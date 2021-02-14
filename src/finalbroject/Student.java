package finalbroject;

public class Student extends User {

    private double GBA;

    @Override
    public String getType() {
        return "Student";
    }

    public Student(double GBA, String ID, String name, String password) {
        super(ID, name, password);
        this.GBA = GBA;
    }

    @Override
    public void borrow(String ISBN) {
        if (GBA < 85) {
            System.out.println("Your request has been submitted to librarian, check with him.");
            Order newOrder = new Order(ISBN, this.getID());
            storage.Orders.add(newOrder);
        } else {
            Book tempBook = storage.findBook(ISBN);
            if (tempBook != null) {
                if (tempBook.getStatus().equals("available")) {
                    tempBook.setCurrentOwner(this);
                    tempBook.setStatus("borrowed");
                    tempBook.borrowingHistory.push(this);
                    this.borrowingHistory.push(tempBook);
                } else {
                    System.out.println("this book is borrowed");
                }
            }else{
                System.out.println("Invalid Book ISBN");
            }
        }
    }

    public double getGBA() {
        return GBA;
    }

    public void setGBA(double GBA) {
        if (GBA > 100 || GBA < 0) {
            System.out.println("Invalid GBA");
        } else {
            this.GBA = GBA;
        }
    }

}
