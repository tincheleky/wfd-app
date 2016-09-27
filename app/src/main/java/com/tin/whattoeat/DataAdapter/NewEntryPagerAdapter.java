package com.tin.whattoeat.DataAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tin.whattoeat.FragmentEntryDescription;
import com.tin.whattoeat.FragmentEntryDetail;
import com.tin.whattoeat.NewDishActivity;

/**
 * Created by mbp on 9/24/16.
 */

public class NewEntryPagerAdapter extends FragmentStatePagerAdapter
{
    private int tabCnt = 2;
    private String mode;
    private String target;
    public NewEntryPagerAdapter(FragmentManager fm, int tabs, String mode, String target)
    {
        super(fm);
        tabCnt = tabs;
        this.mode = mode;
        this.target = target;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        Bundle bundle = new Bundle();
        switch(position) {
            case 0:
                fragment = new FragmentEntryDetail();
                bundle.putString(FragmentEntryDetail.MODE, mode);
                bundle.putString(NewDishActivity.TARGET, target);
                fragment.setArguments(bundle);
                return fragment;
            case 1:
                fragment = new FragmentEntryDescription();
                bundle.putString(FragmentEntryDescription.MODE, mode);
                bundle.putString(FragmentEntryDescription.TARGET, target);
                fragment.setArguments(bundle);
                return fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCnt;
    }
}
