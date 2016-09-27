package com.tin.whattoeat.Model;
import com.tin.whattoeat.Model.Recipe;


public class DailyMeals
{
    public String name;
    public Recipe breakfastRecipe;
    public Recipe lunchRecipe;
    public Recipe dinnerRecipe;

    public DailyMeals(int i,
                      Recipe breakfastRecipe,
                      Recipe lunchRecipe,
                      Recipe dinnerRecipe)
    {
        this.breakfastRecipe = breakfastRecipe;
        this.lunchRecipe = lunchRecipe;
        this.dinnerRecipe = dinnerRecipe;

        switch(i)
        {
            case 1:
                name = "Monday";
                break;
            case 2:
                name = "Tuesday";
                break;
            case 3:
                name = "Wednesday";
                break;
            case 4:
                name = "Thursday";
                break;
            case 5:
                name = "Friday";
                break;
            case 6:
                name = "Saturday";
                break;
            case 7:
                name = "Sunday";
                break;
        }
    }

}