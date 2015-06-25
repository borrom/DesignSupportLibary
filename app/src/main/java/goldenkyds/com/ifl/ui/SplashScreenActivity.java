package goldenkyds.com.ifl.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.animation.AnimationUtils;

import goldenkyds.com.ifl.R;

/**
 * Created by gguser on 6/19/15.
 */
public class SplashScreenActivity extends AbsActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        findViewById(R.id.ifl_pre_id)
        .startAnimation(AnimationUtils.loadAnimation(this,R.anim.ifl_slide_up));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            }
        },1700);
    }
}
