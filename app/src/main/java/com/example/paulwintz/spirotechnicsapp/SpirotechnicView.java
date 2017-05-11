package com.example.paulwintz.spirotechnicsapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by PaulWintz on 4/23/2017.
 */

class SpirotechnicView extends View {
    public SpirotechnicView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public SpirotechnicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public SpirotechnicView(Context context) {
        super(context);
    }

    AndroidSpirotechnicManager spirotechnicManager = new AndroidSpirotechnicManager();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(spirotechnicManager.d);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setShadowLayer(5, 2, 2, Color.BLUE);

//        for(int i = 1; i < 100; i++) {
        RectF oval1 = new RectF(0, 0, getWidth() / 3, getHeight() / 3);
//            canvas.drawOval(oval1, paint);
//        }

        canvas.drawCircle(30, 20, 40, paint);
        canvas.drawRect(oval1, paint);
    }
}
