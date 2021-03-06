package com.example.paulwintz.spirotechnicsapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

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
        super.onDraw(canvas);

        Toast.makeText(this.getContext(), "Hello!", Toast.LENGTH_LONG);
    }
}
