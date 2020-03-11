package lab1;

public class Dog implements Comparable<Dog> {
    private String name;
    protected int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println();
    }

    public int compareTo(Dog o) {
        return this.size - o.size;
    }

}
