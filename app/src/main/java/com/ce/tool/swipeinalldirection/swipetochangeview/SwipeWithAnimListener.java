package com.ce.tool.swipeinalldirection.swipetochangeview;


import com.ce.tool.swipeinalldirection.util.DU;

/**
 * Created by KyleCe on 2016/5/23.
 *
 * @author: KyleCe
 */
public class SwipeWithAnimListener extends OnSwipeListener {


    private DirectionOperator mOperator;

    public SwipeWithAnimListener() {

    }

    public SwipeWithAnimListener(DirectionOperator operator) {
        mOperator = operator;
    }


    @Override
    public boolean onSwipe(Direction direction) {
        if (mOperator == null) return super.onSwipe(direction);

        switch (direction) {
            case up:
                DU.sd("up");
                mOperator.up();
                break;
            case down:
                DU.sd("d");
                mOperator.down();
                break;
            case left:
                DU.sd("l");
                mOperator.left();
                break;
            case right:
                DU.sd("r");
                mOperator.right();
                break;
            case none:
            default:
                DU.sd("none");
                break;
        }

        return super.onSwipe(direction);
    }

    public interface DirectionOperator {
        void up();

        void down();

        void left();

        void right();
    }

}
