package finalbroject;

public class Employee extends User {

    public Employee(String ID, String name, String password) {
        super(ID, name, password);
    }

    @Override
    public String getType() {
        return "Employee";
    }
}
