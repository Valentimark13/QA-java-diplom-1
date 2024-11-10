import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 20);
    }

    @Test
    public void shouldReturnCorrectIngredientName() {
        assertEquals("Ketchup", ingredient.getName());
    }

    @Test
    public void shouldReturnCorrectIngredientPrice() {
        assertEquals(20, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldReturnCorrectIngredientType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
