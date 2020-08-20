package com.example.onsitetask2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class FragmentAPaintView extends View {

    private Path path;
    private Paint blackStroke;
    private FragmentA fragmentA;

    public FragmentAPaintView(Context context, FragmentA fragmentA) {
        super(context);
        this.fragmentA = fragmentA;
        setBackgroundColor(Color.CYAN);

        path = new Path();

        blackStroke = new Paint();
        blackStroke.setColor(Color.BLACK);
        blackStroke.setAntiAlias(true);
        blackStroke.setStyle(Paint.Style.STROKE);
        blackStroke.setStrokeWidth(8);
        blackStroke.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos = event.getX();
        float yPos = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos, yPos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos, yPos);
                fragmentA.callPathGetter();
                break;
            default:
                return false;
        }

        postInvalidate();
        return false;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, blackStroke);
    }

    public Path getPath() {
        return path;
    }

}
