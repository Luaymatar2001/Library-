package finalbroject;

import java.util.Scanner;

public class FinalBroject {

    public static void main(String[] args) {
        //---------------------------------before Start------------------------------------
        //Create Books for test
        Book CSS = new Book("001", "CSS", "available", null);
        storage.Books.add(CSS);
        Book HTML = new Book("002", "HTML", "available", null);
        storage.Books.add(HTML);
        Book JS = new Book("003", "JS", "available", null);
        storage.Books.add(JS);
        Book Java = new Book("004", "Java", "available", null);
        storage.Books.add(Java);
        //Create Students for test
        Student abd = new Student(90.0, "abd", "abd", "123");
        storage.Users.add(abd);
        Student ahmed = new Student(70.0, "ahmed", "ahmed", "1234");
        storage.Users.add(ahmed);
        Student ali = new Student(75.7, "ali", "ali", "12345");
        storage.Users.add(ali);
        //Create Employee for test
        Employee said = new Employee("said", "said", "123");
        storage.Users.add(said);
        Employee sami = new Employee("sami", "sami", "1234");
        storage.Users.add(sami);
        //Create Librarian for test
        Librarian taj = new Librarian("taj", "taj", "123");
        storage.Librarians.add(taj);
        Librarian samir = new Librarian("samir", "samir", "1234");
        storage.Librarians.add(samir);

        //---------------------------------Start------------------------------------
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("Welcome to Library System,");
            System.out.print("Enter your ID name : ");
            String ID = input.nextLine();
            //---------------------------------Student------------------------------------
            if (storage.checkUserId(ID).equals("Student")) {
                String name = storage.findUser(ID).getName();
                System.out.print("Hi Student " + name + ", now enter your password: ");
                String password = input.nextLine();
                if (storage.checkPassword(password, ID)) {
                    User tempUser = storage.findUser(ID);
                    System.out.println("Welcome " + name + ",");
                    System.out.println("1- Show available books\n"
                            + "2- Borrow a book (by ISBN)\n"
                            + "3- Search for books by name\n"
                            + "4- to change user\n"
                            + "5- to Exit the program");
                    boolean loop = true;
                    while (loop) {
                        System.out.print("Enter Your choice : ");
                        int choice = input.nextInt();
                        input.nextLine();
                        switch (choice) {
                            case 1:
                                storage.showAvailableBooks();
                                System.out.println("-----------------------------------------");
                                System.out.print("Want to borrow a book? Enter its ISBN: ");
                                String ISBN = input.nextLine();
                                tempUser.borrow(ISBN);
                                break;
                            case 2:
                                System.out.print("Enter the books’ ISBN: ");
                                ISBN = input.nextLine();
                                tempUser.borrow(ISBN);
                                break;
                            case 3:
                                System.out.print("Enter the name you want to look for, or the ISBN number: ");
                                String ISBNOrName = input.nextLine();
                                Book tempBook = tempUser.findBookByName(ISBNOrName);
                                if (tempBook != null) {
                                    tempBook.printRebort();
                                } else {
                                    System.out.println("the book that you look for is not in the library");
                                }
                                break;
                            case 4:
                                loop = false;
                                break;
                            case 5:
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                        System.out.println("-----------------------------------------");
                    }

                }
                //-------------------------------------Employee------------------------------------
            } else if (storage.checkUserId(ID).equals("Employee")) {
                String name = storage.findUser(ID).getName();
                System.out.print("Hi Employee " + name + ", now enter your password: ");
                String password = input.nextLine();
                if (storage.checkPassword(password, ID)) {
                    User tempUser = storage.findUser(ID);
                    System.out.println("Welcome " + name + ",");
                    System.out.println("1- Show available books\n"
                            + "2- Borrow a book (by ISBN)\n"
                            + "3- Search for books by name\n"
                            + "4- to change user\n"
                            + "5- to Exit the program");
                    boolean loop = true;
                    while (loop) {
                        System.out.print("Enter Your choice : ");
                        int choice = input.nextInt();
                        input.nextLine();
                        switch (choice) {
                            case 1:
                                storage.showAvailableBooks();
                                System.out.println("-----------------------------------------");
                                System.out.print("Want to borrow a book? Enter its ISBN: ");
                                String ISBN = input.nextLine();
                                tempUser.borrow(ISBN);
                                break;
                            case 2:
                                System.out.print("Enter the books’ ISBN: ");
                                ISBN = input.nextLine();
                                tempUser.borrow(ISBN);
                                break;
                            case 3:
                                System.out.print("Enter the name you want to look for, or the ISBN number: ");
                                String ISBNOrName = input.nextLine();
                                Book tempBook = tempUser.findBookByName(ISBNOrName);
                                if (tempBook != null) {
                                    tempBook.printRebort();
                                } else {
                                    System.out.println("the book that you look for is not in the library");
                                }
                                break;
                            case 4:
                                loop = false;
                                break;
                            case 5:
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                        System.out.println("-----------------------------------------");
                    }

                    //-------------------------------------Librarian------------------------------------
                } else if (storage.checkUserId(ID).equals("Librarian")) {

                } else {

                }

            }
        }

    }

}
