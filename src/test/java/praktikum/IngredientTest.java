package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.helper.FoodFactory.PRICE_DELTA;


public class IngredientTest {

    @Test
    public void rename() {
        var ingredient = new Ingredient(
                IngredientType.SAUCE,
                "testName",
                12F
        );

        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("testName", ingredient.getName());
        assertEquals(12F, ingredient.getPrice(), PRICE_DELTA);
    }

}