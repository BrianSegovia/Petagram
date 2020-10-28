package ActivityMain;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Adaptador_ViewPager_Main_Activity extends FragmentPagerAdapter {

    private ArrayList <Fragment> fragments;

    public Adaptador_ViewPager_Main_Activity (FragmentManager fm, ArrayList <Fragment> fragments){

        super(fm);

        this.fragments = fragments;

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
