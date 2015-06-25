package goldenkyds.com.ifl.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import goldenkyds.com.ifl.R;
import goldenkyds.com.ifl.ui.fragment.IFLExamFragment;
import goldenkyds.com.ifl.ui.fragment.IFLFragment;
import goldenkyds.com.ifl.ui.fragment.IFLHomeFragment;
import goldenkyds.com.ifl.ui.fragment.LibraryFragment;
import goldenkyds.com.ifl.ui.fragment.TOEFLFragment;


public class MainActivity extends AbsActivity{


    private Fragment mCurrentFragment;
    private DrawerLayout mDrawerLayout;
    private static final String CURRENT_FRAGMENT = "current_fragment";
    private List<IFLFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = (NavigationView)findViewById(R.id.main_nav);
        navigationView.setNavigationItemSelectedListener(OnNavigationClickListener);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.main_drawer);
        fragments = new ArrayList<>();
        fragments.add(new IFLFragment());
        fragments.add(new IFLFragment());
        fragments.add(new IFLFragment());

        if(savedInstanceState == null) {
            mCurrentFragment = IFLHomeFragment.newInstance(mDrawerLayout);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, mCurrentFragment, CURRENT_FRAGMENT)
                    .commit();
        }else{
            mCurrentFragment = getSupportFragmentManager().findFragmentByTag(CURRENT_FRAGMENT);
        }

    }

    final private NavigationView.OnNavigationItemSelectedListener OnNavigationClickListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);
                    switch (menuItem.getItemId()){
                        case R.id.ifl_home_menu:
                            mCurrentFragment = IFLHomeFragment.newInstance(mDrawerLayout);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.main_container,mCurrentFragment,CURRENT_FRAGMENT)
                                    .commit();
                            break;
                        case R.id.ifl_exam_menu:
                            mCurrentFragment = IFLExamFragment.newInstance(mDrawerLayout);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.main_container,mCurrentFragment,CURRENT_FRAGMENT)
                                    .commit();
                        break;
                        case R.id.toefl_exam_menu:
                            mCurrentFragment = TOEFLFragment.newInstance(mDrawerLayout);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.main_container,mCurrentFragment,CURRENT_FRAGMENT)
                                    .commit();
                            break;

                        case R.id.ifl_library:
                            mCurrentFragment = LibraryFragment.newInstance(mDrawerLayout);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.main_container,mCurrentFragment,CURRENT_FRAGMENT)
                                    .commit();
                            break;

                    }
                    ((DrawerLayout)findViewById(R.id.main_drawer)).closeDrawers();
                    return true;
                }
            };
}
