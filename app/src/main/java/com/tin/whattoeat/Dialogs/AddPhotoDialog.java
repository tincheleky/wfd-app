package com.tin.whattoeat.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.tin.whattoeat.DataAdapter.IngredientDataAdapter;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.Ingredient;
import com.tin.whattoeat.R;

import java.net.URL;

import static android.provider.CalendarContract.CalendarCache.URI;

/**
 * Created by mbp on 9/24/16.
 */

public class AddPhotoDialog extends Dialog
{

    private Context context;

    public AddPhotoDialog(Context context, String[] url, ImageView imageView) {
        super(context);
        this.context = context;
        setContentView(R.layout.dialog_adding_photo);

        EditText urlTextView = (EditText) findViewById(R.id.dialog_add_photo_url);
        TextView saveBtn = (TextView) findViewById(R.id.dialog_add_photo_button);

        saveBtn.setOnClickListener(v->{
            url[0] = urlTextView.getText().toString();
            if(url[0].length() > 1 ) {

                Picasso.with(context)
                        .load(url[0])
                        .resize(imageView.getWidth(), imageView.getWidth())
                        .centerCrop()
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {
                            }

                            @Override
                            public void onError() {
                                Picasso.with(context)
                                        .load(GlobalData.DEFAULT_PHOTO_URL)
                                        .resize(imageView.getWidth(), imageView.getWidth())
                                        .centerCrop()
                                        .into(imageView);
                                url[0] = GlobalData.DEFAULT_PHOTO_URL;
                            }
                        });

            }

            dismiss();

        });
        setTitle("Add photo");
    }





}
