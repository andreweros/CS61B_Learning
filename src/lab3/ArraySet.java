package lab3;


import java.util.HashSet;
import java.util.Set;

public class ArraySet<T>  {
    private T[] items;
    private int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. */
    public void add(T x) {
        if(x == null) {
            throw new IllegalArgumentException("Can't add null to an ArraySet!");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
//        ArraySet<String> s = new ArraySet<>();
//
//        s.add(null);
//        s.add("horse");

        Set<String> s2 = new HashSet<>();
        s2.add(null);
        System.out.println(s2.contains(null));
    }
}