package com.tin.whattoeat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tin.whattoeat.Listener.OnSwipeListener;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.Recipe;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GroceriesActivity extends AppCompatActivity
{

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);
        Toolbar toolbar = (Toolbar) findViewById(R.id.groceries_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Groceries");
        activity = this;

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.groceries_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View recyclerView = findViewById(R.id.groceries_recycler_view);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        recyclerView.setAdapter(new GroceriesRecyclerAdapter(GlobalData.getRecipeList()));
    }

    public class GroceriesRecyclerAdapter
            extends RecyclerView.Adapter<GroceriesRecyclerAdapter.ViewHolder> {

        private final ArrayList<Recipe> mValues;

        public GroceriesRecyclerAdapter(ArrayList<Recipe>  items) {
            mValues = items;
            System.out.println("------------ TESTING +++ ::: " + items.size() );
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.groceries_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            //holder.mGroceriesItemName.setText("");
            holder.mGroceriesItemQuantity.setText("###");
            holder.mGroceriesItemAdd.setVisibility(ImageView.INVISIBLE);
            holder.mGroceriesItemRemove.setVisibility(ImageView.INVISIBLE);

            //Picasso here

            holder.mView.setOnClickListener(v -> {
                //WHAT HAPPENS IF CLICKED
            });
            System.out.println("+++++++ TESTING: " + mValues.size());
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder{

            public final View mView;
            public final TextView mGroceriesItemName;
            public final TextView mGroceriesItemQuantity;
            public final ImageView mGroceriesItemAdd;
            public final ImageView mGroceriesItemRemove;


            public Recipe mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mView.setOnTouchListener(new OnSwipeListener(GroceriesActivity.this){
                    @Override
                    public void onSwipeRight(){
                        System.out.println("TESTING SWIPE RIGHT");
                    }

                    @Override
                    public void onSwipeLeft(){
                        System.out.println("TESTING SWIPE LEFT");

                    }
                });
                mGroceriesItemName = (TextView) view.findViewById(R.id.groceries_item_name);
                mGroceriesItemQuantity = (TextView) view.findViewById(R.id.groceries_item_quantity);
                mGroceriesItemAdd = (ImageView) view.findViewById(R.id.groceries_item_add);
                mGroceriesItemRemove = (ImageView) view.findViewById(R.id.groceries_item_remove);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mGroceriesItemName.getText() + "'";
            }

        }
    }

}
