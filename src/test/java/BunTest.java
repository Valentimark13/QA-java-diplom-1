import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("White", 100);
    }

    @Test
    public void shouldReturnCorrectBunName() {
        assertEquals("White", bun.getName());
    }

    @Test
    public void shouldReturnCorrectBunPrice() {
        assertEquals(100, bun.getPrice(), 0);
    }
}
