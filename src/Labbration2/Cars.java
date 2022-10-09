package Labbration2;

import jdk.jfr.Category;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Cars {
    static Scanner sc = new Scanner(System.in);
    static JSONParser parser = new JSONParser();
    public static void main(String[] args) {


        Menu();
//        ReadJsonFile();
//        WriteToJsonFile();
    }

    private static void WriteToJsonFile() {
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

        System.out.print("Enter the category of the product: ");
        String category = sc.next();
        myMap.put("Category", category);

        System.out.print("Enter the price of the product: ");
        String price = sc.next();
        myMap.put("Price", price);

        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\VenuModi\\IdeaProjects\\iths_java22_venu\\src\\Labbration2\\cars.json");
            JSONObject jsonObject = new JSONObject(myMap);
            System.out.println(jsonObject);
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ReadJsonFile() {
        try {
            Object obj = parser.parse(new FileReader("\\C:\\Users\\VenuModi\\IdeaProjects\\iths_java22_venu\\src\\Labbration2\\cars.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray cars = (JSONArray) jsonObject.get("Cars");
            JSONArray trucks = (JSONArray) jsonObject.get("Trucks");
            JSONArray carvans = (JSONArray) jsonObject.get("Caravans");

            Iterator iterateCars = cars.iterator();
            Iterator iterateTrucks = trucks.iterator();
            Iterator iterateCaravans = carvans.iterator();

            System.out.println("\n========== Cars ==========");
            while (iterateCars.hasNext()) {
                System.out.println(iterateCars.next());
            }
            System.out.println("\n========== Trucks ==========");
            while (iterateTrucks.hasNext()){
                System.out.println(iterateTrucks.next());
            }
            System.out.println("\n========== Caravans ==========");
            while (iterateCaravans.hasNext()){
                System.out.println(iterateCaravans.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Category(){

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
                case "3":
                    Category();
                    break;
                default:
                    System.out.println("Warning!!" + " Please select options from the menu above.");
            }
        }
    }
}