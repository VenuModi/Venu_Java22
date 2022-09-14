package src.Labration1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Labb1 {
    Scanner scanner = new Scanner(System.in);
    int[] pris = new int[24];
    String[] timme = new String[24];

    public static void main(String[] args) {
        String userChoice;
        new Labb1().userChoice();
    }

    public void userChoice() {
        while (true) {
            System.out.println("Select an option from the menu below.");

            System.out.println("  Elpriser");
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sorterng");
            System.out.println("4. Bästa laddnings tid (4h)");
            System.out.println("e. Avsluta");
            String userChoice = scanner.next();
            userChoice = userChoice.toLowerCase();
            switch (userChoice) {
                case "1" -> inmatning();
                case "2" -> minMaxMedel();
                case "3" -> sortering();
                case "4" -> bästaLaddningsTid();
                case "e" -> avsluta();
                default -> {
                    System.out.println("Please select an option from the menu below");

                }
            }

        }
    }

    public void inmatning() {
        System.out.println("Du har valt Inmatning. Mata in prier för olika tider.");

//        String[][] timmePris = new String[24][24];
//        for (int i = 0; i < 24; i++) {
//            for (int j = 0; j < 24; j++) {
//                System.out.println(String[][j]);
//            }
//        }

        int x = 0;
        String sx = String.format("%02d", x);
        int y = 1;
        String sy = String.format("%02d", y);
        for (int i = 0; i < 24; i++) {
            System.out.println(sx + "-" + sy);
            pris[i] = scanner.nextInt();
            timme[i] = sx + "-" + sy;
            x++;
            sx = String.format("%02d", x);
            y++;
            sy = String.format("%02d", y);

        }
//        System.out.println(Arrays.toString(timme));
//        System.out.println(Arrays.toString(pris));

    }

    public void minMaxMedel() {
        System.out.println(Arrays.toString(timme));
        System.out.println(Arrays.toString(pris));

        int max = pris[0];
        int min = pris[0];
        double avr = pris[0];


        for (int i = 0; i < timme.length; i++) {
            for (int j = 0; j < pris.length; j++) {
                if (pris[j] < min) {
                    min = pris[j];
                }
                if (pris[j] > max) {
                    max = pris[j];
                }
                avr = avr + pris[j];
            }
        }
        avr=avr/24;
        System.out.println("Det här är minimum värdet: " + min + " öre Kwh/h" + "där minsta tiden är");
        System.out.println("Det här är maximum värdet: " + max + " öre Kwh/h");
        System.out.println("Det här är medel värdet " + avr + "öre Kwh/h");


//        double max = s[0];
//        double min = s[0];
//        double avr = s[0];
//        for (int j = 0; j < s.length; j++) {
//            if (s[j] < min) {
//                min = s[j];
//            }
//            if (s[j] > max) {
//                max = s[j];
//            }
//            avr = avr + s[j];
//
//        }
//        avr = avr / s.length;
//        System.out.println("Det här är minimum värdet: " + min + " öre Kwh/h");
//        System.out.println("Det här är maximum värdet: " + max + " öre Kwh/h");
//        System.out.println("Det här är medel värdet " + avr + "öre Kwh/h");

    }

    public void sortering() {

    }

    public void bästaLaddningsTid() {

    }

    public void avsluta() {

    }
}

