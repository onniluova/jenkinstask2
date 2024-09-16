
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance(), 0.01);
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        account.deposit(100.0);
        double amountWithdrawn = account.withdraw(50.0);
        assertEquals(50.0, amountWithdrawn, 0.01);
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        double amountWithdrawn = account.withdraw(50.0);
        assertEquals(0.0, amountWithdrawn, 0.01);
        assertEquals(0.0, account.getBalance(), 0.01);
    }
}
