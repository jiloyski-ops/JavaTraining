package M4_Act2;

public class ATMSystem {

    // Array of account balances (index: 0 -> Account 0, 1 -> Account 1, 2 -> Account 2)
    private static double[] accounts = {10000, 15000, 20000};

    /**
     * Processes a withdrawal given the account index and the withdrawal amount as Strings.
     * Handles invalid inputs, account not found, and insufficient funds scenarios.
     */
    public static void processWithdrawal(String accountIndex, String amountInput) {
        System.out.println("Account=" + accountIndex + ", Amount=" + amountInput);

        try {
            // Parse inputs
            int index = Integer.parseInt(accountIndex);         // may throw NumberFormatException
            double amount = Double.parseDouble(amountInput);    // may throw NumberFormatException

            // Try to read the current balance (may throw ArrayIndexOutOfBoundsException)
            double currentBalance = accounts[index];

            // Show current state
            System.out.printf("Current balance: P%.2f%n", currentBalance);
            System.out.printf("Withdrawal: P%.2f%n", amount);

            // Business rule: insufficient funds
            if (amount > currentBalance) {
                System.out.printf("Insufficient funds! Cannot withdraw P%.2f%n", amount);
                return;
            }

            // Compute new balance and "commit" the withdrawal
            double newBalance = currentBalance - amount;
            accounts[index] = newBalance;

            System.out.printf("New balance: P%.2f%n", newBalance);
            System.out.println("Withdrawal successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input!");
            System.out.println("Please enter valid numbers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Account not found!");
            System.out.println("Invalid account index.");
        } catch (Exception e) {
            // Catch-all for any unexpected errors
            System.out.println("Error: Transaction failed!");
            System.out.println("Details: " + e.getMessage());
        }
    }

    // Demo / test runner
    public static void main(String[] args) {
        System.out.println("=== ATM Withdrawal System ===\n");

        System.out.println("--- Test 1: Valid Withdrawal ---");
        processWithdrawal("1", "5000");   // Success: Account 1 has 15000

        System.out.println("\n--- Test 2: Invalid Account Index ---");
        processWithdrawal("abc", "5000"); // NumberFormatException

        System.out.println("\n--- Test 3: Account Not Found ---");
        processWithdrawal("10", "5000");  // ArrayIndexOutOfBoundsException

        System.out.println("\n--- Test 4: Insufficient Funds ---");
        processWithdrawal("1", "20000");  // Insufficient funds (Account 1 now has 10000 after Test 1)

        System.out.println("\n=== All tests completed! ===");
    }
}