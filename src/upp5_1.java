public class upp5_1 {
    static void f1 (){
        System.out.println("test");
    }
    static int f2 (int i){
        return i * i;
    }
    static int f3(int x, int y) {
        return x * y;
    }
    static int f4 (int i){
        return i * 5;
    }
    static  void  f5 (double d){
        d++;
    }

    public static void main(String[] args) {
        f1();
        int a = f2(3);
        System.out.println(f3 (3,5));

        int x = 2, y = 3;
        var b = f4(f4(x) + f4(y));
        System.out.println(b);

        double d = 5.5;
        f5(d);
        System.out.println(d);

    }
}
