package ir.mtegco.design_system.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class BTraffic extends androidx.appcompat.widget.AppCompatTextView {
    public BTraffic(Context context) {
        super(context);
        init();
    }
    public BTraffic(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public BTraffic(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/b_traffic.ttf"));
    }
}
