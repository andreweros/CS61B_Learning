public class Test {
    public static int test(int a){
        a = a+6;
        return a;
    }

    public static void main(String[] args) {
        int a = 5;
        Integer c = 5;
        int b = test(a);
        System.out.println(a);
        b = test(c);
        System.out.println(c);
    }
}
