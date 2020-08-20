package com.example.onsitetask2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class FragmentBPaintView extends View {

    private Path path;
    private Paint blackStroke;
    private FragmentB fragmentB;

    public FragmentBPaintView(Context context, FragmentB fragmentB) {
        super(context);
        setBackgroundColor(Color.MAGENTA);
        this.fragmentB = fragmentB;

        path = new Path();

        blackStroke = new Paint();
        blackStroke.setColor(Color.BLACK);
        blackStroke.setAntiAlias(true);
        blackStroke.setStyle(Paint.Style.STROKE);
        blackStroke.setStrokeWidth(8);
        blackStroke.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, blackStroke);
    }

    public void setPath(Path path) {
        this.path = path;
        postInvalidate();
    }
}
