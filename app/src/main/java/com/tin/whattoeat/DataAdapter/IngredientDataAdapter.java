package com.tin.whattoeat.DataAdapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.Ingredient;
import com.tin.whattoeat.Dialogs.NewIngredientDialog;
import com.tin.whattoeat.R;

import java.util.ArrayList;

/**
 * Created by mbp on 9/23/16.
 */

public class IngredientDataAdapter extends RecyclerView.Adapter<IngredientDataAdapter.ViewHolder>
{
    public ArrayList<Ingredient> dataIngredient = new ArrayList<>();
    private boolean editable = true;
    IngredientDataAdapter ida;
    Activity activity;

    public IngredientDataAdapter(Activity activity)
    {
        ida = this;
        dataIngredient = new ArrayList<>();
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
        public View view;

        public Ingredient mItem;

        ViewHolder(View v)
        {
            super(v);
            view = v;
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
        holder.ingredientName.setText(dataIngredient.get(position).getIngName());
        holder.ingredientUnit.setText(dataIngredient.get(position).getUnit());
        holder.ingredientQuantity.setText(String.valueOf(dataIngredient.get(position).getQuantity()));

        if(editable) {
            holder.view.setOnClickListener((View view) -> {
                //System.out.println("Click on me, Testing ingredient item onClick");
                String data[] = new String[3];
                data[0] = holder.ingredientName.getText().toString();
                data[1] = holder.ingredientQuantity.getText().toString();
                data[2] = holder.ingredientUnit.getText().toString();
                NewIngredientDialog ingredientPopupWindow = new NewIngredientDialog(activity,
                        ida,
                        data, null, position);
                ingredientPopupWindow.show();
                System.out.println();
            });
        }
    }

    public void addItem(Ingredient ing)
    {
        dataIngredient.add(0, ing);
        notifyItemChanged(0);
        notifyDataSetChanged();
    }
    public void update()
    {
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return dataIngredient.size();
    }


}
