package ir.mtegco.design_system.Toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import ir.mtegco.design_system.R;

public class Toolbar extends RelativeLayout {
    TextView title, subtitle;
    RelativeLayout back;
    LinearLayout linearLayout;
    OnClickListener onBackClickListener = null;
    int actionBarSize;

    public void setOnBackClickListener(OnClickListener onBackClickListener) {
        this.onBackClickListener = onBackClickListener;
        back.setVisibility(VISIBLE);
        linearLayout.setPaddingRelative(0, 0, actionBarSize, 0);
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
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true);
        actionBarSize = TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, actionBarSize);

        if (typedArray.hasValue(R.styleable.Toolbar_title)) {
            title.setText(typedArray.getString(R.styleable.Toolbar_title));
        }
        if (typedArray.hasValue(R.styleable.Toolbar_subtitle)) {
            subtitle.setText(typedArray.getString(R.styleable.Toolbar_subtitle));
            subtitle.setVisibility(VISIBLE);
        }
        if (onBackClickListener == null) {
            back.setVisibility(GONE);
        }
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBackClickListener != null) {
                    onBackClickListener.onClick(view);
                }
            }
        });
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    private void setupViews(View view) {
        title = (TextView) view.findViewById(R.id.title);
        subtitle = (TextView) view.findViewById(R.id.subtitle);
        back = (RelativeLayout) view.findViewById(R.id.back);
        linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
    }


    public void setTitle(String title) {
        this.title.setText(title);
    }

}
