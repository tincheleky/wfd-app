package com.tin.whattoeat.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mbp on 9/25/16.
 */

public class GlobalData
{
    private static ArrayList<String> ingNameList;
    private static ArrayList<String> unitList;
    private static ArrayList<Recipe> recipeList;

    static {
        ingNameList = new ArrayList<>();
        unitList = new ArrayList<>();
        recipeList = new ArrayList<>();

        ArrayList<Ingredient> dumbIngreList = new ArrayList<>();
        dumbIngreList.add(new Ingredient("Eggs", "piece", 10));
        dumbIngreList.add(new Ingredient("Milk", "gallon", 2));

        recipeList.add(new Recipe("Hamburger", null, "", dumbIngreList));

        dumbIngreList = new ArrayList<>();
        dumbIngreList.add(new Ingredient("EAT 2: Ingre 0", "piece", 2));
        dumbIngreList.add(new Ingredient("EAT 2: Ingre 1", "gallon", 1));
        recipeList.add(new Recipe("EAT 2", null, "", dumbIngreList));

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

}
