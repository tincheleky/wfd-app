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
import com.tin.whattoeat.R;

import java.util.ArrayList;

/**
 * Created by mbp on 9/26/16.
 */

public class MealItemAdapter extends ArrayAdapter<MealItem>
{
    private TextView postbackTextView;
    private Dialog dialog;
    private DailyMeals dailyMeals;
    private int mealType;
    private TextView totalMealsTextView;
    public MealItemAdapter(Context context, int resID, TextView postbackTextView, DailyMeals item, Dialog dialog, int mealType, TextView totalMeals) {
        super(context, resID, GlobalData.selectedRecipeManager.selectedMeals);
        this.postbackTextView = postbackTextView;
        this.dialog = dialog;
        this.dailyMeals = item;
        this.mealType = mealType;
        totalMealsTextView = totalMeals;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MealItem item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_list_item_content, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.list_item_content_name);
        TextView quan = (TextView) convertView.findViewById(R.id.list_item_content_quantity);

        name.setText(item.getRecipe().getName());
        quan.setText(String.valueOf(item.getQuantity()));

        convertView.setOnClickListener(v->{
            if(postbackTextView != null) {
                postbackTextView.setText(name.getText().toString());
                if(mealType == 1)
                    dailyMeals.breakfastRecipe = GlobalData.selectedRecipeManager.at(position).getRecipe();
                if(mealType == 2)
                    dailyMeals.lunchRecipe = GlobalData.selectedRecipeManager.at(position).getRecipe();
                if(mealType == 3)
                    dailyMeals.dinnerRecipe = GlobalData.selectedRecipeManager.at(position).getRecipe();

                GlobalData.selectedRecipeManager.at(position).decreaseQuantity();
                totalMealsTextView.setText(GlobalData.selectedRecipeManager.getTotalSelectedMeal() + " ready to plan");
                if(GlobalData.selectedRecipeManager.at(position).getQuantity() == 0)
                {
                    GlobalData.selectedRecipeManager.selectedMeals.remove(GlobalData.selectedRecipeManager.at(position));
                }
            }
            if(dialog != null)
                dialog.dismiss();
        });
        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}
