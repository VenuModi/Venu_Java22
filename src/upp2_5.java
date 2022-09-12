import java.util.Scanner;

public class upp2_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a month.");
        String month = input.next();
        switch (month) {
            case "january" -> System.out.println("01");
            case "february" -> System.out.println("02");
            case "march" -> System.out.println("03");
            case "april" -> System.out.println("04");
            case "may" -> System.out.println("05");
            case "june" -> System.out.println("06");
            case "july" -> System.out.println("07");
            case "august" -> System.out.println("08");
            case "september" -> System.out.println("09");
            case "october" -> System.out.println("10");
            case "november" -> System.out.println("11");
            case "december" -> System.out.println("12");
            default -> System.out.println("invalid credentials");
        }

    }

}
