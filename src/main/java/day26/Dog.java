package day26;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String eat() {
        return name + "が肉を食べた。";
    }
}
