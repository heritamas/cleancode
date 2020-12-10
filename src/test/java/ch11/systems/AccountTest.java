package ch11.systems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @Test
    public void given20AndMin10_whenWithdraw5_thenSuccess() {
        // given
        account = new Account(20);

        // then
        assertTrue(account.withdraw(5));
    }

    @Test
    public void given20AndMin10_whenWithdraw100_thenFail() {
        // given
        account = new Account(20);

        // then
        assertFalse(account.withdraw(100));
    }
}