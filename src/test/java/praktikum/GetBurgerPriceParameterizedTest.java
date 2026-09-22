package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetBurgerPriceParameterizedTest extends BaseTest{

    @Parameterized.Parameter()
    public float expectedPrice;
    @Parameterized.Parameter(1)
    public List<Ingredient> ingredientsList;

    @Parameterized.Parameters(name="стоимость={0}, бургер: 2 булки и {1}")
    public static Object[][] getData() {
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient1.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient2.getPrice()).thenReturn(1000.0f);

        return new Object[][]{
                {400.0f, List.of()},
                {500.0f, List.of(ingredient1)},
                {1500.0f, List.of(ingredient1, ingredient2)}
        };
    }

    @Test
    public void checkGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        for (Ingredient ingredient:ingredientsList) {
            burger.addIngredient(ingredient);
        }
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

}
