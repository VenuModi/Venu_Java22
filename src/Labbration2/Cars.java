package Labbration2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Cars {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Menu();
    }

/*    private static void WriteToJsonFile() {
        Map<String, String> myMap = new HashMap<>();


        System.out.print("Enter the Product Code: ");
        String productCode = sc.next();
        myMap.put("ProductCode", productCode);

        System.out.print("Enter the name of the product: ");
        String name = sc.next();
        myMap.put("Name", name);

        System.out.print("Enter the brand of the product: ");
        String brand = sc.next();
        myMap.put("Brand", brand);

        System.out.print("Enter the type of the product: ");
        String type = sc.next();
        myMap.put("Type", type);

        System.out.print("Enter the price of the product: ");
        String price = sc.next();
        myMap.put("Price", price);

        try {
            // reading the file and creating a json array of it.
            Object obj = parser.parse(new FileReader("src\\Cars.json"));
            JSONArray jsonArray = new JSONArray();

            FileWriter file = new FileWriter("src\\Cars.json");
            JSONObject jsonObject = new JSONObject(myMap);

            jsonArray.add(jsonObject);

            System.out.println(jsonArray);
            file.write(jsonArray.toString());
            file.close();
//        } catch (JSONException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/

    private static void ReadJsonFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<carProduct> veh = Arrays.asList(objectMapper.readValue(new File("src/Labbration2/cars.json"), carProduct[].class));
            System.out.println("\n Choose an option");
            System.out.println("================");
            System.out.println("1. Read Catalogue");
            System.out.println("2. Filter price");
            System.out.println("3. Filter iventory balance ");
            System.out.println("B. Back");
            String subMenu = sc.next().toLowerCase();

            switch (subMenu) {
                case "1":
                    readCatalogue();
                    break;
                case "2":
                    sortByPrice(veh);
                    break;
                case "3":
                    stockDetail(veh);
                case "B":
                    Menu();
                    break;
                default:
                    System.out.println("Warning!!" + " Please select options from the menu above.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCatalogue() {
    }

    private static void stockDetail(List<carProduct> veh) {
        veh.stream()
                .filter(inv -> inv.getInventory()> 10)
                .forEach(printProduct -> System.out.println(printProduct.getName()));
    }

    private static void sortByPrice(List<carProduct> veh) {
        System.out.println("Enter 'h' to sort from highest to lowest prices.");
        System.out.println("Enter 'l' to sort from lowest prices.");
        System.out.println("Enter 'r' to filter with price interval.");
        String priceSort = sc.next();

 // Filtering from highest to lowest
        if (priceSort.equals("h")) {
            Stream<carProduct> sortedListHighLow = veh.stream()
                    .sorted(Comparator.comparingDouble(carProduct::getPrice).reversed().reversed());
            sortedListHighLow.forEach(v -> System.out.println(v.getName() + ": " + v.getPrice()));
        }else {
 //Filtering from owest to highest
            Stream<carProduct> sortedListLowHigh = veh.stream()
                    .sorted(Comparator.comparingDouble(carProduct::getPrice));
            sortedListLowHigh.forEach(v -> System.out.println(v.getName() + ": " + v.getPrice()));
        }

//            veh
//                    .stream()
//                    .filter(v -> v.getPrice() > 400000)
//                    .forEach(v -> System.out.println(v.getName() +  " : " + v.getPrice()));



    }
    private static void Menu() {
        while (true) {

            System.out.println("\n Choose an option");
            System.out.println("================");
            System.out.println("1. Read file");
            System.out.println("2. Write file");
            System.out.println("3. Category");
            System.out.println("4. Quit");
            String menuOptions = sc.next();

            switch (menuOptions) {
                case "1":
                    ReadJsonFile();
                    break;
                case "2":
//                    WriteToJsonFile();
                    break;
                default:
                    System.out.println("Warning!!" + " Please select options from the menu above.");
            }
        }
    }
}