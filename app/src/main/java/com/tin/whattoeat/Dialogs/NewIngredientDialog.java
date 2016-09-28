package com.tin.whattoeat.Dialogs;

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
import com.tin.whattoeat.R;

import java.util.ArrayList;
import java.util.function.DoubleToLongFunction;

/**
 * Created by mbp on 9/24/16.
 */

public class NewIngredientDialog extends Dialog
{
    private AutoCompleteTextView ingredientAutoCompleteTextView;
    private AutoCompleteTextView unitAutoCompleteTextView;
    private ArrayAdapter<String> ingAdapter;
    private ArrayAdapter<String> unitAdapter;
    IngredientDataAdapter ida;
    private EditText quantityEditText;
    private ImageView postbackImageView;
    private LinearLayout layout;
    private String[] postbackData;

    private Context context;

    public NewIngredientDialog(Context context, IngredientDataAdapter ida, String[] data, ArrayList<Ingredient> ingredientList, int position) {
        super(context);
        this.context = context;
        this.postbackData = data;
        this.ida = ida;
        setContentView(R.layout.layout_new_ingredient);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.layout_new_ingredient, null);
        ingredientAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.new_ingredient_name);
        unitAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.new_ingredient_unit);
        quantityEditText = (EditText) findViewById(R.id.new_ingredient_quantity);

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

        Ingredient tempIngre = findIngredient(postbackData[0]);

        ingAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, GlobalData.ingredientsToString());
        unitAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, GlobalData.unitToString());

        ingredientAutoCompleteTextView.setThreshold(1);
        ingredientAutoCompleteTextView.setAdapter(ingAdapter);
        unitAutoCompleteTextView.setThreshold(1);
        unitAutoCompleteTextView.setAdapter(unitAdapter);

        postbackImageView = (ImageView) findViewById(R.id.postback);
        postbackImageView.setOnClickListener((View v)->{
            postbackData[0] = ingredientAutoCompleteTextView.getText().toString();
            postbackData[1] = quantityEditText.getText().toString();
            postbackData[2] = unitAutoCompleteTextView.getText().toString();

            if(postbackData[0] != null && postbackData[1] != null && postbackData[2]!= null)
            {
                System.out.println("STEP 0");
                if (postbackData[0].length() > 0 && postbackData[1].length() > 0 && postbackData[2].length() > 0) {
                    System.out.println("STEIP 0.5");
                    if(ingredientList != null || data[0] != null && data[0].length() > 0) {
                        System.out.println("STEP 1");
                        if(ingredientList == null)
                        {
                            System.out.println("STEP 1 A");
                            if(position >= 0) {
                                System.out.println("STEP 1 A A");
                                Ingredient rec = ida.dataIngredient.get(position);
                                rec.setIngName(postbackData[0]);
                                rec.setQuantity(Double.valueOf(postbackData[1]));
                                rec.setUnit(postbackData[2]);
                                ida.update();
                            }
                        }
                        else {
                            System.out.println("STEP 2 ");
                            if(tempIngre != null) {
                                System.out.println("STEP 2 A ");
                                tempIngre.setIngName(postbackData[0]);
                                tempIngre.setQuantity(Double.valueOf(postbackData[1]));
                                tempIngre.setUnit(postbackData[2]);
                                ida.update();
                            }
                            else{
                                System.out.println("STEP 2 B");
                                Ingredient holder = new Ingredient(postbackData[0], postbackData[2], Double.valueOf(data[1]));
                                ingredientList.add(holder);
                                ida.update();
                                GlobalData.addIngredient(postbackData[0]);
                                GlobalData.addUnit(postbackData[2]);
                            }
                        }
                    }

                }
            }
            else
            {
                Toast.makeText(context, "Please don't leave any field blank . . .", Toast.LENGTH_SHORT);
            }

            dismiss();
        });

        setTitle("Ingredient");

    }

    private Ingredient findIngredient(String ingredient) {
        if(ingredient == null || ingredient.length() < 1)
            return null;
        for (Ingredient ing : ida.dataIngredient) {
            if (ing.getIngName().compareToIgnoreCase(ingredient) == 0) {
                return ing;
            }
        }

        return null;
    }


}
