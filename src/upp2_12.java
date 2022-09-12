public class upp2_12 {
    public static void main(String[] args) {
        for(int y=0; y<5; y++) {
            for (int x = 0; x < 5; x++) {
                if (x == y)
                    System.out.println("#"+ " x: " + x + " y: " + y);
                else
                    System.out.println("." + " x: " + x + " y: " + y);
            }
            System.out.println("");
        }
    }
}
