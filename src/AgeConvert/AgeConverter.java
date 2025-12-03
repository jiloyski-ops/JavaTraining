package AgeConvert;

import java.util.Scanner;

public class AgeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read the user's age as a string
        System.out.print("Enter your age: ");
        String ageInput = scanner.nextLine();
            
        // 2. Convert the string into an int
        int ageInt = Integer.parseInt(ageInput.trim());

        // 3. Convert the int into a double
        double ageDouble = (double) ageInt; // or: Double.valueOf(ageInt)

        // 4. Display both the int and double versions of the age
        System.out.println("Your age as int: " + ageInt);
        System.out.println("Your age as double: " + ageDouble);
        scanner.close();
        }
    }
