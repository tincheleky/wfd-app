package com.tin.whattoeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.tin.whattoeat.DataAdapter.IngredientDataAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewDishActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter dataAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish);

        Intent intent = getIntent();

        recyclerView = (RecyclerView)findViewById(R.id.ingredients_add_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<String> dumbData = new ArrayList<>();
        int i = 10;
        while(i > 0)
        {
            dumbData.add(new String("Item " + i));
            i--;
        }
        dataAdapter = new IngredientDataAdapter(dumbData);
        recyclerView.setAdapter(dataAdapter);


    }
}
