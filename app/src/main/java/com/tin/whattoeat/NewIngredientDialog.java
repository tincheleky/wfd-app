package com.tin.whattoeat;

import android.app.Dialog;
import android.content.Context;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.tin.whattoeat.DataAdapter.IngredientDataAdapter;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.Ingredient;

/**
 * Created by mbp on 9/24/16.
 */

public class NewIngredientDialog extends Dialog
{
    private AutoCompleteTextView ingredientAutoCompleteTextView;
    private AutoCompleteTextView unitAutoCompleteTextView;
    private ArrayAdapter<String> ingAdapter;
    private ArrayAdapter<String> unitAdapter;
    private EditText quantityEditText;
    private ImageView postbackImageView;
    private LinearLayout layout;
    private String[] postbackData;

    private Context context;

    public NewIngredientDialog(Context context, IngredientDataAdapter ida, String[] data, String[] ingNameData, String[] unitData) {
        super(context);
        this.context = context;
        this.postbackData = data;
        setContentView(R.layout.layout_new_ingredient);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.layout_new_ingredient, null);
        ingredientAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.new_ingredient_name);
        unitAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.new_ingredient_unit);
        quantityEditText = (EditText) findViewById(R.id.new_ingredient_quantity);

        //FAKEING DATA;
//        ingNameData = new String[]{
//                "Eggs",
//                "Milk"
//        };
//
//        unitData = new String[]{
//                "lbs",
//                "gallon"
//        };
        ingNameData = GlobalData.ingredientsToString();
        unitData = GlobalData.unitToString();

        ingAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, ingNameData);
        unitAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, unitData);

        ingredientAutoCompleteTextView.setThreshold(1);
        ingredientAutoCompleteTextView.setAdapter(ingAdapter);
        unitAutoCompleteTextView.setThreshold(1);
        unitAutoCompleteTextView.setAdapter(unitAdapter);

        postbackImageView = (ImageView) findViewById(R.id.postback);
        postbackImageView.setOnClickListener((View v)->{
            System.out.println("CLICKED ON ME");
            postbackData[0] = ingredientAutoCompleteTextView.getText().toString();
            postbackData[1] = quantityEditText.getText().toString();
            postbackData[2] = unitAutoCompleteTextView.getText().toString();

            GlobalData.addIngredient(postbackData[0]);
            GlobalData.addUnit(postbackData[2]);

            if(postbackData[0].length() > 0 && postbackData[1].length() > 0 && postbackData[2].length() > 0)
                ida.addItem(new Ingredient(postbackData[0], postbackData[2], Double.valueOf(postbackData[1])));
            else
            {
                Toast.makeText(context, "Please don't leave any field blank . . .", Toast.LENGTH_SHORT);
            }

            dismiss();
        });

        if(postbackData[0] != null)
        {
            ingredientAutoCompleteTextView.setText(postbackData[0]);
        }
        if(postbackData[1] != null)
        {
            quantityEditText.setText(postbackData[1]);
        }
        if(postbackData[2] != null)
        {
            unitAutoCompleteTextView.setText(postbackData[2]);
        }

        setTitle("Ingredient");

        System.out.println("TESTING popupNewIngredient ");

    }



}
