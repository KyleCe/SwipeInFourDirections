package com.ce.tool.swipeinalldirection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.ce.tool.swipeinalldirection.swipetochangeview.SwipeLeftView;
import com.ce.tool.swipeinalldirection.swipetochangeview.SwipeWithAnimListener;
import com.ce.tool.swipeinalldirection.util.DU;

public class SwipeActivity extends AppCompatActivity {

    GestureDetector mGestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwipeLeftView swipeLeftView = (SwipeLeftView) findViewById(R.id.swipe_view);
        swipeLeftView.assignSwipeOperator(new SwipeWithAnimListener.DirectionOperator() {
            @Override
            public void up() {
                DU.sd("up");
            }

            @Override
            public void down() {
                DU.sd("down");
            }

            @Override
            public void left() {
                DU.sd("left");
            }

            @Override
            public void right() {
                DU.sd("right");
            }
        });
        mGestureDetector = swipeLeftView.getGestureDetector();
        swipeLeftView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mGestureDetector.onTouchEvent(event);

                return false;
            }
        });
    }
}
