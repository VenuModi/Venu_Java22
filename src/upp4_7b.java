public class upp4_7b {
    public static void main(String[] args) {
        for (int y = 1; y <4 ; y++) {
            for (int x = 1; x < 8; x++) {
                if (x==y*2)
                    System.out.print("#");
                else if (x==y *2 + 1) {
                    System.out.print("#");
                }else
                    System.out.print("_");

                }
            }
            System.out.println("");
        }
    }

