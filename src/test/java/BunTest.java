import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {
    private Bun bun;
    private final static int PRICE = 100;

    @Before
    public void setUp() {
        bun = new Bun("White", PRICE);
    }

    @Test
    public void shouldReturnCorrectBunName() {
        assertEquals("White", bun.getName());
    }

    @Test
    public void shouldReturnCorrectBunPrice() {
        assertEquals(PRICE, bun.getPrice(), 0);
    }
}
