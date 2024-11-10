import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter
    public String type;

    @Parameterized.Parameters(name = "Тип ингредиента: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        });
    }

    @Test
    public void testIngredientTypeValues() {
        IngredientType ingredientType = IngredientType.valueOf(type);
        assertNotNull("Тип ингредиента не должен быть null", ingredientType);
    }

    @Test
    public void testIngredientTypeEnumValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals("Количество значений в IngredientType должно быть 2", 2, values.length);
        assertEquals("Первое значение должно быть SAUCE", IngredientType.SAUCE, values[0]);
        assertEquals("Второе значение должно быть FILLING", IngredientType.FILLING, values[1]);
    }
}
