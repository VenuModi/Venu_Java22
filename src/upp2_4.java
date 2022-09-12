import java.util.Scanner;

public class upp2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type any number.");
        int tal = scanner.nextInt();
        if (tal == 100){
            System.out.println(tal + " = 100");
        }
        else if (tal > 100) {
            System.out.println(tal + " > 100" );
        }
        else if (tal < 100){
            System.out.println(tal + " < 100");

        }
        else{
            System.out.println("Error");
        }
    }
}
