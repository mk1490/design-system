package ir.mtegco.design_system;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomButton extends RelativeLayout {
    public CustomButton(Context context) {
        super(context);
        init(null);
    }


    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        setBackgroundColor(getResources().getColor(R.color.red));
    }
}
