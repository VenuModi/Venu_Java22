package src.Labration1;

import java.util.Scanner;

class Labb1 {
    Scanner scanner = new Scanner(System.in);
    int[] pris = new int[24];
    String[] timme = new String[24];

    public static void main(String[] args) {
//        String userChoice;
        new Labb1().meny();
    }

    public void meny() {
        while (true) {
            System.out.println("Välj ett alternativ från menyn");

            System.out.println("  Elpriser");
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sorterng");
            System.out.println("4. Bästa laddnings tid (4h)");
            System.out.println("e. Avsluta");
            String menyVal = scanner.next();
            menyVal = menyVal.toLowerCase();
            switch (menyVal) {
                case "1":
                    inmatning();
                    break;
                case "2":
                    minMaxMedel();
                    break;
                case "3":
                    sortering();
                    break;
                case "4":
                    bastaLaddningsTid();
                    break;
                case "e":
                    System.out.println("Terminated");
                    break;
                default:
                    System.out.println("Varning!!Välj från följande alternativ.");
                    break;
            }

        }
    }

    public void inmatning() {
        System.out.println("Du har valt Inmatning. Mata in prier för olika tider.");

        int tid1 = 0;
        String formateradTid1 = String.format("%02d", tid1);
        int tid2 = 1;
        String formateradTid2 = String.format("%02d", tid2);
        for (int i = 0; i < 24; i++) {
            System.out.print(formateradTid1 + "-" + formateradTid2 + ":");
            pris[i] = scanner.nextInt();

            timme[i] = formateradTid1 + "-" + formateradTid2;
            tid1++;
            formateradTid1 = String.format("%02d", tid1);
            tid2++;
            formateradTid2 = String.format("%02d", tid2);
        }
    }

    public void minMaxMedel() {
        int max = pris[0];
        int min = pris[0];
        String minTimme = "";
        String maxTimme = "";
        double sum = 0;
        double avr;

        for (int j = 0; j < pris.length; j++) {
            if (pris[j] < min) {
                min = pris[j];
                minTimme = timme[j];
            }
            if (pris[j] > max) {

                max = pris[j];
                maxTimme = timme[j];
            }
            sum = sum + pris[j];
        }
        avr = sum / 24;
        System.out.println("Lägsta priset för tiden " + minTimme + " är :" + min + "öre Kwh/h");
        System.out.println("Högsta priset för tiden " + maxTimme + " är : " + max + "öre Kwh/h");
        System.out.println("Det här är medel värdet " + avr + "öre Kwh/h");
    }

    public void sortering() {
        int temp = 0;
        String temp2 = "";
        for (int i = 0; i < pris.length - 1; i++) {
            for (int j = 0; j < pris.length - i - 1; j++) {
                if (pris[j] > pris[j + 1]) {
                    //swap
                    temp = pris[j];
                    pris[j] = pris[j + 1];
                    pris[j + 1] = temp;

                    temp2 = timme[j];
                    timme[j] = timme[j + 1];
                    timme[j + 1] = temp2;
                }
            }
        }
        for (int i = 0; i < pris.length; i++) {
            System.out.format("%s: %d%n", timme[i], pris[i]);
        }
    }

    public void bastaLaddningsTid() {
        double tempSum = Double.MAX_VALUE;
        ;
        System.out.println("Bästa fyra laddnings tid är:");
        String laddTid = "";
        String laddTid2 = "";
        String laddTid3 = "";
        String laddTid4 = "";
        double fyraBastaPriser = 0;

        for (int i = 0; i < pris.length - 4; i++) {
            fyraBastaPriser = pris[i] + pris[i + 1] + pris[i + 2] + pris[i + 3];
            if (fyraBastaPriser < tempSum) {
                tempSum = fyraBastaPriser;

                laddTid = timme[i];
                laddTid2 = timme[i + 1];
                laddTid3 = timme[i + 2];
                laddTid4 = timme[i + 3];
            }
        }
        System.out.println(laddTid + "," + laddTid2 + "," + laddTid3 + "," + laddTid4);
        System.out.println("Totalla priset under dessa fyra timmar är : " + tempSum + "öre Kwh/h");
        System.out.println("Medelvärde för dessa timmarna är : " + tempSum / 4 + "öre Kwh/h");

    }


    public void avsluta() {
        System.out.println("Programmet har avslutat.");

    }
}

