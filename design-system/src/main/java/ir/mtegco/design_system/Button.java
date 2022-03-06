package ir.mtegco.design_system;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import ir.mtegco.design_system.Typefaces.TypefaceHandler;

public class Button extends RelativeLayout {
    OnClickListener onClickListener;
    TextView title;
    RelativeLayout clickableButton;
    CardView cardView;

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
            title.setText(typedArray.getText(R.styleable.Button_android_text));
        }
        title.setTypeface(TypefaceHandler.getTypeface(getContext(), typedArray.getInt(R.styleable.Button_typefaces, TypefaceHandler.BTraffic)));
        setCorner(typedArray.getInt(R.styleable.Button_cornerRadius, 12));
        {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
            clickableButton.setBackgroundColor(typedArray.getColor(R.styleable.Button_backgroundColor, getResources().getColor(typedValue.resourceId)));
        }
        clickableButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        addView(view);
    }

    private void setupViews(View view) {
        title = (TextView) view.findViewById(R.id.title);
        clickableButton = (RelativeLayout) view.findViewById(R.id.clickableLayout);
        cardView = (CardView) view.findViewById(R.id.roundRectView);
    }

    public void setCorner(int radius) {
        cardView.setRadius(radius);
    }
}
