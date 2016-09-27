package com.tin.whattoeat.Model;

/**
 * Created by mbp on 9/26/16.
 */

public class MealItem
{
    private Recipe recipe;
    private int quantity;

    public MealItem(Recipe recipe, int quantity) {
        this.recipe = recipe;
        this.quantity = quantity;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
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
