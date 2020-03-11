package proj1b;

public class LinkedListDeque<Type> implements Deque<Type> {

    private Node sentinel;
    private int size;
    /**
     * Double linked list node with para
     */
    public class Node {
        private Node prev;
        private Type item;
        private Node last;

        public Node(Node prev, Type item, Node last) {
            this.prev = prev;
            this.item = item;
            this.last = last;
        }
    }


    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.last = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

//    public DLList(Type x){
//        sentinel.last = new Node(sentinel,x,null);
//        sentinel.prev = sentinel.last;
//        size = size + 1;
//    }

    @Override
    public void addLast(Type x) {
        sentinel.prev.last = new Node(sentinel.prev, x, sentinel);
        sentinel.prev = sentinel.prev.last;
        size = size + 1;
    }

    @Override
    public void addFirst(Type x) {
        sentinel.last.prev = new Node(sentinel, x, sentinel.last);
        sentinel.last = sentinel.last.prev;
        size = size + 1;
    }

    @Override
    public Type removeFirst() {
        Node current = sentinel.last;
        Type temp;
        sentinel.last = current.last;
        current.last.prev = sentinel;
        temp = current.item;
        current = null;
        size = size - 1;
        return temp;
    }

    @Override
    public void printDeque() {
        Node current = sentinel;
        while (current.last != sentinel) {
            System.out.println(current.last.item);
            current = current.last;
        }
    }

    @Override
    public boolean isEmpty() {
        return (sentinel.last == sentinel);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Type get(int index) {
        Node cur = sentinel;
         while (index != 0) {
             cur = cur.last;
             index = index - 1;
         }
        return cur.item;
    }

    private Type getLast() {
        return sentinel.prev.item;
    }

    @Override
    public Type removeLast() {
        Node last = sentinel.prev;
        Type temp;
        sentinel.prev = last.prev;
        last.prev.last = sentinel;
        temp = last.item;
        last = null;
        size = size - 1;
        return temp;
    }


    public static void main(String[] args) {
        LinkedListDeque x = new LinkedListDeque();
        x.addLast(5);
        x.addLast(10);
        x.addLast(15);
        x.addFirst(7);

    }
}
