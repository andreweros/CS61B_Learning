package proj1a;

public class  LinkedListDeque<Type> implements List61B<Type> {

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

    public void addLast(Type x) {
        sentinel.prev.last = new Node(sentinel.prev, x, sentinel);
        sentinel.prev = sentinel.prev.last;
        size = size + 1;
    }

    public void addFirst(Type x) {
        sentinel.last.prev = new Node(sentinel, x, sentinel.last);
        sentinel.last = sentinel.last.prev;
        size = size + 1;
    }

    public void removeFirst() {
        Node current = sentinel.last;
        sentinel.last = current.last;
        current.last.prev = sentinel;
        current = null;
    }

    public void printDeque() {
        Node current = sentinel;
        while (current.last != sentinel) {
            System.out.println(current.last.item);
            current = current.last;
        }
    }

    public boolean isEmpty() {
        return (sentinel.last == sentinel);
    }

    public int size() {
        return this.size;
    }

    public Type get(int index) {
        Node cur = sentinel;
         while (index != 0) {
             cur = cur.last;
             index = index - 1;
         }
        return cur.item;
    }

    @Override
    public Type getLast() {
        return sentinel.prev.item;
    }

    @Override
    public void removeLast() {
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.last = sentinel;
        last = null;
    }


    public static void main(String[] args) {
        LinkedListDeque x = new LinkedListDeque();
        x.addLast(5);
        x.addLast(10);
        x.addLast(15);
        x.addFirst(7);

    }
}
