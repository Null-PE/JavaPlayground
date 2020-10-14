package day26;

public class Cat {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public String eat() {
        return name + "が魚を食べた。";
    }
}
