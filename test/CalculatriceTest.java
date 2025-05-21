import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatriceTest {
    private Calculatrice calc;

    @BeforeEach
    void setUp() {
        calc = new Calculatrice();
    }

    @Test
    void testAdditionner() {
        assertEquals(5, calc.additionner(2, 3));
    }

    @Test
    void testAdditionnerNegative() {
        assertEquals(1, calc.additionner(-2, 3));
    }

    @Test
    void testAdditionnerZero() {
        assertEquals(0, calc.additionner(0, 0));
    }

    @Test
    void testSoustraire() {
        assertEquals(2, calc.soustraire(5, 3));
    }

    @Test
    void testSoustraireNegative() {
        assertEquals(-1, calc.soustraire(2, 3));
    }

    @Test
    void testDiviser() {
        assertEquals(2, calc.diviser(10, 5));
    }

    @Test
    void testDivisionNegative() {
        assertEquals(-2, calc.diviser(-10, 5));
    }

    @Test
    void testDivisionParZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.diviser(10, 0));
    }
}


// java -jar lib/junit-platform-console-standalone-1.10.0.jar -cp bin -c CalculatriceTest
// javac -cp lib/junit-platform-console-standalone-1.10.0.jar -d bin src/Calculatrice.java test/CalculatriceTest.java
