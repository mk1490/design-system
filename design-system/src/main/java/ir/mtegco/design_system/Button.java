package ir.mtegco.design_system;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import io.github.florent37.shapeofview.shapes.RoundRectView;

public class Button extends RelativeLayout {
    OnClickListener onClickListener;
    TextView title;
    MaterialRippleLayout materialRippleLayout;
    RoundRectView roundRectView;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Button(Context context) {
        super(context);
        init(null);
    }


    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.designsystem_button, null);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Button);
        setupViews(view);
        if (typedArray.hasValue(R.styleable.Button_android_text)) {
            title.setText(typedArray.getString(R.styleable.Button_android_text));
        }
        setBackgroundColor(Color.parseColor("#43A047"));
        setCorner(typedArray.getInt(R.styleable.Button_android_text, 10));
        materialRippleLayout.setBackgroundColor(typedArray.getColor(R.styleable.Button_backgroundColor, Color.parseColor("#f44344")));
        materialRippleLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    private void setupViews(View view) {
        title = (TextView) view.findViewById(R.id.title);
        materialRippleLayout = view.findViewById(R.id.rippleLayout);
        roundRectView = view.findViewById(R.id.roundRectView);
    }

    public void setCorner(int radius) {
        roundRectView.setBottomLeftRadius(radius);
        roundRectView.setBottomRightRadius(radius);
        roundRectView.setTopLeftRadius(radius);
        roundRectView.setTopRightRadius(radius);
    }

}
