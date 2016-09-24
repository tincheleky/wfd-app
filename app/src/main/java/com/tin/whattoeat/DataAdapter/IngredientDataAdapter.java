package com.tin.whattoeat.DataAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tin.whattoeat.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mbp on 9/23/16.
 */

public class IngredientDataAdapter extends RecyclerView.Adapter<IngredientDataAdapter.ViewHolder>
{
    ArrayList<String> dataIngredient = new ArrayList<>();

    public IngredientDataAdapter(ArrayList<String> data)
    {
        dataIngredient = data;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView ingredientName;
        public TextView ingredientQuantity;
        public TextView ingredientUnit;
        ViewHolder(View v)
        {
            super(v);
            ingredientName = (TextView) v.findViewById(R.id.ingredient_name);
            ingredientQuantity = (TextView) v.findViewById(R.id.ingredient_quantity);
            ingredientUnit = (TextView) v.findViewById(R.id.ingredient_unit);
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
        holder.ingredientName.setText(dataIngredient.get(position));
    }


    @Override
    public int getItemCount() {
        return dataIngredient.size();
    }
}
