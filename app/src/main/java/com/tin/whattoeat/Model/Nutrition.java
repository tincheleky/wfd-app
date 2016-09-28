package com.tin.whattoeat.Model;

/**
 * Created by mbp on 9/25/16.
 */

public class Nutrition
{
    public String name;
    public int calo;
    public String unit;

    public Nutrition(String name, int calo, String unit) {
        this.name = name;
        this.calo = calo;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalo() {
        return calo;
    }

    public void setCalo(int calo) {
        this.calo = calo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
