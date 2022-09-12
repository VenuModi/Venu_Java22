import java.util.Scanner;
import java.io.Console;

public class upp2 {
    public static void main(String[] args) {

        String str; char ch[];
        Console input = System.console();
        String pass = "=test";
        String username = "Test";
        System.out.print("Enter username: ");
        str = input.readLine();
        System.out.print("Enter Password: ");
        ch = input.readPassword();
        String aa = String.valueOf(ch);
        System.out.println("username: " + str);
        System.out.println("password: " + ch);

        if ((str.equals(username)) && aa.equals(pass)){
            System.out.println("Valid credentials");
        }
        else{
            System.out.println("Invalid credentials");
        }

        int a = 3;
        if (a>1){
            System.out.println("a>1 (första)");
            a--;
        }
        if (a>1){
            System.out.println("a>1 (andra)");
        }
        else {
            System.out.println("a<=1");
        }

        final char c = 'q';
        switch (c){
            case 'a':
                System.out.println("variable is 'a'");
                break;
            case 'b':
                System.out.println("variable is 'b'");
                break;
            default:
                System.out.println("variable is another letter");
                break;
        }


    }
}
