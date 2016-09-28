package com.tin.whattoeat.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.widget.ListView;

import com.tin.whattoeat.DataAdapter.MealItemAdapter;
import com.tin.whattoeat.DataAdapter.NutritionListAdapter;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.NutritionList;
import com.tin.whattoeat.Model.Recipe;
import com.tin.whattoeat.R;

/**
 * Created by mbp on 9/27/16.
 */

public class NutritionDialog extends Dialog {

    public NutritionDialog(Context context, Recipe recipe) {
        super(context);
        setContentView(R.layout.dialog_nutrition);
        NutritionListAdapter adapter = new NutritionListAdapter(context, R.layout.dialog_nutrition_list_item_content, recipe);
        ListView listView = (ListView) findViewById(R.id.dialog_list_view_nutrition);
        listView.setAdapter(adapter);
        setTitle("Nutrition facts");
        show();
    }
}
