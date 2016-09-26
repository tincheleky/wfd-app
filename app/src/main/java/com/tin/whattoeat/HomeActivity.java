package com.tin.whattoeat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.tin.whattoeat.Model.GlobalData;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);


    }

    public void startNewDishActivity(View v)
    {
        Intent intent = new Intent(this, NewDishActivity.class);
        startActivity(intent);
    }
    public void displayAboutUs(View v)
    {
        Dialog aboutUsDialog = new Dialog(this);
        aboutUsDialog.setTitle("About Me");
        aboutUsDialog.setContentView(R.layout.about_us);
        aboutUsDialog.show();

    }

    public void startRecipeActivity(View v)
    {
        Intent intent = new Intent(this, RecipeListActivity.class);
        intent.putExtra(NewDishActivity.TARGET, "");
        startActivity(intent);

    }

    public void startGroceriesActivity(View v)
    {
        Intent intent = new Intent(this, GroceriesActivity.class);
        startActivity(intent);
    }
}
