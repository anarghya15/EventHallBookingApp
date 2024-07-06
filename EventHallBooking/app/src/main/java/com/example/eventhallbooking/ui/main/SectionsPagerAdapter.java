package com.example.eventhallbooking.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.eventhallbooking.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,
            R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        int[] images;
        String[] names;
        switch (position) {
            case 0:
                images = new int[]{R.drawable.prw1, R.drawable.prw2, R.drawable.prw3, R.drawable.prw4
                        , R.drawable.prw5, R.drawable.prw6};
                names = mContext.getResources().getStringArray(R.array.wedding_halls);
                fragment = new HallViewActivity(images,names);
                break;
            case 1:
                images = new int[]{R.drawable.prs2, R.drawable.prs3, R.drawable.prs4,
                        R.drawable.prs5, R.drawable.prs6, R.drawable.prs7};
                names = mContext.getResources().getStringArray(R.array.seminar_halls);
                fragment = new HallViewActivity(images,names);
                break;
            case 2:
                images = new int[]{R.drawable.pr1, R.drawable.pr2, R.drawable.pr3,
                        R.drawable.pr4, R.drawable.pr5, R.drawable.pr6};
                names = mContext.getResources().getStringArray(R.array.auditoriums);
                fragment = new HallViewActivity(images,names);
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}