package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseTest {

    private final Ingredient firstIngredient = Mockito.mock(Ingredient.class);
    private final Ingredient secondIngredient = Mockito.mock(Ingredient.class);
    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void checkSetBuns () {
        softly.assertThat(burger.bun).isNotNull();
        softly.assertThat(burger.bun).isEqualTo(bun);
        softly.assertAll();
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(firstIngredient);
        softly.assertThat(burger.ingredients.size()).isEqualTo(1);
        softly.assertThat(burger.ingredients.get(0)).isEqualTo(firstIngredient);
        softly.assertAll();
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        softly.assertThat(burger.ingredients.size()).isEqualTo(1);
        softly.assertThat(burger.ingredients.get(0)).isEqualTo(secondIngredient);
        softly.assertThat(burger.ingredients.contains(firstIngredient)).isFalse();
        softly.assertAll();
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1,0);
        softly.assertThat(burger.ingredients.size()).isEqualTo(2);
        softly.assertThat(burger.ingredients.get(0)).isEqualTo(secondIngredient);
        softly.assertThat(burger.ingredients.get(1)).isEqualTo(firstIngredient);
        softly.assertAll();
    }

}