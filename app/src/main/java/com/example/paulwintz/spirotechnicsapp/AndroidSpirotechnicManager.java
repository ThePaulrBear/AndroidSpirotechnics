package com.example.paulwintz.spirotechnicsapp;

import android.graphics.Canvas;
import android.util.Log;
import android.widget.Toast;

import paul.wintz.spirotechnics.SpirotechnicManager;

/**
 * Created by PaulWintz on 5/7/2017.
 */

public class AndroidSpirotechnicManager extends SpirotechnicManager<Canvas> {

    private static class AndroidDisplayCallback extends DisplayCallback<Canvas> {
            @Override
        public void onDisplay(Canvas canvas) {

        }
    };
    private static class AndroidToastCallback extends ToastCallback {
        @Override
        protected void onDrawToast() {

        }
    };
    private static class AndroidLogCallback extends LogCallback{
        @Override
        public void logStd(String s) {
            Log.d("TAG", s);
        }

        @Override
        public void logError(String s) {
            Log.e("Error", s);
        }

        @Override
        public void logError(Exception e) {
            Log.e("Error", e.getMessage(), e);
        }
    }

    public AndroidSpirotechnicManager() {
        super(
                new AndroidCanvas(200, 200, 2),
                new AndroidDisplayCallback(),
                new AndroidToastCallback(),
                new AndroidLogCallback());
    }

    public Canvas getCanvas(){
        return getCanvasManager().getImage();
    }

}
