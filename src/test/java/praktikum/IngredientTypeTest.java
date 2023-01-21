package praktikum;

import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void fillingIsNotNull() {
      assert  IngredientType.FILLING != null;
    }

    @Test
    public void sauceIsNotNull() {
        assert IngredientType.SAUCE != null;
    }
}