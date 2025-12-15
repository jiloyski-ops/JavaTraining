package M3_Act1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M3_Act1 {

    public static void main(String[] args) {
        // 1) Create a List of Products with 5 records
        List<String> products = new ArrayList<>();
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Printer");

        System.out.println("All Products:");
        printList(products);

        // 3) Add a new product (Webcam) and remove one product (Mouse)
        products.add("Webcam");
        products.remove("Mouse"); // removes by value if present

        System.out.println("Adding and Removing products:");
        printList(products);

        // 4) Ask user for a product name to search
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nEnter a product name to search: ");
            String target = scanner.nextLine().trim();

            // 4.1 Traditional for-loop search 
            int indexByLoop = findIndexByLoop(products, target);
            if (indexByLoop >= 0) {
                System.out.println("Loop search: FOUND '" + products.get(indexByLoop)
                        + "' at position " + (indexByLoop + 1) + " (index " + indexByLoop + ")");
            } else {
                System.out.println("Loop search: NOT FOUND for '" + target + "'");
            }

            // 4.2 contains() method 
            boolean foundByContains = products.contains(target);
            System.out.println("Contains() Method: " + (foundByContains ? "FOUND for '" : "NOT FOUND for '")
            		+ target + "'" );

        }
    }

    // Utility method: print all products
    private static void printList(List<String> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    // Utility: traditional for-loop search returning index (case-insensitive)
    private static int findIndexByLoop(List<String> products, String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equalsIgnoreCase(name)) {
                return i; // return first match index
            }
        }
        return -1; // not found
    }
}
