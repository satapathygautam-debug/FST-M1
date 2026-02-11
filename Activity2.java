import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {

    @Test
    void notEnoughFunds() {
        // Create account with low balance
        BankAccount account = new BankAccount(9);

        // Assert that exception is thrown
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10));
    }

    @Test
    void enoughFunds() {
        // Create account with sufficient balance
        BankAccount account = new BankAccount(100);

        // Assert that no exception is thrown
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}
