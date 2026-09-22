package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetBurgerReceiptParameterizedTest extends BaseTest{

    @Parameterized.Parameter()
    public List<Ingredient> ingredientsList;
    @Parameterized.Parameter(1)
    public int ingredientsCount;
    @Parameterized.Parameter(2)
    public String receiptExpected;

    @Parameterized.Parameters(name="бургер: 2 булки и {1} ингредиентов")
    public static Object[][] getData() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient1.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient2.getName()).thenReturn("cutlet");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getPrice()).thenReturn(1000.0f);

        return new Object[][]{
                {List.of(), 0,
                        "(==== red bun ====)\n" +
                        "(==== red bun ====)\n" +
                        "\n" +
                         "Price: 400,000000\n"},
                {List.of(ingredient1), 1,
                        "(==== red bun ====)\n" +
                        "= sauce hot sauce =\n" +
                        "(==== red bun ====)\n" +
                        "\n" +
                        "Price: 500,000000\n"},
                {List.of(ingredient1, ingredient2), 2,
                        "(==== red bun ====)\n" +
                        "= sauce hot sauce =\n" +
                        "= filling cutlet =\n" +
                        "(==== red bun ====)\n" +
                        "\n" +
                        "Price: 1500,000000\n"}
        };
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(200.0f);

        for (Ingredient ingredient:ingredientsList) {
            burger.addIngredient(ingredient);
        }
        assertEquals(receiptExpected, burger.getReceipt());
    }
}
