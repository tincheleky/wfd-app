package com.tin.whattoeat.Model;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by mbp on 9/25/16.
 */

public class Recipe
{
    private String name;
    private URI imgURI;
    private String imgURL;
    private ArrayList<Ingredient> ingredientsList;

    public Recipe(String name, URI imgURI, String imgURL, ArrayList<Ingredient> ingredientsList) {
        this.name = name;
        this.imgURI = imgURI;
        this.imgURL = imgURL;
        this.ingredientsList = ingredientsList;
    }

    public Recipe() {
        name = "DEFAULT VALUE";
        imgURI = null;
        imgURL = "";
        ingredientsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getImgURI() {
        return imgURI;
    }

    public void setImgURI(URI imgURI) {
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
