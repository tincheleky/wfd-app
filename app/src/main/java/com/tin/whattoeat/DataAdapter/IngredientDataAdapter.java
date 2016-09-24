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
        public EditText ingredientEditText;
        public ImageView ingredientImageView;
        ViewHolder(View v)
        {
            super(v);
            ingredientEditText = (EditText) v.findViewById(R.id.option1);
            ingredientImageView = (ImageView) v.findViewById(R.id.option2);
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
        holder.ingredientEditText.setText(dataIngredient.get(position));
    }


    @Override
    public int getItemCount() {
        return dataIngredient.size();
    }
}
