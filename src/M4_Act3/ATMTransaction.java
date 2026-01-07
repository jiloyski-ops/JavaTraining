package M4_Act3;


public class ATMTransaction {

    /**
     * Checks balance and prints a receipt, handling invalid formats safely.
     *
     * @param accountNumber The account number as String (first char indicates type).
     * @param balance       The current balance as double.
     */
    public static void checkBalance(String accountNumber, double balance) {
        System.out.println("Processing balance inquiry...");

        try {
            // Validate account number by converting to integer (ensures numeric-only)
            // This will throw NumberFormatException if it contains any non-digit characters.
            Integer.parseInt(accountNumber);

            // Get account type from first character
            char accountType = accountNumber.charAt(0);
            String typeLabel;
            if (accountType == '1') {
                typeLabel = "Account Type: Savings";
            } else if (accountType == '2') {
                typeLabel = "Account Type: Checking";
            } else {
                typeLabel = "Account Type: Unknown";
            }

            // Print details on success
            System.out.println(typeLabel);
            System.out.println("Account Number: " + accountNumber);
            System.out.printf("Current Balance: P%.2f%n", balance);
            System.out.println("Balance inquiry successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid account number format!");
            System.out.println("Account numbers must be numeric.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Account number is empty or invalid!");
        } finally {
            // Always prints, regardless of success or failure
            System.out.println("\n================ RECEIPT ================");
            System.out.println("Print: Transaction Date: December 3, 2025");
            System.out.println("Print: Transaction Type: Balance Inquiry");
            System.out.println("Print: ATM Location: Main Branch");
            System.out.println("Print: Thank you for banking with us!");
            System.out.println("=========================================\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ATM Balance Check with Receipt ===\n");

        // Test 1: Valid Savings account (success)
        System.out.println("--- Test 1: Valid Savings account ---");
        checkBalance("100123456", 15000.00);

        // Test 2: Valid Checking account (success)
        System.out.println("--- Test 2: Valid Checking account ---");
        checkBalance("200987654", 25000.00);

        // Test 3: Invalid format -> NumberFormatException
        System.out.println("--- Test 3: Invalid Format ---");
        checkBalance("ABC12345", 15000.00);

        // Test 4: Empty string -> StringIndexOutOfBoundsException
        System.out.println("--- Test 4: Empty Account Number ---");
        checkBalance("", 15000.00);

        System.out.println("=== All tests completed! ===");
    }
}