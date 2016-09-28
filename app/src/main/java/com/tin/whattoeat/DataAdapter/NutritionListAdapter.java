package com.tin.whattoeat.DataAdapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tin.whattoeat.Model.DailyMeals;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.MealItem;
import com.tin.whattoeat.Model.Nutrition;
import com.tin.whattoeat.Model.NutritionList;
import com.tin.whattoeat.Model.Recipe;
import com.tin.whattoeat.R;

import java.util.ArrayList;

/**
 * Created by mbp on 9/26/16.
 */

public class NutritionListAdapter extends ArrayAdapter<Nutrition>
{
    private NutritionList nutritionList;

    public NutritionListAdapter(Context context, int resID, Recipe recipe) {
        super(context, resID, recipe.getNutritionList().nutritionList);
        nutritionList = recipe.getNutritionList();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Nutrition item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_nutrition_list_item_content, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.nutrition_list_item_name);
        TextView quan = (TextView) convertView.findViewById(R.id.nutrition_list_item_value);
        TextView unit = (TextView) convertView.findViewById(R.id.nutrition_list_item_unit);


        name.setText(item.getName());
        quan.setText(String.valueOf(item.getCalo()));
        unit.setText(item.getUnit());
        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}
