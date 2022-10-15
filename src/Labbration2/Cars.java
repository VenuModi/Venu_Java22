package Labbration2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class Cars {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Menu();
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
                    WriteToJsonFile();
                    break;
                default:
                    System.out.println("Warning!!" + " Please select options from the menu above.");
            }
        }
    }
    private static void WriteToJsonFile() {

    }
    private static void ReadJsonFile() {
        while (true) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();

                List<carProduct> veh = Arrays.asList(objectMapper.readValue(new File("src/Labbration2/cars.json"), carProduct[].class));
                System.out.println("\n Choose an option");
                System.out.println("================");
                System.out.println("1. Read Catalogue");
                System.out.println("2. Filter price");
                System.out.println("3. Filter inventory balance");
                System.out.println("4. Filter car types");
                System.out.println("B. Back");
                String subMenu = sc.next().toLowerCase();

                switch (subMenu) {
                    case "1":
                        readCatalogue(veh);
                        break;
                    case "2":
                        sortByPrice(veh);
                        break;
                    case "3":
                        inventoryDetails(veh);
                        break;
                    case "4":
                        filterByCarType(veh);
                        break;
                    case "b":
                        Menu();
                        break;
                    default:
                        System.out.println("Warning!!" + " Please select options from the menu above.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

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


    private static void sortByPrice(List<carProduct> veh) {
        System.out.println("Enter 'h' to sort from highest to lowest prices.");
        System.out.println("Enter 'l' to sort from lowest prices.");
        System.out.println("Enter 'r' to filter with price interval.");
        String priceChoice = sc.next();

        // Filtering from highest to lowest
        if (priceChoice.equals("h")) {
            Stream<carProduct> sortedListHighLow = veh.stream()
                    .sorted(Comparator.comparingDouble(carProduct::getPrice).reversed());
            sortedListHighLow.forEach(v -> System.out.println(v.getName() + ": " + v.getPrice()));
        } else if (priceChoice.equals("l")) {
            //Filtering from lowest to highest
            Stream<carProduct> sortedListLowHigh = veh.stream()
                    .sorted(Comparator.comparingDouble(carProduct::getPrice));
            sortedListLowHigh.forEach(v -> System.out.println(v.getName() + ": " + v.getPrice()));
        } else if (priceChoice.equals("r")) {
            System.out.println("\n Filter by price range, give a minPrice and maxPrice.");
            int minPrice = sc.nextInt();
            int maxPrice = sc.nextInt();

            List<carProduct> results = new ArrayList<>();
            veh.stream().filter(p -> p.getPrice() > minPrice && p.getPrice() < maxPrice).forEach(results::add);

            results.forEach(v -> System.out.println(v.getName() + " : " + v.getPrice()));
        } else {
            System.out.println("Choose a valid option from the menu");
        }
    }


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
}