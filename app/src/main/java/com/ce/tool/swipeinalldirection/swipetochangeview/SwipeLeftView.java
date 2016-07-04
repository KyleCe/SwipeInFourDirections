package com.ce.tool.swipeinalldirection.swipetochangeview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by KyleCe on 2016/6/24.
 *
 * @author: KyleCe
 */
public class SwipeLeftView extends FrameLayout implements SwipeWithAnimListener.DirectionOperator {

    private SwipeWithAnimListener.DirectionOperator mDirectionOperator;

    private GestureDetector mGestureDetector;

    private Context mContext;

    public SwipeLeftView(Context context) {
        this(context, null);
    }

    public SwipeLeftView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeLeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context.getApplicationContext();
    }

    public void assignSwipeOperator(SwipeWithAnimListener.DirectionOperator operator) {
        mDirectionOperator = operator;
    }

    public GestureDetector getGestureDetector() {
        if (mGestureDetector == null)
            mGestureDetector = new GestureDetector(mContext, new SwipeWithAnimListener(this));
        return mGestureDetector;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mGestureDetector.onTouchEvent(ev);
        return true;
    }

    @Override
    public void up() {
        if (mDirectionOperator != null) mDirectionOperator.up();
    }

    @Override
    public void down() {
        if (mDirectionOperator != null) mDirectionOperator.down();
    }

    @Override
    public void left() {
        if (mDirectionOperator != null) mDirectionOperator.left();
    }

    @Override
    public void right() {
        if (mDirectionOperator != null) mDirectionOperator.right();
    }
}
