package com.tin.whattoeat.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mbp on 9/26/16.
 */

public class GroceriesManager
{
    private ArrayList<GroceryItem> selectedGroceries;

    public GroceriesManager()
    {
        selectedGroceries = new ArrayList<>();
    }

    public GroceriesManager(ArrayList<GroceryItem> selectedGroceries)
    {
        this.selectedGroceries = selectedGroceries;
    }

    public void addSelectedIngredient(Ingredient ingredient)
    {
        for(GroceryItem item : selectedGroceries)
        {
            if(item.getIngredient().getIngName().compareToIgnoreCase(ingredient.getIngName()) == 0)
            {
                item.setQuantity(item.getQuantity() + (int)ingredient.getQuantity());
                return;
            }

        }

        selectedGroceries.add(new GroceryItem(ingredient, (int)ingredient.getQuantity()));
    }

    public void addSelectedRecipe(Recipe recipe)
    {
        ArrayList<Ingredient> temp = recipe.getIngredientsList();
        for(Ingredient ingredient : temp)
            addSelectedIngredient(ingredient);
    }

    public void removeSelectedIngredient(Ingredient ingredient)
    {
        for(GroceryItem item : selectedGroceries)
        {
            if(item.getIngredient().getIngName().compareToIgnoreCase(ingredient.getIngName()) == 0)
            {
                item.decreaseQuantity();
                break;
            }

        }
    }

    public GroceryItem getGroceryItem(Ingredient ingredient)
    {
        for(GroceryItem item : selectedGroceries)
        {
            if(item.getIngredient().getIngName().compareToIgnoreCase(ingredient.getIngName()) == 0)
            {
                return item;
            }

        }
        return null;

    }

    public ArrayList<GroceryItem> getSelectedGroceries() {
        return selectedGroceries;
    }

    public void setSelectedGroceries(ArrayList<GroceryItem> selectedGroceries) {
        this.selectedGroceries = selectedGroceries;
    }

    public int getItemsCount()
    {
        return selectedGroceries.size();
    }

    public GroceryItem at(int position)
    {
        return selectedGroceries.get(position);
    }

    private void _addQuantity(Ingredient ingredient, int quantity)
    {
        for(GroceryItem item : selectedGroceries)
        {
            if(item.getIngredient().getIngName().compareToIgnoreCase(ingredient.getIngName()) == 0)
            {
                item.setQuantity(item.getQuantity() + quantity);
            }

        }
    }

}
