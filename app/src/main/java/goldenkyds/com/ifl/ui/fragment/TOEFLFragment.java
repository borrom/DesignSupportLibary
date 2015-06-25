package goldenkyds.com.ifl.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
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
public class TOEFLFragment extends AbsFragment{

    public static DrawerLayout drawerLayout;

    public static TOEFLFragment newInstance(DrawerLayout layout){
        drawerLayout = layout;
        TOEFLFragment fragment = new TOEFLFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.toefl_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("TOEFL Exam");
        ViewPager pager = (ViewPager)view.findViewById(R.id.ifl_pager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.ifl_tab);
        List<String> titles = new ArrayList<>();
        titles.add("Grammar");
        titles.add("Reading");
        titles.add("Listening");
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager(), titles);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    @Override
    DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }
}
