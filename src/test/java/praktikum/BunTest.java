package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.helper.FoodFactory.PRICE_DELTA;


public class BunTest {

    @Test
    public void rename() {
        var bun = new Bun(
                "testName",
                12F
        );

        assertEquals("testName", bun.getName());
        assertEquals(12F, bun.getPrice(), PRICE_DELTA);
    }
}