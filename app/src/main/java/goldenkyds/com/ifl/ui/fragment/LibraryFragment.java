package goldenkyds.com.ifl.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import goldenkyds.com.ifl.R;

/**
 * Created by gguser on 6/19/15.
 */
public class LibraryFragment extends AbsFragment{

    public static DrawerLayout drawerLayout;
    public static LibraryFragment newInstance(DrawerLayout layout) {
        LibraryFragment fragment = new LibraryFragment();
        drawerLayout = layout;
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.library_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CollapsingToolbarLayout)view.findViewById(R.id.ifl_exam_collapsing_toolbar))
        .setTitle("Library");
    }

    @Override
    DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }
}
