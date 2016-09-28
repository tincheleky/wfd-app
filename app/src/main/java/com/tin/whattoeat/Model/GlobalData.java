package com.tin.whattoeat.Model;

import android.content.Intent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mbp on 9/25/16.
 */

public class GlobalData
{
    private static ArrayList<String> ingNameList;
    private static ArrayList<String> unitList;
    private static ArrayList<Recipe> recipeList;
    public static ArrayList<MealItem> mealList;
    public static GroceriesManager groceriesManager;
    public static SelectedRecipeManager selectedRecipeManager;
    public static int[] Goal;

    public static int DEFAULT_PHOTO_WIDTH = 1600;
    public static int DEFAULT_PHOTO_HEIGHT = 1200;

    public static String DESCRIPTION = "";
    public static String DEFAULT_PHOTO_URL = "http://previews.123rf.com/images/blankstock/blankstock1501/blankstock150100865/35309809-Cappello-Chef-sign-icon-Simbolo-di-cottura-Cappello-Cuochi-con-piatto-caldo-Bottone-piatto-grigio-co-Archivio-Fotografico.jpg";
    static {

        Goal = new int[7];
        for(int i : Goal){
            Goal[i] = 0;
        }
        ingNameList = new ArrayList<>();
        unitList = new ArrayList<>();
        recipeList = new ArrayList<>();
        mealList = new ArrayList<>();
        groceriesManager = new GroceriesManager();
        selectedRecipeManager = new SelectedRecipeManager();

        ArrayList<Ingredient> dumbIngreList = new ArrayList<>();
        dumbIngreList.add(new Ingredient("Eggs", "piece", 10));
        dumbIngreList.add(new Ingredient("Milk", "gallon", 2));

        recipeList.add(new Recipe("Hamburger", null, DEFAULT_PHOTO_URL, dumbIngreList, "DESCRIPTION GOES HERE", initDummyNutritionList()));

        dumbIngreList = new ArrayList<>();
        dumbIngreList.add(new Ingredient("EAT 2: Ingre 0", "piece", 2));
        dumbIngreList.add(new Ingredient("EAT 2: Ingre 1", "gallon", 1));
        dumbIngreList.add(new Ingredient("Eggs", "piece", 10));
        recipeList.add(new Recipe("EAT 2", null, DEFAULT_PHOTO_URL, dumbIngreList, "DESCRIPTION GOES HERE", initDummyNutritionList()));

        groceriesManager.addSelectedRecipe(recipeList.get(0));
        groceriesManager.addSelectedRecipe(recipeList.get(1));


    }

    public static String[] ingredientsToString()
    {
        String[] temp = new String[ingNameList.size()];
        for(int i = 0; i < ingNameList.size(); i++)
        {
            temp[i] = ingNameList.get(i);
        }
        return temp;
    }

    public static String[] unitToString()
    {
        String[] temp = new String[unitList.size()];
        for(int i = 0; i < unitList.size(); i++)
        {
            temp[i] = unitList.get(i);
        }

        return temp;
    }



    public static void addIngredient(String s)
    {
        boolean found = false;
        for(String str : ingNameList)
        {
            if(str.compareToIgnoreCase(s) == 0)
                found = true;
        }

        if(!found)
            ingNameList.add(new String(s));

        return;
    }

    public static void addUnit(String s)
    {
        boolean found = false;
        for(String str : unitList)
        {
            if(str.compareToIgnoreCase(s) == 0)
                found = true;
        }

        if(!found)
            unitList.add(new String(s));

        return;
    }

    public static ArrayList<Recipe> getRecipeList() {
        return recipeList;
    }

    public static Recipe getRecipeFromList(String target)
    {
        for(Recipe rec : recipeList)
        {
            if(rec.getName().compareToIgnoreCase(target) == 0)
                return rec;
        }

        return null;
    }


    public static GroceriesManager getSelectedRecipes()
    {
        return groceriesManager;
    }

    public static NutritionList initDummyNutritionList()
    {
        Random ran = new Random();
        NutritionList nutList = new NutritionList();
        for(Nutrition nut : nutList.getNutritionList())
        {
            nut.setCalo(Math.abs(ran.nextInt() % 500));
        }

        return nutList;
    }
}
