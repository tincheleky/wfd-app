package com.tin.whattoeat.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.tin.whattoeat.DataAdapter.MealItemAdapter;
import com.tin.whattoeat.Model.DailyMeals;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.R;

import java.util.List;

/**
 * Created by mbp on 9/27/16.
 */

public class MealDialog extends Dialog
{
    private Context context;
    private MealItemAdapter adapter;

    public MealDialog(Context context, TextView postbackTextView, DailyMeals dailyMeals, int mealType, TextView totalMeals) {
        super(context);
        this.context = context;
        setContentView(R.layout.dialog_meal_selection);
        adapter = new MealItemAdapter(context, R.layout.dialog_list_item_content, postbackTextView, dailyMeals, this, mealType, totalMeals);
        ListView listView = (ListView) findViewById(R.id.dialog_list_view);
        listView.setAdapter(adapter);
        setTitle(GlobalData.selectedRecipeManager.getTotalSelectedMeal() + " selected meals");

    }
}
