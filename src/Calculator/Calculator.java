package Calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read the user's age as a string
        System.out.print("Enter the first integer: ");
        String FirstInput = scanner.nextLine();
        
        System.out.print("Enter the second integer: ");
        String SecondInput = scanner.nextLine();
        
        int a = Integer.parseInt(FirstInput.trim());
        int b = Integer.parseInt(SecondInput.trim());

        // Compute using methods (operators inside each method)
        int sum = computeSum(a, b);
        int difference = computeDifference(a, b);
        int product = computeProduct(a, b);

        // Display results using a method
        displayResults(sum, difference, product);

        scanner.close();
    }

    // --- Methods using operators ---
    private static int computeSum(int x, int y) {
        return x + y;   // '+' operator
    }

    private static int computeDifference(int x, int y) {
        return x - y;   // '-' operator
    }

    private static int computeProduct(int x, int y) {
        return x * y;   // '*' operator
    }

    // Method to display all results
    private static void displayResults(int sum, int difference, int product) {
        System.out.println("\nResults:");
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
    }
}