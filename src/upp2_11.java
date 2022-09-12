import java.util.Scanner;

public class upp2_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("write a number");
        int number = input.nextInt();

        while (number > 2){
            if ( (number%2) == 0){
                number = number / 2;
                System.out.println(number);
            } else {
                number = (number*3)+1;
                System.out.println(number);
            }
        }
    }
}
