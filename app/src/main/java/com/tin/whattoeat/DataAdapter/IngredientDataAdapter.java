package com.tin.whattoeat.DataAdapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.Ingredient;
import com.tin.whattoeat.NewDishActivity;
import com.tin.whattoeat.NewIngredientDialog;
import com.tin.whattoeat.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mbp on 9/23/16.
 */

public class IngredientDataAdapter extends RecyclerView.Adapter<IngredientDataAdapter.ViewHolder>
{
    ArrayList<Ingredient> dataIngredient = new ArrayList<>();
    private boolean editable = true;
    IngredientDataAdapter ida;
    Activity activity;

    public IngredientDataAdapter(Activity activity)
    {
        ida = this; dataIngredient = new ArrayList<>();
        this.activity = activity;
    }

    public IngredientDataAdapter(Activity activity, ArrayList<Ingredient> data, boolean editable)
    {
        dataIngredient = data;
        ida = this;
        this.activity = activity;
        this.editable = editable;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView ingredientName;
        public TextView ingredientQuantity;
        public TextView ingredientUnit;

        public Ingredient mItem;

        ViewHolder(View v)
        {
            super(v);

            ingredientName = (TextView) v.findViewById(R.id.ingredient_name);
            ingredientQuantity = (TextView) v.findViewById(R.id.ingredient_quantity);
            ingredientUnit = (TextView) v.findViewById(R.id.ingredient_unit);
            if(editable) {
                v.setOnClickListener((View view) -> {
                    System.out.println("Click on me, Testing ingredient item onClick");
                    String data[] = new String[3];
                    data[0] = ingredientName.getText().toString();
                    data[1] = ingredientQuantity.getText().toString();
                    data[2] = ingredientUnit.getText().toString();
                    NewIngredientDialog ingredientPopupWindow = new NewIngredientDialog(activity,
                            ida,
                            data,
                            GlobalData.ingredientsToString(),
                            GlobalData.unitToString());
                    ingredientPopupWindow.show();
                    System.out.println();
                });
            }
        }
    }


    @Override
    public IngredientDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entry_new_ingredient, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ingredientName.setText(dataIngredient.get(position).getIngName());
        holder.ingredientUnit.setText(dataIngredient.get(position).getUnit());
        holder.ingredientQuantity.setText(String.valueOf(dataIngredient.get(position).getQuantity()));
    }

    public void addItem(Ingredient ing)
    {
        dataIngredient.add(0, ing);
        notifyItemChanged(0);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return dataIngredient.size();
    }


}
