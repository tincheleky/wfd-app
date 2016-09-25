package com.tin.whattoeat.Model;

import java.util.ArrayList;

/**
 * Created by mbp on 9/25/16.
 */

public class Ingredient
{
    private String ingName;
    private String unit;
    private double quantity;
    private Nutrition nutrition;

    public Ingredient() {
        ingName = "";
        unit = "";
        quantity = 0.0;
    }

    public Ingredient(String ingName, String unit, double quantity) {
        this.ingName = ingName;
        this.unit = unit;
        this.quantity = quantity;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }
}
