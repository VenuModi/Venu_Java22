public class upp4_7a {
    public static void main(String[] args) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (x == y)
                    System.out.print("#");
                else
                    System.out.print(".");

            }
            System.out.println("");
        }
    }
}
