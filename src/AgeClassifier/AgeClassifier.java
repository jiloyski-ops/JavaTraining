package AgeClassifier;

import java.util.Scanner;

public class AgeClassifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Determine category using if-else
        if (age < 18) {
            System.out.println("Minor");
        } else if (age >= 18 && age <= 59) {
            System.out.println("Adult");
        } else if (age >= 60) {
            System.out.println("Senior");
        } else {
            System.out.println("Invalid age entered.");
        }

        scanner.close();
    }
}

