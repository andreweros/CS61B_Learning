package lab1;

public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){
        if(rest == null)
            return 1;
        return 1+this.rest.size();
    }

    public int get(int p){
        if(p == 0){
            return first;
        }
        else return rest.get(p-1);
    }

    public static IntList incrList(IntList L, int x){
        if(L == null) return null;
        return new IntList(L.first +x, incrList(L.rest,x));
    }

    public static IntList incrList1(IntList L, int x){
        if(L == null) return null;
        IntList res = new IntList(L.first+x,null);
        IntList ptr = res;
        while(L.rest!=null){
            L = L.rest;
            ptr.rest = new IntList(L.first+x,null);
            ptr = ptr.rest;
        }
        return res;
    }

    public static IntList dincrList(IntList L, int x){
        if(L == null) return null;
        return new IntList(L.first-x,dincrList(L.rest,x));
    }

    public static void main(String[] args) {
        IntList L = new IntList(15,null);
        L = new IntList(10,L);
        L = new IntList(5,L);
        L = dincrList(L,2);
        System.out.println(L.rest.first);
    }
}
