package com.tin.whattoeat;

import android.app.Activity;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.Recipe;
import com.tin.whattoeat.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of Recipes. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link RecipeDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class RecipeListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        activity = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.recipe_list_toobar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        View recyclerView = findViewById(R.id.recipe_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.recipe_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new RecipeRecyclerAdapter(GlobalData.getRecipeList()));
    }

    public class RecipeRecyclerAdapter
            extends RecyclerView.Adapter<RecipeRecyclerAdapter.ViewHolder> {

        private final ArrayList<Recipe> mValues;

        public RecipeRecyclerAdapter(ArrayList<Recipe>  items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recipe_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mRecipeName.setText(mValues.get(position).getName());
            holder.mRecipeNutrition.setText("Nutrition\nInfo");

            holder.mView.setOnClickListener(v -> {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(RecipeDetailFragment.ARG_ITEM_ID, holder.mItem.getName());
                    RecipeDetailFragment fragment = new RecipeDetailFragment();
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.recipe_detail_container, fragment)
                            .commit();
                } else {
                    GlobalData.selectedRecipeManager.addSelectedRecipe(holder.mItem);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder{

            public final View mView;
            public final TextView mRecipeName;
            public final ImageView mRecipePhoto;
            public final TextView mRecipeNutrition;

            public Recipe mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Intent intent = new Intent(activity, NewDishActivity.class);
                        intent.putExtra(NewDishActivity.TARGET, mItem.getName());
                        startActivity(intent);
                        System.out.println("LONG PRESSED ON ITEM CONSUMED: " + mItem.getName());
                        return true;                    }
                });

                mRecipeName = (TextView) view.findViewById(R.id.recipe_name);
                mRecipeNutrition = (TextView) view.findViewById(R.id.recipe_nutrition);
                mRecipePhoto = (ImageView) view.findViewById(R.id.recipe_photo);


            }

            @Override
            public String toString() {
                return super.toString() + " '" + mRecipeName.getText() + "'";
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
