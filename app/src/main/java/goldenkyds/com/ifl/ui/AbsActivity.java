package goldenkyds.com.ifl.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import goldenkyds.com.ifl.R;

/**
 * Created by gguser on 6/19/15.
 */
public class AbsActivity extends AppCompatActivity{


    @Override
    public void startActivity(Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        super.startActivity(intent);
        overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);
    }
}
