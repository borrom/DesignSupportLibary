package goldenkyds.com.ifl.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import goldenkyds.com.ifl.ui.fragment.ExamFragment;
import goldenkyds.com.ifl.ui.fragment.IFLFragment;

/**
 * Created by gguser on 6/23/15.
 */
public class FragmentAdapter extends FragmentPagerAdapter{

    private List<String> mTitles;

    public FragmentAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new ExamFragment();
        }
        return new IFLFragment();
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
