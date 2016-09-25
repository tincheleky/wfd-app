package com.tin.whattoeat;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.tin.whattoeat.DataAdapter.IngredientDataAdapter;

/**
 * Created by mbp on 9/24/16.
 */

public class NewIngredientPopupWindow extends PopupWindow
{
    private EditText ingredientNameEditText;
    private EditText unitEditText;
    private EditText quantityEditText;
    private ImageView postbackImageView;
    private LinearLayout layout;
    private String[] data;

    private Context context;

    public NewIngredientPopupWindow(Context context, IngredientDataAdapter ida, String[] data) {
        super(context);
        this.context = context;
        this.data = data;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_new_ingredient, null);
        System.out.println(view);
        ingredientNameEditText = (EditText) view.findViewById(R.id.new_ingredient_name);
        unitEditText = (EditText) view.findViewById(R.id.new_ingredient_unit);
        quantityEditText = (EditText) view.findViewById(R.id.new_ingredient_quantity);

        postbackImageView = (ImageView) view.findViewById(R.id.postback);
        postbackImageView.setOnClickListener((View v)->{
            data[0] = ingredientNameEditText.getText().toString();
            data[1] = quantityEditText.getText().toString();
            data[2] = unitEditText.getText().toString();
            ida.addItem(data[0]);
            this.dismiss();
        });
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(view);
        setFocusable(true);
        System.out.println("TESTING popupNewIngredient ");

    }



}
