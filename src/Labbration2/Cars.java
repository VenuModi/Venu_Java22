package Labbration2;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Stream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cars {
    static Scanner sc = new Scanner(System.in);
    static JSONParser parser = new JSONParser();

    public static void main(String[] args) {
        Menu();
    }

    private static void Menu() {
        while (true) {

            System.out.println("\n Choose an option");
            System.out.println("================");
            System.out.println("1. Read file");
            System.out.println("2. Write file");
            System.out.println("3. Quit");
            String menuOptions = sc.next();

            switch (menuOptions) {
                case "1" -> ReadJsonFile();
                case "2" -> WriteToJsonFile();
                case "3" -> {
                    System.out.println("The program has ended");
                    System.exit(0);
                }
                default -> System.out.println("Warning!!" + " Please select options from the menu above.");
            }
        }
    }


    /*
    Creating a menu on the read file method for the user to navigate different options by using a objectMapper.
     */
    private static void ReadJsonFile() {
        while (true) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();

                List<carProduct> veh = Arrays.asList(objectMapper
                        .readValue(new File("src/Labbration2/cars.json"), carProduct[].class));
                System.out.println("\n Choose an option");
                System.out.println("================");
                System.out.println("1. Read Catalogue");
                System.out.println("2. Filter price");
                System.out.println("3. Filter inventory balance");
                System.out.println("4. Filter car types");
                System.out.println("B. Back");
                String subMenu = sc.next().toLowerCase();

                switch (subMenu) {
                    case "1" -> readCatalogue(veh);
                    case "2" -> sortByPrice(veh);
                    case "3" -> inventoryDetails(veh);
                    case "4" -> filterByCarType(veh);
                    case "b" -> Menu();
                    default -> System.out.println("Warning!!" + " Please select options from the menu above.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
    This method reads the whole file of vehicles enabling the user to have a view of different
    products and their properties.
     */

    private static void readCatalogue(List<carProduct> veh) {
        veh
                .forEach(v -> System.out.println(
                        v.getProductCode() + " | "
                                + v.getName() + " | "
                                + v.getType() + " | "
                                + v.getBrand() + " | "
                                + v.getPrice() + " | "
                                + v.getCategory()));
    }

    /*
    In this method we give the user options to choose different form of price filters.
     */
    private static void sortByPrice(List<carProduct> veh) {
        System.out.println("Enter 'h' to sort from highest to lowest prices.");
        System.out.println("Enter 'l' to sort from lowest prices.");
        System.out.println("Enter 'r' to filter with price interval.");
        String priceChoice = sc.next();

        // Filtering from highest to lowest
        switch (priceChoice) {
            case "h" -> {
                Stream<carProduct> sortedListHighLow = veh.stream()
                        .sorted(Comparator.comparingDouble(carProduct::getPrice).reversed());
                sortedListHighLow.forEach(v -> System.out.println(v.getName() + ": " + v.getPrice()));
            }
            case "l" -> {
                //Filtering from lowest to highest
                Stream<carProduct> sortedListLowHigh = veh.stream()
                        .sorted(Comparator.comparingDouble(carProduct::getPrice));
                sortedListLowHigh.forEach(v -> System.out.println(v.getName() + ": " + v.getPrice()));
            }
            case "r" -> {
                //Sorting with price interval
                System.out.println("\n Filter by price range, give a minPrice and maxPrice.");
                int minPrice = sc.nextInt();
                int maxPrice = sc.nextInt();
                List<carProduct> results = new ArrayList<>();
                veh.stream().filter(p -> p.getPrice() > minPrice && p.getPrice() < maxPrice).forEach(results::add);
                results.forEach(v -> System.out.println(v.getName() + " : " + v.getPrice()));
            }
            default -> System.out.println("Choose a valid option from the menu");
        }
    }

    /*
    This enables the user to get the list of the required inventory.
     */
    private static void inventoryDetails(List<carProduct> veh) {

        Stream<carProduct> brand = veh.stream()
                .sorted(Comparator.comparing(carProduct::getBrand));
        brand.forEach(v -> System.out.println(v.getBrand()));

        System.out.println("For which brand is inventory required?");
        sc.nextLine();
        String brandName = sc.nextLine();

        System.out.println(brandName);

        Stream<carProduct> carName = veh.stream()
                .sorted(Comparator.comparing(carProduct::getName))
                .filter(v -> v.getBrand().equals(brandName));

        carName.forEach(v -> System.out.println(v.getName() + " : " + v.getInventory()));

    }

    /*
    This method enables the user to filter the types of cars.
     */
    private static void filterByCarType(List<carProduct> veh) {
        Stream<carProduct> type = veh.stream()
                .sorted(Comparator.comparing(carProduct::getType));
        type.forEach(v -> System.out.println(v.getType()));

        System.out.println("Select the car type.");
        sc.nextLine();
        String carType = sc.nextLine();

        System.out.println(carType);

        Stream<carProduct> carNameType = veh.stream()
                .sorted(Comparator.comparing(carProduct::getType))
                .filter(v -> v.getType().equals(carType));

        carNameType.forEach(v -> System.out.println(v.getName() + " | " + v.getType() + " | " + v.getPrice()));

    }

    /*
    creation of HashMap to enable the user to add input to the file.
     */
    private static void WriteToJsonFile() {
        Map<String, String> mapStringValues = new HashMap<>();
        Map<String,Integer> mapIntValues = new HashMap<>();
        Map<String,Object> myObj = new HashMap<>();

        System.out.print("Enter the Product Code: ");
        int productCode = sc.nextInt();
        mapIntValues.put("productCode", productCode);

        System.out.print("Enter the name of the product: ");
        String name = sc.next();
        mapStringValues.put("name", name);

        System.out.print("Enter the brand of the product: ");
        String brand = sc.next();
        mapStringValues.put("brand", brand);

        System.out.print("Enter the type of the product: ");
        String type = sc.next();
        mapStringValues.put("type", type);

        System.out.print("Enter the price of the product: ");
        int price = sc.nextInt();
        mapIntValues.put("price", price);

        System.out.print("Enter the amount of stock/inventory of the product: ");
        int inventory = sc.nextInt();
        mapIntValues.put("inventory", inventory);

        System.out.print("Enter the category of the product: ");
        String category = sc.next();
        mapStringValues.put("category", category);

        /*
        myObj enables to append the two HashMap to one object.
         */
        myObj.putAll(mapStringValues);
        myObj.putAll(mapIntValues);

        try {
            // reading the file and creating a json array of it.
            Object obj = parser.parse(new FileReader("src/Labbration2/cars.json"));
            JSONArray jsonArray = (JSONArray) obj;

            FileWriter file = new FileWriter("src/Labbration2/cars.json");
            JSONObject jsonObject = new JSONObject(myObj);

            //adding new information to the existing json file.
            jsonArray.add(jsonObject);

            file.write(jsonArray.toString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}