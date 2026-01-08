package M4_Act4;


public class AccountValidator {

    /**
     * Validates the account number.
     * - Throws NullPointerException if accountNumber is null (message: "Cannot be null")
     * - Throws Exception if length is not 10 (message: "Must be 10 digits")
     * - Prints "Valid account: [number]" if valid
     */
    public static void validateAccountNumber(String accountNumber) throws Exception {
        // Check for null
        if (accountNumber == null) {
            throw new NullPointerException("Cannot be null");
        }

        // Check for length != 10
        if (accountNumber.length() != 10) {
            throw new Exception("Must be 10 digits");
        }

        // If valid
        System.out.println("Valid account: " + accountNumber);
    }

    public static void main(String[] args) {
        // Test case 1: valid (should pass)
        try {
            validateAccountNumber("1234567890");
        } catch (NullPointerException npe) {
            System.out.println("Error: " + npe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test case 2: invalid (too short)
        try {
            validateAccountNumber("123");
        } catch (NullPointerException npe) {
            System.out.println("Error: " + npe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test case 3: invalid (null)
        try {
            validateAccountNumber(null);
        } catch (NullPointerException npe) {
            System.out.println("Error: " + npe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
