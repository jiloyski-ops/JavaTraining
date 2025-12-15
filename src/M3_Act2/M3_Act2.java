package M3_Act2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class M3_Act2 {

    public static void main(String[] args) {
        // 1) Create a HashSet with 5 initial products
        Set<String> products = new HashSet<>();
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Printer");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // 2) Display menu repeatedly
            System.out.println("\n=== Product Menu ===");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Search a product
                    System.out.print("Enter product name to search: ");
                    String searchProduct = scanner.nextLine().trim();
                    if (products.contains(searchProduct)) {
                        System.out.println(searchProduct + " is FOUND in the set.");
                    } else {
                        System.out.println(searchProduct + " is NOT FOUND.");
                    }
                    break;

                case 2:
                    // Add a product
                    System.out.print("Enter product name to add: ");
                    String newProduct = scanner.nextLine().trim();
                    if (products.add(newProduct)) {
                        System.out.println(newProduct + " added successfully.");
                    } else {
                        System.out.println(newProduct + " already exists in the set.");
                    }
                    break;

                case 3:
                    // Print all products and count
                    System.out.println("\nProducts in the set:");
                    for (String p : products) {
                        System.out.println("- " + p);
                    }
                    System.out.println("Total products: " + products.size());
                                       break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}