package ir.mtegco.design_system.Toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.mtegco.design_system.R;

public class Toolbar extends RelativeLayout {
    TextView title, description;
    RelativeLayout back;
    OnClickListener onBackClickListener;

    public void setOnBackClickListener(OnClickListener onBackClickListener) {
        this.onBackClickListener = onBackClickListener;
    }

    public Toolbar(Context context) {
        super(context);
        init(null);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.designsystem_toolbar, null);
        setupViews(view);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Toolbar);
        if (typedArray.hasValue(R.styleable.Toolbar_android_title)) {
            title.setText(typedArray.getString(R.styleable.Toolbar_android_title));
        }
        if (typedArray.hasValue(R.styleable.Toolbar_android_description)) {
            description.setText(typedArray.getString(R.styleable.Toolbar_android_description));
        }
        if (onBackClickListener != null) {
            back.setVisibility(VISIBLE);
        } else {
            back.setVisibility(GONE);
        }
        back.setOnClickListener(onBackClickListener);
    }

    private void setupViews(View view) {
        title = (TextView) view.findViewById(R.id.title);
        description = (TextView) view.findViewById(R.id.description);
        back = (RelativeLayout) view.findViewById(R.id.back);
    }
}
