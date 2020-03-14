package proj1a;

public class Alist<Item> implements List61B<Item> {
    private Item[] items;
    private int size;

    public Alist() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    public void addLast(Item x){
        if(size ==  items.length){
            resize(size*2);
        }
        this.items[size] = x;
        size += 1;
    }

    public Item getLast() {
        return items[size-1];
    }

    public Item get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    public void removeLast() {
        Item x = getLast();
        items[size-1] = null; // Not necessary
        size = size - 1;
    }

    public static void main(String[] args) {

    }
}
