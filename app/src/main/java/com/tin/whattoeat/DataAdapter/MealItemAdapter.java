package com.tin.whattoeat.DataAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tin.whattoeat.Model.MealItem;
import com.tin.whattoeat.R;

import java.util.ArrayList;

/**
 * Created by mbp on 9/26/16.
 */

public class MealItemAdapter extends ArrayAdapter<MealItem>
{
    public MealItemAdapter(Context context, ArrayList<MealItem> meals) {
        super(context, 0, meals);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MealItem item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_list_item_content, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.list_item_content_name);
        TextView quan = (TextView) convertView.findViewById(R.id.list_item_content_quantity);

        name.setText(item.getRecipe().getName());
        quan.setText(item.getQuantity());

        return convertView;
    }
}
