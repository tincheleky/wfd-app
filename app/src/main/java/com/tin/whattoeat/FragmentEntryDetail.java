package com.tin.whattoeat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tin.whattoeat.DataAdapter.IngredientDataAdapter;
import com.tin.whattoeat.Model.GlobalData;
import com.tin.whattoeat.Model.Ingredient;
import com.tin.whattoeat.Model.Recipe;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentEntryDetail.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentEntryDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEntryDetail extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final String MODE = "";
    public static final String RECIPE_TARGET = "";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter dataAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Recipe recipe;
    private ArrayList<Ingredient> ingredientsList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentEntryDetail() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEntryDetail.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEntryDetail newInstance(String param1, String param2) {
        FragmentEntryDetail fragment = new FragmentEntryDetail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getActivity(), "Get it?  " + requestCode + " - " + resultCode, Toast.LENGTH_SHORT).show();

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                InputStream image_stream = getActivity().getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(image_stream );
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) getActivity().findViewById(R.id.image_entry);
                imageView.setImageBitmap(bitmap);

                Picasso.with(getActivity())
                        .load(uri)
                        .resize(imageView.getWidth(), imageView.getWidth())
                        .centerCrop()
                        .into(imageView);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view;
        String targetData = getArguments().getString(NewDishActivity.TARGET);
        if(targetData != null)
            recipe = GlobalData.getRecipeFromList(targetData);

        String mode = getArguments().getString(MODE);
        if(mode.compareToIgnoreCase("EDIT_MODE") == 0)
        {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
            // Inflate the layout for this fragment
            view = inflater.inflate(R.layout.fragment_fragment_entry_detail, container, false);

            EditText recipeName = (EditText) view.findViewById(R.id.new_dish_name);
            if(recipe != null)
                recipeName.setText(recipe.getName());

            recyclerView = (RecyclerView) view.findViewById(R.id.ingredients_add_list);
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);

            if(recipe != null)
                dataAdapter = new IngredientDataAdapter(recipe.getIngredientsList());
            else
                dataAdapter = new IngredientDataAdapter();

            recyclerView.setAdapter(dataAdapter);

            FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_add_picture);
            fab.setOnClickListener((View v) -> {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Pick a photo"), 1);
                //Toast.makeText(getActivity(), "Hey, click me yeah ?", Toast.LENGTH_SHORT).show();
            });

            String[] data = new String[3];
            TextView imageView = (TextView) view.findViewById(R.id.btn_add_new_ingredient);
            imageView.setOnClickListener((View v) -> {
                NewIngredientDialog ingredientPopupWindow = new NewIngredientDialog(getContext(),
                        (IngredientDataAdapter) dataAdapter,
                        data,
                        GlobalData.ingredientsToString(),
                        GlobalData.unitToString());
                ingredientPopupWindow.show();
            });
        }

        else{
            view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);

            recyclerView = (RecyclerView) view.findViewById(R.id.recipe_detail_recycler_view);
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);

            dataAdapter = new IngredientDataAdapter(recipe.getIngredientsList());

            recyclerView.setAdapter(dataAdapter);
//            TextView recipeName = (TextView) view.findViewById(R.id.recipe_detail_name);
//            recipeName.setText(mode);
            //Picasso here for imageview
        }

        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context, "Detail Fragment", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
