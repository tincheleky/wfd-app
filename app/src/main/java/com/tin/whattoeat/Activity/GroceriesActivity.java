package com.tin.whattoeat.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tin.whattoeat.Listener.OnSwipeListener;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.GroceriesManager;
import com.tin.whattoeat.Model.GroceryItem;
import com.tin.whattoeat.R;

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

        recyclerView.setAdapter(new GroceriesRecyclerAdapter(GlobalData.getSelectedRecipes()));
    }

    public class GroceriesRecyclerAdapter
            extends RecyclerView.Adapter<GroceriesRecyclerAdapter.ViewHolder> {

        private final GroceriesManager groceriesManager;

        public GroceriesRecyclerAdapter(GroceriesManager groceriesManager) {
            this.groceriesManager = groceriesManager;
            System.out.println("------------ TESTING +++ ::: " + groceriesManager.getItemsCount() );
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.groceries_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = groceriesManager.at(position);
            holder.mGroceriesItemName.setText(holder.mItem.getIngredient().getIngName());
            holder.mGroceriesItemQuantity.setText(String.valueOf(holder.mItem.getQuantity()));
            holder.mGroceriesItemAdd.setVisibility(ImageView.INVISIBLE);
            holder.mGroceriesItemAdd.setEnabled(false);
            holder.mGroceriesItemRemove.setVisibility(ImageView.INVISIBLE);
            holder.mGroceriesItemRemove.setEnabled(false);

            if(Integer.valueOf(holder.mGroceriesItemQuantity.getText().toString()) == 0){
                holder.mGroceriesItemName.setPaintFlags(holder.mGroceriesItemName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
            holder.mView.setOnClickListener(v -> {
                //WHAT HAPPENS IF CLICKED
            });
            System.out.println("+++++++ TESTING: " + groceriesManager.getItemsCount());
        }

        @Override
        public int getItemCount() {
            return groceriesManager.getItemsCount();
        }


        public class ViewHolder extends RecyclerView.ViewHolder{

            public final View mView;
            public final TextView mGroceriesItemName;
            public final TextView mGroceriesItemQuantity;
            public final ImageView mGroceriesItemAdd;
            public final ImageView mGroceriesItemRemove;


            public GroceryItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mView.setOnTouchListener(new OnSwipeListener(GroceriesActivity.this){
                    @Override
                    public void onSwipeRight(){
                        System.out.println("TESTING SWIPE RIGHT");
                        mGroceriesItemAdd.setVisibility(ImageView.INVISIBLE);
                        mGroceriesItemAdd.setEnabled(false);
                        mGroceriesItemRemove.setVisibility(ImageView.INVISIBLE);
                        mGroceriesItemRemove.setEnabled(false);
                    }

                    @Override
                    public void onSwipeLeft(){
                        System.out.println("TESTING SWIPE LEFT");
                        mGroceriesItemAdd.setVisibility(ImageView.VISIBLE);
                        mGroceriesItemAdd.setEnabled(true);
                        mGroceriesItemRemove.setVisibility(ImageView.VISIBLE);
                        mGroceriesItemRemove.setEnabled(true);

                    }
                });
                mGroceriesItemName = (TextView) view.findViewById(R.id.groceries_item_name);
                mGroceriesItemQuantity = (TextView) view.findViewById(R.id.groceries_item_quantity);
                mGroceriesItemAdd = (ImageView) view.findViewById(R.id.groceries_item_add);
                mGroceriesItemRemove = (ImageView) view.findViewById(R.id.groceries_item_remove);

                mGroceriesItemAdd.setOnClickListener(v->{
                    mItem.increaseQuantity();
                    mGroceriesItemQuantity.setText(String.valueOf(mItem.getQuantity()));
                    if(mItem.getQuantity() > 0)
                    {
                        mGroceriesItemName.setPaintFlags(0);
                    }
                });

                mGroceriesItemRemove.setOnClickListener(v->{
                    mItem.decreaseQuantity();
                    mGroceriesItemQuantity.setText(String.valueOf(mItem.getQuantity()));
                    if(mItem.getQuantity() == 0)
                    {
                        mGroceriesItemName.setPaintFlags(mGroceriesItemName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                });

            }

            @Override
            public String toString() {
                return super.toString() + " '" + mGroceriesItemName.getText() + "'";
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, HomeActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
