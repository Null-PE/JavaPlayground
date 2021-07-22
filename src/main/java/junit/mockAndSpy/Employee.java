package junit.mockAndSpy;

public class Employee {
    private Name name;
    private int id;

    public Employee() {
        this.name = new Name("default", "default");
        this.id = 0;
    }

    public Employee(Name name, int id) {
        this.name = name;
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
