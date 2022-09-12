package se;

public class methoder {
    public static void main(String[] args) {
        printMultiplicationTable( 2);

        int x = 2;
        printMultiplicationTable(x);
        int tableNumber = 2;
        printMultiplicationTable(tableNumber);
    }

    public static void printMultiplicationTable(int tableNumber) {
        for (int i = 0; i <= 10 ; i++) {
            System.out.println(tableNumber * i);
        }
        }

    public static int add(int x, int y) {
        int sum = x + y;
        return sum;

    }
    }

