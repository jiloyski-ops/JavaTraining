package M3_Act3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Comparator;

public class M3_Act3 {

    public static void main(String[] args) {
        // 1) Create a TreeMap with 5 initial products
        // Using CASE_INSENSITIVE_ORDER so "mouse" and "Mouse" are treated the same key.
        TreeMap<String, Double> products = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        products.put("Laptop", 45000.0);
        products.put("Mouse", 500.0);
        products.put("Keyboard", 1500.0);
        products.put("Monitor", 8000.0);
        products.put("Printer", 6000.0);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            // 2) Display menu repeatedly
            System.out.println("\n=== Product Menu (TreeMap) ===");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and prices (sorted by name)");
            System.out.println("4. Find the cheapest product (by price)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Guard against non-integer input
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number between 1 and 5.");
                scanner.nextLine(); // clear invalid input
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Search a product (case-insensitive due to comparator)
                    System.out.print("Enter product name to search: ");
                    String searchProduct = scanner.nextLine().trim();
                    if (products.containsKey(searchProduct)) {
                        System.out.printf("%s found. Price: %.2f%n",
                                canonicalKey(products, searchProduct), products.get(searchProduct));
                    } else {
                        System.out.println(searchProduct + " not found.");
                    }
                    break;

                case 2:
                    // Add a product (will overwrite if same name by comparator)
                    System.out.print("Enter product name to add: ");
                    String newProduct = scanner.nextLine().trim();
                    System.out.print("Enter price for " + newProduct + ": ");

                    Double price = readPrice(scanner);
                    if (price == null) {
                        System.out.println("Invalid price. Please try again.");
                        break;
                    }

                    boolean isNew = !products.containsKey(newProduct);
                    products.put(newProduct, price);
                    System.out.println(isNew
                            ? newProduct + " added successfully."
                            : "Price for " + canonicalKey(products, newProduct) + " updated to " + price);
                    break;

                case 3:
                    // Print all products and prices (TreeMap prints sorted by key)
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                        break;
                    }
                    System.out.println("\nProducts (sorted by name):");
                    for (Map.Entry<String, Double> entry : products.entrySet()) {
                        System.out.printf("- %s : %.2f%n", entry.getKey(), entry.getValue());
                    }
                    System.out.println("Total products: " + products.size());
                    break;

                case 4:
                    // Find the cheapest product by price (iterate values)
                    if (products.isEmpty()) {
                        System.out.println("No products available to evaluate.");
                        break;
                    }
                    Map.Entry<String, Double> cheapest = products.entrySet()
                            .stream()
                            .min(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                            .orElse(null);

                    if (cheapest != null) {
                        System.out.printf("Cheapest product: %s (Price: %.2f)%n",
                                cheapest.getKey(), cheapest.getValue());
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    /**
     * Read a valid price (double) from Scanner; returns null if invalid.
     */
    private static Double readPrice(Scanner scanner) {
        String raw = scanner.nextLine().trim();
        try {
            double val = Double.parseDouble(raw);
            if (val < 0) {
                return null;
            }
            return val;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Return the canonical key as stored in the TreeMap for a given lookup text.
     * Useful when using CASE_INSENSITIVE_ORDER to echo the stored capitalization.
     */
    private static String canonicalKey(TreeMap<String, Double> map, String lookup) {
        // Find the actual key that equalsIgnoreCase(lookup)
        return map.keySet().stream()
                .filter(k -> k.equalsIgnoreCase(lookup))
                .findFirst()
                .orElse(lookup);
    }
}

