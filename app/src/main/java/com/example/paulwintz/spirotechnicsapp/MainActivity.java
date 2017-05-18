package com.example.paulwintz.spirotechnicsapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    AndroidSpirotechnicManager spiroManager = new AndroidSpirotechnicManager();
    SpirotechnicView spiroView;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        spiroView = (SpirotechnicView) findViewById(R.id.canvas_view);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        try{
            spiroView.draw(spiroManager.getCanvas());
        } catch (NullPointerException e){
            Log.e(TAG, "Canvas is null!", e);
            Toast.makeText(getBaseContext(), "Canvas is null", Toast.LENGTH_LONG).show();
        }
    }
}

