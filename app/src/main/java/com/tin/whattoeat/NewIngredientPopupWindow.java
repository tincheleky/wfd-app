package com.tin.whattoeat;

import android.app.Dialog;
import android.content.Context;
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

import com.tin.whattoeat.DataAdapter.IngredientDataAdapter;

/**
 * Created by mbp on 9/24/16.
 */

public class NewIngredientPopupWindow extends Dialog
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

    public NewIngredientPopupWindow(Context context, IngredientDataAdapter ida, String[] data, String[] ingNameData, String[] unitData) {
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
        ingNameData = new String[]{
                "Eggs",
                "Milk"
        };

        unitData = new String[]{
                "lbs",
                "gallon"
        };

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
            ida.addItem(data[0]);
            dismiss();
        });

        System.out.println("TESTING popupNewIngredient ");

    }



}
