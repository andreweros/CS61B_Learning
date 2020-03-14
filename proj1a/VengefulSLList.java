package proj1a;

public class VengefulSLList<Item> extends SLList<Item> {

    SLList<Item> deletedItems;

    public VengefulSLList() {
        super();
        deletedItems = new SLList<Item>();
    }

    public VengefulSLList(Item x) {
        super(x);
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> rs1 = new VengefulSLList<Integer>(9);
        SLList<Integer> s1 = rs1;

        s1.addLast(50);
        s1.removeLast();


    }
}
