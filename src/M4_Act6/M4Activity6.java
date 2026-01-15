package M4_Act6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// -------------------- 1) Custom Exceptions --------------------
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

// -------------------- 2) Functional Interface --------------------
@FunctionalInterface
interface BankTestOperation {
    void execute() throws InvalidAmountException, InsufficientFundsException;
}

// -------------------- 3) BankAccount --------------------
class BankAccount {
    private static final Logger log = LoggerFactory.getLogger(BankAccount.class);
    private double balance = 10_000; // ₱10,000 initial

    // 4) withdraw(double)
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        log.info("Withdrawal requested: ₱{}", amount);

        if (amount <= 0) {
            log.error("Invalid withdrawal amount: {}", amount);
            throw new InvalidAmountException("Amount must be greater than 0!");
        }
        if (amount > balance) {
            log.warn("Insufficient funds! Balance: ₱{}, Requested: ₱{}", balance, amount);
            throw new InsufficientFundsException("Insufficient funds!", balance, amount);
        }
        balance -= amount;
        log.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance);
    }

    // 5) deposit(double)
    public void deposit(double amount) throws InvalidAmountException {
        log.info("Deposit requested: ₱{}", amount);

        if (amount <= 0) {
            log.error("Invalid deposit amount: {}", amount);
            throw new InvalidAmountException("Amount must be greater than 0!");
        }
        if (amount > 50_000) {
            log.warn("Large deposit detected: ₱{}", amount);
        }
        balance += amount;
        log.info("Deposit completed: ₱{}, New balance: ₱{}", amount, balance);
    }

    public double getBalance() { return balance; }
}

// -------------------- 6) runTest helper + 7) Tests --------------------
public class M4Activity6 {
    private static final Logger log = LoggerFactory.getLogger(M4Activity6.class);

    public static void runTest(BankTestOperation op, String name) {
        log.info("Running test: {}", name);
        try {
            op.execute();
        } catch (InvalidAmountException e) {
            log.error("InvalidAmountException during {}: {}", name, e.getMessage());
        } catch (InsufficientFundsException e) {
            log.error("InsufficientFunds during {}: Balance: ₱{}, Requested: ₱{}",
                    name, e.getBalance(), e.getRequestedAmount());
        }
    }

    public static void main(String[] args) {
        // (Optional) ensure logs/ exists when running from some IDEs/packagers
        try { new java.io.File("logs").mkdirs(); } catch (Exception ignore) {}

        BankAccount account = new BankAccount();

        runTest(() -> account.deposit(5000), "Deposit");
        runTest(() -> account.withdraw(-3000), "Withdrawal");
        runTest(() -> account.deposit(50001), "Deposit");
        runTest(() -> account.withdraw(20000), "Withdrawal");
               runTest(() -> account.deposit(60000), "Deposit");

        log.info("All tests completed.");
    }
}
