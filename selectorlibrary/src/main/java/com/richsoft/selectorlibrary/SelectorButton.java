package com.richsoft.selectorlibrary;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;


/**
 * 作者：chengjie on 17/3/31 11:02
 * 邮箱：10078216660@qq.com
 * 描述：
 */
public class SelectorButton extends AppCompatButton {
    public static final String TAG = SelectorButton.class.getSimpleName();

    private int mTextPressedColor;//按下文字颜色
    private int mTextNormalColor;//正常文字颜色
    private int mTextUnableColor;//不可点击文字颜色

    private int mBgPressedColor;//按下背景颜色
    private int mBgNormalColor;//正常背景颜色
    private int mBgUnableColor;//不可点击背景颜色

    private int mRadius;//半径

    private int mAnimationDuration;//动画持续时间

    private int[][] mStates;

    private boolean mRound;//是否是圆形

    private GradientDrawable mNormalBackground;
    private GradientDrawable mPressedBackground;
    private GradientDrawable mUnableBackground;

    private StateListDrawable mStateListDrawable;

    public SelectorButton(Context context) {
        this(context, null);
    }

    public SelectorButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.buttonStyle);
    }

    public SelectorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getResources().obtainAttributes(attrs, R.styleable.SelectorButton);
        mTextPressedColor = typedArray.getColor(R.styleable.SelectorButton_text_pressed_color, Color.WHITE);
        mTextNormalColor = typedArray.getColor(R.styleable.SelectorButton_text_normal_color, Color.WHITE);
        mTextUnableColor = typedArray.getColor(R.styleable.SelectorButton_text_unable_color, Color.WHITE);

        mBgPressedColor = typedArray.getColor(R.styleable.SelectorButton_bg_pressed_color, ContextCompat.getColor(context, R.color.teal300));
        mBgNormalColor = typedArray.getColor(R.styleable.SelectorButton_bg_normal_color, ContextCompat.getColor(context, R.color.teal500));
        mBgUnableColor = typedArray.getColor(R.styleable.SelectorButton_bg_unable_color, ContextCompat.getColor(context, R.color.teal200));

        mRadius = typedArray.getDimensionPixelSize(R.styleable.SelectorButton_corner_radius, 0);

        mRound = typedArray.getBoolean(R.styleable.SelectorButton_round, false);

        mAnimationDuration = typedArray.getInt(R.styleable.SelectorButton_animation_duration, 100);

        typedArray.recycle();

        init();
    }

    /**
     * init view
     */
    private void init() {
        Drawable drawable = getBackground();
        if (drawable != null && drawable instanceof StateListDrawable) {
            mStateListDrawable = (StateListDrawable) drawable;
        } else {
            mStateListDrawable = new StateListDrawable();
        }

        mNormalBackground = new GradientDrawable();
        mPressedBackground = new GradientDrawable();
        mUnableBackground = new GradientDrawable();

        mStates = new int[4][];
        mStates[0] = new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed};
        mStates[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        mStates[2] = new int[]{-android.R.attr.state_enabled};
        mStates[3] = new int[]{android.R.attr.state_enabled};

        //background color
        mNormalBackground.setColor(mBgNormalColor);
        mPressedBackground.setColor(mBgPressedColor);
        mUnableBackground.setColor(mBgUnableColor);

        //text color
        setTextColor();

        //corner radius
        mNormalBackground.setCornerRadius(mRadius);
        mPressedBackground.setCornerRadius(mRadius);
        mUnableBackground.setCornerRadius(mRadius);
        //去掉点击效果的阴影
        mNormalBackground.setStroke(0, 0, 0, 0);
        mPressedBackground.setStroke(0, 0, 0, 0);
        mUnableBackground.setStroke(0, 0, 0, 0);

        //animation duration
        mStateListDrawable.setEnterFadeDuration(mAnimationDuration);
        mStateListDrawable.setExitFadeDuration(mAnimationDuration);

        mStateListDrawable.addState(mStates[0], mPressedBackground);
        mStateListDrawable.addState(mStates[1], mPressedBackground);
        mStateListDrawable.addState(mStates[2], mUnableBackground);
        mStateListDrawable.addState(mStates[3], mNormalBackground);
        setBackgroundDrawable(mStateListDrawable);
    }

    /**
     * 设置圆角
     */
    private void setRound() {
        if (mRound) {
            int height = getMeasuredHeight();
            mNormalBackground.setCornerRadius(height / 2.f);
            mPressedBackground.setCornerRadius(height / 2.f);
            mUnableBackground.setCornerRadius(height / 2.f);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setRound();
    }

    public void setBgPressedColor(@ColorInt int id) {
        mPressedBackground.setColor(id);
    }

    public void setBgNormalColor(@ColorInt int id) {
        mNormalBackground.setColor(id);
    }

    public void setBgUnableColor(@ColorInt int id) {
        mUnableBackground.setColor(id);
    }

    public void setTextNormalColor(@ColorInt int id) {
        this.mTextNormalColor = id;
        setTextColor();
    }

    public void setTextPressedColor(@ColorInt int id) {
        this.mTextPressedColor = id;
        setTextColor();
    }

    public void setTextUnableColor(@ColorInt int id) {
        this.mTextUnableColor = id;
        setTextColor();
    }

    private void setTextColor() {
        int[] colors = new int[]{mTextPressedColor, mTextPressedColor, mTextUnableColor, mTextNormalColor};
        setTextColor(new ColorStateList(mStates, colors));
    }

}
