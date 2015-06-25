package goldenkyds.com.ifl.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import goldenkyds.com.ifl.R;
import goldenkyds.com.ifl.ui.adapter.FragmentAdapter;

/**
 * Created by gguser on 6/19/15.
 */
public class IFLHomeFragment extends AbsFragment{

    public static DrawerLayout drawerLayout;

    public static IFLHomeFragment newInstance(DrawerLayout layout){
        drawerLayout = layout;
        IFLHomeFragment fragment = new IFLHomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ifl_home_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager pager = (ViewPager)view.findViewById(R.id.ifl_pager);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.ifl_tab);
        List<String> titles = new ArrayList<>();
        titles.add("IFL");
        titles.add("IFL Event");
        titles.add("Location");
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        FragmentAdapter adapter =
                new FragmentAdapter(getChildFragmentManager(), titles);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }
}
