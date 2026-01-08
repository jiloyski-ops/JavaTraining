package M4_Act5;

public class AccountValidator {

 /**
  * Validates the account number in this exact order:
  * 1) Null check -> throws NullPointerException("Account number cannot be null")
  * 2) Format check (must be digits only) -> throws InvalidAccountFormatException("Account number must contain only digits")
  * 3) Length check (must be 10) -> throws InvalidAccountNumberException("Account number must be exactly 10 digits")
  * 4) If valid -> prints "Valid account number: [accountNumber]"
  *
  * Note: Only the checked exception is declared in the signature.
  */
 public static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
     // 1) Null check
     if (accountNumber == null) {
         throw new NullPointerException("Account number cannot be null");
     }

     // 2) Format: must contain only digits (no spaces, letters, symbols)
     for (char c : accountNumber.toCharArray()) {
         if (!Character.isDigit(c)) {
             throw new InvalidAccountFormatException("Account number must contain only digits");
         }
     }

     // 3) Length = 10
     if (accountNumber.length() != 10) {
         throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
     }

     // 4) Valid
     System.out.println("Valid account number: " + accountNumber);
 }

 /**
  * Helper to avoid repeating try-catch blocks for each test case.
  */
 private static void testValidation(String testName, String accountNumber) {
     System.out.println("Test " + testName + ": " + (accountNumber == null ? "Null value" : accountNumber));
     try {
         validateAccountNumber(accountNumber);
     } catch (InvalidAccountNumberException e) {
         // Checked exception (length error)
         System.out.println("Error: " + e.getMessage());
     } catch (InvalidAccountFormatException e) {
         // Unchecked exception (non-digit error)
         System.out.println("Warning: " + e.getMessage());
     } catch (NullPointerException e) {
         // Null input
         System.out.println("Warning: " + e.getMessage());
     }
     System.out.println(); // spacing between tests
 }

 public static void main(String[] args) {
     System.out.println("=== Account Number Validation Test ===\n");

     // Step 5: Run five test cases
     testValidation("1: Valid account", "1234567890");      // valid (all digits, length 10)
     testValidation("2: Too short", "123");                  // length error -> InvalidAccountNumberException
     testValidation("3: Contain letters", "12345ABC90");     // format error -> InvalidAccountFormatException
     testValidation("4: Contains space", "1234 567890");     // format error -> InvalidAccountFormatException
     testValidation("5: Null value", null);                  // null error -> NullPointerException

     System.out.println("=== All tests completed ===");
 }
}

