import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    private String expectedBurgerName;
    private int expectedBurgerPrice;

    @Parameterized.Parameters
    public static Object[][] burgerData() {
        return new Object[][]{
                {"Classic Burger", 300},
                {"Spicy Burger", 350}
        };
    }

    public BurgerTest(String expectedBurgerName, int expectedBurgerPrice) {
        this.expectedBurgerName = expectedBurgerName;
        this.expectedBurgerPrice = expectedBurgerPrice;
    }

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = mock(Bun.class);
        mockIngredient = mock(Ingredient.class);

        // Настройка моков
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockBun.getName()).thenReturn(expectedBurgerName);
        when(mockIngredient.getPrice()).thenReturn(50f);
        when(mockIngredient.getName()).thenReturn("Cheese");
        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void shouldSetBunCorrectly() {
        burger.setBuns(mockBun);  // Метод для установки булочки
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void shouldAddIngredientCorrectly() {
        burger.addIngredient(mockIngredient);  // Метод для добавления ингредиентов
        List<Ingredient> ingredients = burger.ingredients;
        assertTrue(ingredients.contains(mockIngredient));
    }

    @Test
    public void shouldRemoveIngredientCorrectly() {
        burger.addIngredient(mockIngredient);  // Добавляем ингредиент сначала
        burger.removeIngredient(0);  // Удаляем по индексу
        List<Ingredient> ingredients = burger.ingredients;
        assertFalse(ingredients.contains(mockIngredient));
    }

    @Test
    public void shouldMoveIngredientCorrectly() {
        Ingredient mockIngredient2 = mock(Ingredient.class);
        burger.addIngredient(mockIngredient);    // Добавляем первый ингредиент
        burger.addIngredient(mockIngredient2);   // Добавляем второй ингредиент
        burger.moveIngredient(0, 1);  // Перемещаем первый ингредиент на вторую позицию
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(mockIngredient, ingredients.get(1));  // Проверяем, что первый ингредиент теперь на второй позиции
    }

    @Test
    public void shouldCalculateBurgerPriceCorrectly() {
        burger.setBuns(mockBun);  // Устанавливаем булочку
        burger.addIngredient(mockIngredient);  // Добавляем ингредиент
        float expectedPrice = 200f + 50f;  // Цена булочки + ингредиент
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void shouldReturnCorrectIngredientsList() {
        burger.addIngredient(mockIngredient);  // Добавляем ингредиент
        List<Ingredient> ingredients = burger.ingredients;  // Получаем список ингредиентов
        assertNotNull(ingredients);  // Проверяем, что список не пуст
        assertTrue(ingredients.contains(mockIngredient));
    }

    @Test
    public void shouldReturnCorrectReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        // Ожидаемый формат чека
        String expectedReceipt = "(==== " + expectedBurgerName + " ====)\n" +
                "= filling Cheese =\n" +
                "(==== " + expectedBurgerName + " ====)\n\n" +
                "Price: 250.000000\n";

        // Проверяем, что чек формируется корректно
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}