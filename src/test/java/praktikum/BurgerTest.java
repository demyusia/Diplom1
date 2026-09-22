package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseTest {

    private final Ingredient ingredient1 = Mockito.mock(Ingredient.class);
    private final Ingredient ingredient2 = Mockito.mock(Ingredient.class);

    @Test
    public void checkSetBuns () {
        assertNotNull(burger.bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertFalse(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1,0);
        assertEquals(2, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

}