package com.tin.whattoeat.Model;

/**
 * Created by mbp on 9/26/16.
 */

public class GroceryItem
{
    private Ingredient ingredient;
    private int quantity;

    public GroceryItem(Ingredient ingredient, int quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity()
    {
        quantity++;
    }

    public void decreaseQuantity()
    {
        quantity--;
        if(quantity < 0)
            quantity = 0;
    }
}
