import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class upp3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a decimal number.");
        while (true){
            try {
                String s = scanner.next();
                double d = Double.parseDouble(s);
                System.out.println(d);
                break;
            } catch (Exception e){
                System.out.println("Not a decimal. Try again!! " + e.getMessage());
                continue;
            }
        }
    }
}
