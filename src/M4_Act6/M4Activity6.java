package M4_Act6;


//No external imports needed

//============================================================================
//1. Custom Exceptions
//============================================================================

class InvalidAmountException extends Exception {
 public InvalidAmountException(String message) { super(message); }
}

class InsufficientFundsException extends Exception {
 private final double balance;
 private final double requestedAmount;

 public InsufficientFundsException(String message, double balance, double requestedAmount) {
     super(message);
     this.balance = balance;
     this.requestedAmount = requestedAmount;
 }
 public double getBalance() { return balance; }
 public double getRequestedAmount() { return requestedAmount; }
}

//============================================================================
//2. Functional Interface
//============================================================================
@FunctionalInterface
interface BankTestOperation {
 void execute() throws InvalidAmountException, InsufficientFundsException;
}

//============================================================================
//3. BankAccount Class
//============================================================================
class BankAccount {

 private double balance = 10000;   // Starting balance ₱10,000

 // 4) withdraw(double amount)
 public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
     logInfo(String.format("Withdrawal requested: ₱%.2f", amount));

     if (amount <= 0) {
         logError("Invalid withdrawal amount: " + amount);
         throw new InvalidAmountException("Amount must be greater than 0!");
     }

     if (amount > balance) {
         logWarn(String.format("Insufficient funds! Balance: ₱%.2f, Requested: ₱%.2f", balance, amount));
         throw new InsufficientFundsException("Insufficient funds!", balance, amount);
     }

     balance -= amount;
     logInfo(String.format("Withdrawal completed: ₱%.2f, New balance: ₱%.2f", amount, balance));
 }

 // 5) deposit(double amount)
 public void deposit(double amount) throws InvalidAmountException {
     logInfo(String.format("Deposit requested: ₱%.2f", amount));

     if (amount <= 0) {
         logError("Invalid deposit amount: " + amount);
         throw new InvalidAmountException("Amount must be greater than 0!");
     }

     if (amount > 50000) {
         logWarn(String.format("Large deposit detected: ₱%.2f", amount));
     }

     balance += amount;
     logInfo(String.format("Deposit completed: ₱%.2f, New balance: ₱%.2f", amount, balance));
 }

 public double getBalance() { return balance; }

 // Simple logger substitutes
 private void logInfo(String msg) { System.out.println("[INFO] " + msg); }
 private void logWarn(String msg) { System.out.println("[WARN] " + msg); }
 private void logError(String msg) { System.err.println("[ERROR] " + msg); }
}

//============================================================================
//6. runTest() helper + 7. Tests in main()
//============================================================================
public class M4Activity6 {

 public static void runTest(BankTestOperation operation, String operationName) {
     System.out.println("\n[TEST] Running: " + operationName);
     try {
         operation.execute();
     } catch (InvalidAmountException e) {
         System.err.println("[ERROR] InvalidAmountException during " + operationName + ": " + e.getMessage());
     } catch (InsufficientFundsException e) {
         System.err.println(String.format(
             "[ERROR] InsufficientFundsException during %s: Balance ₱%.2f, Requested ₱%.2f",
             operationName, e.getBalance(), e.getRequestedAmount()
         ));
     }
 }

 public static void main(String[] args) {
     BankAccount account = new BankAccount();

     // Test 1: Valid deposit
     runTest(() -> account.deposit(5000), "Deposit");

     // Test 2: Invalid withdrawal (negative)
     runTest(() -> account.withdraw(-3000), "Withdrawal");

     // Test 3: Large deposit (> 50,000) should WARN but continue
     runTest(() -> account.deposit(50001), "Deposit");

     // Test 4: Insufficient funds
     runTest(() -> account.withdraw(20000), "Withdrawal");

     // Test 5: Another valid deposit
     runTest(() -> account.deposit(60000), "Deposit");
 }
}

