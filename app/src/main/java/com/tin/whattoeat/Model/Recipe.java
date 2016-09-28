package com.tin.whattoeat.Model;

import android.net.Uri;
import java.util.ArrayList;

/**
 * Created by mbp on 9/25/16.
 */

public class Recipe
{
    private String name;
    private Uri imgURI;
    private String imgURL;
    private ArrayList<Ingredient> ingredientsList;
    private String Description;
    private NutritionList nutritionList;

    public Recipe(String name, Uri imgURI, String imgURL, ArrayList<Ingredient> ingredientsList, String description) {
        this.name = name;
        this.imgURI = imgURI;
        this.imgURL = imgURL;
        this.ingredientsList = ingredientsList;
        Description = description;
    }

    public Recipe(String name, Uri imgURI, String imgURL, ArrayList<Ingredient> ingredientsList, String description, NutritionList nutritionList) {
        this.name = name;
        this.imgURI = imgURI;
        this.imgURL = imgURL;
        this.ingredientsList = ingredientsList;
        Description = description;
        this.nutritionList = nutritionList;
    }

    public NutritionList getNutritionList() {
        return nutritionList;
    }

    public void setNutritionList(NutritionList nutritionList) {
        this.nutritionList = nutritionList;
    }

    public Recipe() {
        name = "DEFAULT VALUE";
        imgURI = null;
        imgURL = "";
        ingredientsList = new ArrayList<>();
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImgURI() {
        return imgURI;
    }

    public void setImgURI(Uri imgURI) {
        this.imgURI = imgURI;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public ArrayList<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(ArrayList<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }


}
