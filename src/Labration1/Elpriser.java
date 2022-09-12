package Labration1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Elpriser {
    public static void main(String[] args) {
        /*
            by returning a choice before, we created it as a string to initialise it in order to return it.
            Then created if case to get over with the problem of upper and lower case in "e".
            Parsed string to int because our user choices have int values for the user to enter.
         */
        Scanner s = new Scanner(System.in);
        String userChoice = meny(s);

        if (userChoice.equalsIgnoreCase("e")) {
            System.out.println("Programmet avslutades");
        } else {
            int i = Integer.parseInt(userChoice);
            System.out.println(i);
            /*
            we initialised double array to get the return of  input the rates.
             */
            if (i == 1) {
                int[] pris = inmatning(s);
                getMinMaxMedel(pris);
                sorteraMinMax(pris);

            }
        }
    }

    private static void sorteraMinMax(int[] pris) {

        for (int i = 0; i < pris.length - 1 ; i++) {
            int smallest = i;
            for (int j = i+1; j < pris.length; j++) {
                if (pris[smallest] > pris[j]){
                    smallest = j;
                }
            }
            int temp =pris[smallest];
            pris[smallest] = pris[i];
            pris[i] = temp;
        }
        System.out.println(Arrays.toString(pris));
    }

    private static void getMinMaxMedel(int[] s) {
        double max = s[0];
        double min = s[0];
        double avr = s[0];
        for (int j = 0; j < s.length; j++) {
            if (s[j] < min) {
                min = s[j];
            }
            if (s[j] > max) {
                max = s[j];
            }
            avr = avr + s[j];

        }
        avr = avr / s.length;
        System.out.println("Det här är minimum värdet: " + min + " öre Kwh/h");
        System.out.println("Det här är maximum värdet: " + max + " öre Kwh/h");
        System.out.println("Det här är medel värdet " + avr + "öre Kwh/h");
    }

    /*
        Step 1: Inmatning av värde
        created a int array method and returned it, so we get prices for 24 hours.
     */
    public static int[] inmatning(Scanner s) {
        System.out.println("Du har valt inmatning av elpriser");
        System.out.println("Mata in priserna för de olika tiderna.");
//        int[] pris = new int[24];
//        for (int prisTimme = 0; prisTimme < pris.length; prisTimme++) {
//            if (prisTimme <= 8) {
//                pris[prisTimme] = s.nextInt();
//                System.out.println("timme = 0" + prisTimme + "-0" + (prisTimme + 1) + "/Kwh/h = " + Arrays.toString(pris));
//            } else if (prisTimme == 9) {
//                pris[prisTimme] = s.nextInt();
//                System.out.println("timme = 0" + prisTimme + "-" + (prisTimme + 1) + "/kwh/h = " + Arrays.toString(pris));
//            } else {
//                pris[prisTimme] = s.nextInt();
//                System.out.println("timme =" + prisTimme + "-" + (prisTimme + 1) + "/Kwh/h = " + Arrays.toString(pris));
//            }
//        }
        return new int[]{123, 456, 789, 369, 258, 147, 741, 852, 963, 321, 654, 987, 159, 951, 320, 210, 650, 540, 980, 870, 410, 520, 630, 740};

    }

    /*
        Step 0: Meny
        show the menu on the console and make the user choose an option.
        private - so only main can use it.
     */
    private static String meny(Scanner s) {
        String choice;

        System.out.println("  Elpriser   ");
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("1. Inmatning");
        System.out.println("2. Min, Max och Medel");
        System.out.println("3. Sortera");
        System.out.println("4. Bästa Laddningstid (4h)");
        System.out.println("e. Avsluta");
        System.out.println("Select one");
        choice = s.next();

        return choice;
    }
}
