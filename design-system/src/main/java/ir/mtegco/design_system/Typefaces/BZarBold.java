package ir.mtegco.design_system.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class BZarBold extends androidx.appcompat.widget.AppCompatTextView {
    public BZarBold(Context context) {
        super(context);
        init();
    }
    public BZarBold(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public BZarBold(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/b_zar_bold.ttf"));
    }
}
