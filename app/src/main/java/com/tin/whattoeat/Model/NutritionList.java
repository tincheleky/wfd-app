package com.tin.whattoeat.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mbp on 9/27/16.
 */

public class NutritionList
{
    public ArrayList<Nutrition> nutritionList;

    public NutritionList() {
        nutritionList = new ArrayList<>();
        nutritionList.add(new Nutrition("Calorie", 0, "calo"));
        nutritionList.add(new Nutrition("Carbohydrates", 0, "g"));
        nutritionList.add(new Nutrition("Minerals", 0, "g"));
        nutritionList.add(new Nutrition("Vitamin A", 0, "mg"));
        nutritionList.add(new Nutrition("Vitamin B", 0, "mg"));
        nutritionList.add(new Nutrition("Vitamin C", 0, "mg"));
        nutritionList.add(new Nutrition("Vitamin D", 0, "mg"));
        nutritionList.add(new Nutrition("Sugar", 0, "g"));
    }

    public NutritionList(ArrayList<Nutrition> nutritionList) {
        this.nutritionList = nutritionList;
    }

    public ArrayList<Nutrition> getNutritionList() {
        return nutritionList;
    }

    public void setNutritionList(ArrayList<Nutrition> nutritionList) {
        this.nutritionList = nutritionList;
    }
}
