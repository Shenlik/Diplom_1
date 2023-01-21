package praktikum.helper;

import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class FoodFactory {

    public static final double PRICE_DELTA = 1E-6;

    public static Bun getBun() {
        return new Bun("bunName", 1F);
    }

    public static Bun getBun(String name) {
        return new Bun(name, 1F);
    }

    public static Bun getBun(float price) {
      return new Bun("bunName", price);
    }

    public static Ingredient getIngredient() {
        return getIngredient(IngredientType.SAUCE, 10F);
    }

    public static Ingredient getIngredient(float price) {
        return getIngredient(IngredientType.SAUCE, price);
    }

    public static Ingredient getIngredient(IngredientType type) {
        return getIngredient(type, 10F);
    }

    public static Ingredient getIngredient(IngredientType type, String name) {
        return new Ingredient(type, name, 10F);
    }

    public static Ingredient getIngredient(IngredientType type, float price) {
        return new Ingredient(type, "ingredientName", price);
    }
}
