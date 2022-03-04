package ir.mtegco.design_system.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class BYekan extends androidx.appcompat.widget.AppCompatTextView {
    public BYekan(Context context) {
        super(context);
        init();
    }
    public BYekan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public BYekan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/b_yekan.ttf"));
    }
}
