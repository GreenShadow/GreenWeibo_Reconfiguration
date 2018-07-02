package com.greenshadow.greenweibo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshadow.greenweibo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FunctionButton extends FrameLayout {

    @BindView(R.id.function_icon) ImageView mIcon;
    @BindView(R.id.function_name) TextView mName;
    @BindView(R.id.function_count) TextView mCount;

    public FunctionButton(Context context) {
        this(context, null);
    }

    public FunctionButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FunctionButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public FunctionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater.from(context).inflate(R.layout.view_function_button, this);
        ButterKnife.bind(this);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FunctionButton);

        // get icon
        Drawable icon = ta.getDrawable(R.styleable.FunctionButton_icon);
        if (icon != null) {
            mIcon.setImageDrawable(icon);
        }

        // get name
        String name = ta.getString(R.styleable.FunctionButton_name);
        if (name != null) {
            mName.setText(name);
        }

        ta.recycle();

        mCount.setText("0");
    }

    private void setCount(int count) {
        if (count < 0) {
            count = 0;
        }
        mCount.setText(String.valueOf(count));
    }
}
