import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class upp2_6 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int magicNumber = random.nextInt(100) + 1;
        while (true) {
            System.out.println("Guess a number between 1 and 100");
            int guess = input.nextInt();

            if (guess == magicNumber) {
                System.out.println("Correct! You win!!");
                break;
            } else if (guess < magicNumber) {
                System.out.println("your guess is too low! Try again");

            } else {
                System.out.println("your guess is too high! Try again");

            }
        }
    }
}

