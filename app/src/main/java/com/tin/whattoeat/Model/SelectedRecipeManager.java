package com.tin.whattoeat.Model;

import java.util.ArrayList;

/**
 * Created by mbp on 9/26/16.
 */

public class SelectedRecipeManager
{

    public ArrayList<MealItem> selectedGroceries;

    public SelectedRecipeManager()
    {
        selectedGroceries = new ArrayList<>();
    }

    public SelectedRecipeManager(ArrayList<MealItem> selectedGroceries)
    {
        this.selectedGroceries = selectedGroceries;
    }

    public void addSelectedRecipe(Recipe recipe)
    {
        for(MealItem item : selectedGroceries)
        {
            if(item.getRecipe().getName().compareToIgnoreCase(recipe.getName()) == 0)
            {
                item.increaseQuantity();
                return;
            }

        }

        selectedGroceries.add(new MealItem(recipe, 1));
    }


    public int getTotalSelectedMeal()
    {
        int sum = 0;
        for(MealItem mi : selectedGroceries)
            sum += mi.getQuantity();
        return sum;
    }
//    public void removeSelectedIngredient(Ingredient ingredient)
//    {
//        for(GroceryItem item : selectedGroceries)
//        {
//            if(item.getIngredient().getIngName().compareToIgnoreCase(ingredient.getIngName()) == 0)
//            {
//                item.decreaseQuantity();
//                break;
//            }
//
//        }
//    }

//    public GroceryItem getGroceryItem(Ingredient ingredient)
//    {
//        for(GroceryItem item : selectedGroceries)
//        {
//            if(item.getIngredient().getIngName().compareToIgnoreCase(ingredient.getIngName()) == 0)
//            {
//                return item;
//            }
//
//        }
//        return null;
//
//    }

    public int getItemsCount()
    {
        return selectedGroceries.size();
    }

    public MealItem at(int position)
    {
        return selectedGroceries.get(position);
    }


}