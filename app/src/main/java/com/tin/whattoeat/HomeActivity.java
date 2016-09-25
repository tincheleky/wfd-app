package com.tin.whattoeat;

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
        System.out.println("Hey");
        final PopupWindow popupWindow = new PopupWindow(this);
        LinearLayout popupLayout = new LinearLayout(this);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);

        popupLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                                LinearLayout.LayoutParams.MATCH_PARENT));
        popupLayout.setOrientation(LinearLayout.VERTICAL);
        popupLayout.setAlpha(0.25f);
        popupLayout.setBackgroundColor(Color.BLACK);
        popupLayout.setVisibility(LinearLayout.VISIBLE);
        popupWindow.setContentView(popupLayout);
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

        final PopupWindow popupWindow2 = new PopupWindow(this);

        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow2.setContentView(getLayoutInflater().inflate(R.layout.about_us, null));
        popupWindow2.showAtLocation(v, Gravity.CENTER, 0, 0);

        popupWindow.setTouchable(true);
        popupLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    popupWindow.dismiss();
                    popupWindow2.dismiss();
                }
                return true;
            }
        });

    }
}
