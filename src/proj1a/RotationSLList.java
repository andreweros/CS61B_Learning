package proj1a;

public class RotationSLList<Item> extends SLList<Item> {
    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotationSLList<Integer> rs1 = new RotationSLList<>();

        rs1.addLast(10);
        rs1.addLast(11);
        rs1.addLast(12);
        rs1.addLast(13);

        rs1.rotateRight();
        rs1.print();
    }
}
