package Name;


import java.util.Scanner;

public class AskName {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Ask for the user's name
        System.out.print("What is your name? ");
        String name = scanner.nextLine();

        // Greet the user
        System.out.println("Hello " + name + "!");

        // Close the scanner
        scanner.close();
    }
}
