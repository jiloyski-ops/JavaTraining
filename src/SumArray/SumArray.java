package SumArray;
import java.util.Arrays;

public class SumArray {
    public static void main(String[] args) {
        // Create an array of size 50
        int[] numbers = new int[50];

        // Fill the array with numbers 1 to 50
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // Put numbers in Array
        Arrays.toString(numbers);

        // Compute the sum using the array
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Display the sum
        System.out.println("Sum = " + sum);
    }
}

