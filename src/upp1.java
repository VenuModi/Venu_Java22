import java.util.Scanner;

public class upp1 {
    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);

        System.out.println("What is your name? ");
        String Name = input.next();
        System.out.println("Hej " + Name + "!");

        System.out.println("How old are you " + Name + "?" );
        String age = input.next();
        //int age1 = Integer.parseInt(age);
        System.out.println(Name +  " you are " + age + " years old. ");
        //System.out.println(name +  " you are " + age1 + " years old. ");


        System.out.println("Enter two numbers of your choice.");
        int tal = input.nextInt();
        int tal2 = input.nextInt();
        System.out.println("you have entered " + tal + " and " + tal2);
        int sum = tal + tal2;
        int multi = tal * tal2;
        System.out.println( "The sum of " + tal + " and " + tal2 + " is " + sum);
        System.out.println("The product of " + tal + " and " + tal2 + " is " + multi);

        System.out.println("Hej " + Name + " please enter a number with decimal point. ");
        String d    = input.next();
        double d1 = Double.parseDouble(d);
        System.out.println("you have entered " + d);
        double DoubleValue = Double.parseDouble(d);
        int IntValue = (int) Math.round(DoubleValue);
        System.out.println(DoubleValue + " is now " + IntValue);

        System.out.println("Now can you enter two numbers for which you will have an average.");
        double t1 = input.nextDouble();
        double t2 = input.nextDouble();
        System.out.println("you have entered " + t1  +" and " + t2);
        double DoubleV  = (double)(t1+t2)/2.0;
        double mean = (t1 + t2)/ 2.0;
        System.out.println("The average is: " + mean);

        System.out.println("enter your bank balance.");
        double balance = input.nextDouble();
        System.out.println("what is your interest rate?");
        double interest = input.nextDouble();
        double newBalance = balance * (interest/100) + balance;
        System.out.println("Your new balance is " + newBalance);

    }
}
