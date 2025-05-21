import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Alice", 100.0);
    }

    @Test
    void creation_valide(){
        assertTrue(account.getBalance() >= 0);
    }

    @Test
    void creation_compte_invalide(){
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("Bob", -50);
        });
    }

    @Test
    void depot_valide(){
        account.deposit(2);
        assertTrue(account.getBalance() == 102);
    }

    @Test
    void depot_invalide(){
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-2);
        });
    }

    @Test
    void retrait_valide(){
        account.withdraw(5);
        assertTrue(account.getBalance() == 95.0);
    }

    @Test
    void retrait_invalide_manque_provision(){
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200);
        });
    }

    void retrait_invalide_montant_negatif(){
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-2);
        });
    }

}


// javac -cp lib/junit-platform-console-standalone-1.10.0.jar -d bin src/BankAccount.java test/BankAccountTest.java
// java -jar lib/junit-platform-console-standalone-1.10.0.jar -cp bin -c BankAccountTest


