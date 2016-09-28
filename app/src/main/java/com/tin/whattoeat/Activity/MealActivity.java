package com.tin.whattoeat.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


import com.tin.whattoeat.DataAdapter.MealItemAdapter;
import com.tin.whattoeat.Dialogs.MealDialog;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.MealItem;
import com.tin.whattoeat.Model.Recipe;
import com.tin.whattoeat.R;
import com.tin.whattoeat.Model.DailyMeals;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * An activity representing a list of Recipes. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link RecipeDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class MealActivity extends AppCompatActivity
{


    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    Activity activity;
    private TextView totalMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        activity = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.meal_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Meals");

        TextView totalMeals = (TextView) findViewById(R.id.meal_total_meals);
        this.totalMeals = totalMeals;
        totalMeals.setText(GlobalData.selectedRecipeManager.getTotalSelectedMeal() + " ready to plan");

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        View recyclerView = findViewById(R.id.meal_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        ArrayList<DailyMeals> temp = new ArrayList<>();
        for(int i = 1; i < 8; i++)
        {
            temp.add(new DailyMeals(i, null, null, null));
        }
        recyclerView.setAdapter(new MealRecyclerAdapter(temp));
    }

    public class MealRecyclerAdapter
            extends RecyclerView.Adapter<MealRecyclerAdapter.ViewHolder> {

        private final ArrayList<DailyMeals> mValues;

        public MealRecyclerAdapter(ArrayList<DailyMeals>  items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.meal_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mDateName.setText(holder.mItem.name);

            if(holder.mItem.breakfastRecipe == null)
                holder.mRecipeName1.setText("Eat out");
            else
                holder.mRecipeName1.setText(holder.mItem.breakfastRecipe.getName());

            if(holder.mItem.lunchRecipe == null)
                holder.mRecipeName2.setText("Eat out");
            else
                holder.mRecipeName2.setText(holder.mItem.lunchRecipe.getName());

            if(holder.mItem.dinnerRecipe == null)
                holder.mRecipeName3.setText("Eat out");
            else
                holder.mRecipeName3.setText(holder.mItem.dinnerRecipe.getName());


            //Picasso here
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            public final View mView;
            public final TextView mDateName;
            public final TextView mRecipeName1;
            public final TextView mRecipeName2;
            public final TextView mRecipeName3;

            public DailyMeals mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mDateName = (TextView) view.findViewById(R.id.meal_date);
                mRecipeName1 = (TextView) view.findViewById(R.id.meal_1);
                mRecipeName2 = (TextView) view.findViewById(R.id.meal_2);
                mRecipeName3 = (TextView) view.findViewById(R.id.meal_3);

                mRecipeName1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MealDialog dialog = new MealDialog(activity, mRecipeName1, mItem, 1, totalMeals);
                        dialog.show();
                    }
                });


                mRecipeName2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MealDialog dialog = new MealDialog(activity, mRecipeName2, mItem, 2, totalMeals);
                        dialog.show();
                    }
                });


                mRecipeName3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MealDialog dialog = new MealDialog(activity, mRecipeName3, mItem, 3, totalMeals);
                        dialog.show();
                    }
                });
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
