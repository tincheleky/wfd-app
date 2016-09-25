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

    static {
        ingNameList = new ArrayList<>();
        unitList = new ArrayList<>();
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

}
