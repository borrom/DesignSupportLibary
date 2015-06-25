package goldenkyds.com.ifl.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;

import goldenkyds.com.ifl.R;

/**
 * Created by gguser on 6/23/15.
 */
public abstract class AbsFragment extends Fragment{

    abstract DrawerLayout getDrawerLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar)view.findViewById(R.id.main_toolbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(),
                getDrawerLayout(),toolbar,R.string.drawer_open,R.string.drawer_close);

        getDrawerLayout().setDrawerListener(toggle);
        getDrawerLayout().post(new Runnable() {
            @Override
            public void run() {
                toggle.syncState();
            }
        });
    }
}
