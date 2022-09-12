import java.util.Random;

public class upp4_3 {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        int max = numbers[0];
        int min = numbers[0];
        int odd = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
            System.out.println(numbers[i]);
            for (i = 0; i > numbers[i]; i++) {
                numbers[i] = max;
                System.out.println("The maximum number is: " + max);
            }
        }
    }
}

//            if (numbers[i] > max) {
//                max = numbers[i];
//            }
//            else {
//                min = numbers[i];
//            }
//            if ( (numbers[i]%2) != 0) {
//                odd = numbers[i];
//            }
//         }
//        System.out.println("The largest number is "+ max);
//        System.out.println("The smallest number is " + min);
//        System.out.println("There are " + odd + " odd numbers");
//
//    }
