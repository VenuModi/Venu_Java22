import java.util.Scanner;

public class upp4_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv ett tal");
        int tal = scanner.nextInt();
        int[] number = new int[tal];
        double sum = 0;
        if (tal < 20 && tal > 0){
            for (int i = 0; i < number.length ; i++) {
                number[i] = (int) (Math.random() * 100);
                System.out.println(number[i]);

                sum = sum + number[i];

            }
            sum = sum / tal;
            System.out.println("medelvärdet är " + sum);
        } else {
            System.out.println("Tal måste vara mellan 1 till 20");
        }
    }
}
