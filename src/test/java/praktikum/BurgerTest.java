package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.helper.FoodFactory;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;


    @Test
    public void shouldReturnCorrectReceipt() {
        var sauce = FoodFactory.getIngredient(IngredientType.SAUCE, "goodSauce");
        var filling = FoodFactory.getIngredient(IngredientType.FILLING, "deliciousFilling");
        var bun = FoodFactory.getBun("fluffyBun");
        Burger burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.setBuns(bun);

        assertReceipt(burger, "22,000000", Map.of(
                0, bun.getName(),
                1, sauce.getName(),
                2, filling.getName(),
                3, bun.getName()
        ));
    }

    @Test
    public void shouldReorderIngredientsCorrectly() {
        var sauce = FoodFactory.getIngredient(IngredientType.SAUCE, "goodSauce");
        var filling = FoodFactory.getIngredient(IngredientType.FILLING, "deliciousFilling");
        var bun = FoodFactory.getBun("fluffyBun");
        Burger burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.setBuns(bun);

        burger.moveIngredient(0, 1);
        assertReceipt(burger, "22,000000", Map.of(
                0, bun.getName(),
                1, filling.getName(),
                2, sauce.getName(),
                3, bun.getName()
        ));
    }

    @Test
    public void shouldRemoveIngredientCorrectly() {
        var sauce = FoodFactory.getIngredient(IngredientType.SAUCE, "goodSauce");
        var filling = FoodFactory.getIngredient(IngredientType.FILLING, "deliciousFilling");
        var bun = FoodFactory.getBun("fluffyBun");
        Burger burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.setBuns(bun);

        burger.removeIngredient(0);

        assertReceipt(burger, "12,000000", Map.of(
                0, bun.getName(),
                1, filling.getName(),
                2, bun.getName()
        ));
    }


    @Test
    public void getPrice() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = 500F;

        MatcherAssert.assertThat("There is problem in price calculations",
                burger.getPrice(),
                equalTo(expectedPrice));
    }


    private void assertReceipt(Burger burger, String price, Map<Integer, String> expectedSlices) {
        var receipt = burger.getReceipt();
        var receiptSlices = receipt.split(System.lineSeparator());
        expectedSlices.forEach((sliceIdx, expectedSlice) ->
                assertTrue(
                        "Mismatch on index = " + sliceIdx,
                        receiptSlices[sliceIdx].contains(expectedSlice
                        )));

        assertTrue("Price mismatch", Arrays.stream(receiptSlices).anyMatch(it -> it.contains(price)));
    }

}