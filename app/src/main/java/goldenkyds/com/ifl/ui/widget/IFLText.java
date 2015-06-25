package goldenkyds.com.ifl.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import goldenkyds.com.ifl.R;

/**
 * Created by gguser on 6/19/15.
 */
public class IFLText extends TextView{
    private Context mContext;

    public IFLText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public IFLText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IFLText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.ifl_slide_bottom));
    }
}
