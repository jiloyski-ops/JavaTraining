package M4_Act1;

public class BankAccount {

    // Method to get account name based on account number
    public static String getAccountName(String accountNumber) {
        if (accountNumber.equals("ACC-001")) {
            return "Juan Dela Cruz";
        } else if (accountNumber.equals("ACC-002")) {
            return "Maria Santos";
        } else {
            return null; // Account not found
        }
    }

    // Test case method
    public static void testCase(String accountNumber) {
        System.out.println("\nLooking up account: " + accountNumber);
        try {
            String name = getAccountName(accountNumber);
            // Convert name to uppercase
            System.out.println("Account holder: " + name.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Error: Account not found!");
        }
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("=== Bank Account Name Display ===");

        // Test valid account
               testCase("ACC-001");

        // Test invalid account
        testCase("ACC-999");

        System.out.println("\n=== Program completed successfully! ===");
    }
}
