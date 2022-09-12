public class method_uppgift {
    public static double calculateTax(double lön){
        double amountOver = lön - 100000.0;
        if (amountOver < 0){
            amountOver =0.0;
            amountOver = Math.max(amountOver, 0.0);
            System.out.println("tax");
            System.out.println(calculateTax(99999));
            System.out.println(calculateTax(110000));
        }
        return lön * 0.3 + amountOver * 0.0;


    }
}
