import java.util.Scanner;

public class upp2_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String newOrd = "";
        while(true){
            System.out.println("write something");
            String s = scanner.next();

            if (s.equals("") || s.equals(".") ){
                break;
            }else {
                newOrd = newOrd + s + " ";
                System.out.println(newOrd);
            }
        }
    }
}
