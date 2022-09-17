package src.Labration1;

import java.util.Arrays;
import java.util.Scanner;

class Labb1 {
    Scanner scanner = new Scanner(System.in);
    int[] pris = new int[24];
    String[] timme = new String[24];

    public static void main(String[] args) {
        new Labb1().meny();
    }

    /*
     Denna del låter användaren välja olika alternativ.

     Om användaren väljer alternativ som inte finns i menyn ger den en varning om att välja alternativ
     från den angivna menyn istället för att krascha.
     */
    public void meny() {
        while (true) {
            System.out.println("\nVälj ett alternativ från menyn");

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
                    System.out.println("Programmet har avslutats");
                    return;
                default:
                    System.out.println("Varning!! Välj från följande alternativ.");
                    break;
            }

        }
    }

    /*
     Detta är det första alternativet i menyn som låter användaren fylla i priserna för olika tidsperioder.
     Skulle användaren skriva bokstav eller en char så kommer programmet att krasha.
     */
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

    /*
    Detta alternativ ger användaren lägsta, högsta och genomsnittliga priser som han tidigare angett
    alternativ 1.
     Om användaren direkt hoppar till alternativ 2 blir värdena 0.
     */
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

    /*
    Vi kopierar listan från våra deklarerade variabler (pris & timme) till en lokal variabel.
    Genom att göra detta förhindrar vi att den deklarerade variabeln sorteras och därför är originaldata intakt.

    Denna metod sorterar ut alla dessa priser från lägsta till högsta och med motsvarande tid.
    */
    public void sortering() {

        int[] sorteradPris = Arrays.copyOf(pris, pris.length);
        String[] sorteradTid = Arrays.copyOf(timme, timme.length);

        for (int i = 0; i < sorteradPris.length - 1; i++) {
            for (int j = 0; j < sorteradPris.length - i - 1; j++) {
                if (sorteradPris[j] > sorteradPris[j + 1]) {
                    //swap
                    int temp = sorteradPris[j];
                    sorteradPris[j] = sorteradPris[j + 1];
                    sorteradPris[j + 1] = temp;

                    String temp2 = sorteradTid[j];
                    sorteradTid[j] = sorteradTid[j + 1];
                    sorteradTid[j + 1] = temp2;
                }
            }
        }

        for (int i = 0; i < sorteradPris.length; i++) {
            System.out.format("%s: %d%n", sorteradTid[i], sorteradPris[i]);
        }
    }

    /*
    Med den här metoden tar vi reda på de bästa 4 timmarna för att ladda din elbil.
    Fyndet görs från de priser som användaren angett i alternativ 1 för att få den billigaste totalsumman
    4 timmar i följd.
     */
    public void bastaLaddningsTid() {
        double tempSum = Double.MAX_VALUE;

        System.out.println("Bästa fyra laddnings tid är:");
        String laddTid = "";
        String laddTid2 = "";
        String laddTid3 = "";
        String laddTid4 = "";

        for (int i = 0; i < pris.length - 4; i++) {
            double fyraBastaPriser = pris[i] + pris[i + 1] + pris[i + 2] + pris[i + 3];
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
}

