package lab3;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T>  implements Iterable<T>{
    private T[] items;
    private int size; // the next item to be added will be at position size
    private int wizPos;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
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

    public Iterator<T> iterator() {
        return new ArraySetIterator();
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

    /*
    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("{");
        for(T item : this) {
            returnString.append(item);
        }
        returnString.append("}");
        return returnString.toString();
    }
    */

    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for(T x : this) {
            listOfItems.add(x.toString());
        }
        return "{" + String.join(",", listOfItems) + "}";
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
        ArraySet<Glerp> returnSet = new ArraySet<>();
        for (Glerp x : stuff) {
            returnSet.add(x);
        }
        return returnSet;
    }

    @Override
    public boolean equals(Object other) {
        ArraySet<T> o = (ArraySet<T>) other;
        if(other == null) { return false;}
        if(other.getClass() != this.getClass()) { return false; }
        if(o.size() != this.size()) {
            return false;
        }
        for(T item : this) {
            if(!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<Integer> s = new ArraySet<>();
        s.add(5);
        s.add(19);
        s.add(18);
        System.out.println(s.toString());

        ArraySet<Integer> s2 = new ArraySet<>();
        s2.add(5);
        s2.add(19);
        s2.add(18);
        System.out.println(s2.equals(s));

    }
}