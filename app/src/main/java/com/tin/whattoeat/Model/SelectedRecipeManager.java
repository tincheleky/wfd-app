package com.tin.whattoeat.Model;

import java.util.ArrayList;

/**
 * Created by mbp on 9/26/16.
 */

public class SelectedRecipeManager
{

    public ArrayList<MealItem> selectedMeals;

    public SelectedRecipeManager()
    {
        selectedMeals = new ArrayList<>();
    }

    public SelectedRecipeManager(ArrayList<MealItem> selectedGroceries)
    {
        this.selectedMeals = selectedGroceries;
    }

    public void addSelectedRecipe(Recipe recipe)
    {
        for(MealItem item : selectedMeals)
        {
            if(item.getRecipe().getName().compareToIgnoreCase(recipe.getName()) == 0)
            {
                item.increaseQuantity();
                return;
            }

        }

        selectedMeals.add(new MealItem(recipe, 1));
    }


    public int getTotalSelectedMeal()
    {
        int sum = 0;
        for(MealItem mi : selectedMeals)
            sum += mi.getQuantity();
        return sum;
    }

    public int getItemsCount()
    {
        return selectedMeals.size();
    }

    public MealItem at(int position)
    {
        return selectedMeals.get(position);
    }


}