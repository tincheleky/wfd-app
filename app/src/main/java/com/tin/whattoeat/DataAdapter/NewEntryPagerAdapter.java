package com.tin.whattoeat.DataAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tin.whattoeat.FragmentEntryDescription;
import com.tin.whattoeat.FragmentEntryDetail;

/**
 * Created by mbp on 9/24/16.
 */

public class NewEntryPagerAdapter extends FragmentStatePagerAdapter
{
    private int tabCnt = 2;
    public NewEntryPagerAdapter(FragmentManager fm, int tabs)
    {
        super(fm);
        tabCnt = tabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new FragmentEntryDetail();
            case 1:
                return new FragmentEntryDescription();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCnt;
    }
}
