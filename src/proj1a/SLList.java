package proj1a;

public class SLList<LochNess>  {

    private class StuffNode {
        public LochNess item;
        public StuffNode next;

        public StuffNode(LochNess i, StuffNode n){
            item = i;
            next = n;
        }
    }
    /* The first item is at sentinel.next */
    private StuffNode sentinel;
    private int size;

    public  SLList(LochNess x){
        sentinel.next = new StuffNode(x,null);
        size += 1;
    }

    public  SLList(){
        sentinel = new StuffNode(null,null);
        size = 0;
    }
    /** Adds x to the front of the list. */
    public void addFirst(LochNess  x){
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }


    /** Returns the first item */
    public LochNess  getFirst(){
        return sentinel.next.item;
    }

    public void addLast(LochNess  x) {
        StuffNode p = sentinel;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new StuffNode(x, null);
        size += 1;
    }

    public LochNess removeLast() {
        StuffNode p = sentinel;
        while (p.next.next != null) {
            p = p.next;
        }
        LochNess temp = p.next.item;
        p.next = null;
        return temp;
    }

    public void print() {
        StuffNode p = sentinel;
        while (p.next != null) {
            System.out.println(p.next.item);
            p = p.next;
        }
    }
//    public int size(){
//        IntNode p = first;
//        int i = 0;
//        while (p.next != null) {
//            p = p.next;
//            i += 1;
//        }
//        return i+1;
//    }

    public static void main(String[] args) {

        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size);

    }

}
