package com.example.paulwintz.spirotechnicsapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import paul.wintz.canvas.Painter;
import paul.wintz.utils.Vector;

/**
 * Created by PaulWintz on 5/7/2017.
 */

public class AndroidCanvas implements  paul.wintz.canvas.Canvas<Canvas> {
    private static final String TAG = AndroidCanvas.class.getSimpleName();

    ArrayList<Canvas> layers = new ArrayList<>();
    ArrayList<Paint> paints = new ArrayList<>();

    int width, height;
    float rotation, scale, centerX, centerY;

    @Override
    public void setSize(int width, int height) {
        notImplementedError();
    }

    @Override
    public void setScale(float scale) {
        this.scale = scale;
    }

    @Override
    public void setCenter(float centerX, float centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void setRotation(float angle) {
        this.rotation = angle;
    }

    @Override
    public void line(float x0, float y0, float x1, float y1, Painter painter, Queue<Transformation<Canvas>> transformations) {
        Canvas layer = layers.get(painter.layer);
        Paint paint = paints.get(painter.layer);
        paint.setColor(painter.getStroke());
        paint.setStrokeWidth(painter.getStrokeWeight());
        layer.drawLine(x0, y0, x1, y1, paint);
    }

    @Override
    public void ellipse(float centerX, float centerY, float width, float height, Painter painter, Queue<Transformation<Canvas>> transformations) {
        Canvas layer = layers.get(painter.layer);
        Paint paint = bindPaint(painter);

        RectF bounds = new RectF(centerX - 0.5f * width, centerY + 0.5f * height, centerX + 0.5f * width, centerY - 0.5f * height);

        layer.drawOval(bounds, paint);
    }

    @Override
    public void drawPath(List<Vector> list, Painter painter, Queue<Transformation<Canvas>> queue) {
        notImplementedError();

    }

    @Override
    public Transformation<Canvas> getRotationTransformation(float v) {
        notImplementedError();
        return null;
    }

    @Override
    public Transformation<Canvas> getTranslationTransformation(float v, float v1) {
        notImplementedError();
        return null;
    }

    @Override
    public Transformation<Canvas> getScaleTransformation(float v, float v1) {
        notImplementedError();
        return null;
    }

    @Override
    public void handleNewFrame() {
        notImplementedError();

    }

    @Override
    public void clearAll() {
        notImplementedError();
        for(Canvas layer : layers){
            //TODO
        }
    }

    @Override
    public void clearLayer(Painter painter) {
        notImplementedError();
    }

    @Override
    public void background(Painter painter) {
        Canvas layer = layers.get(painter.layer);
    }

    @Override
    public int getWidth(){
        notImplementedError();
        return 0;
    }

    @Override
    public int getHeight() {

        notImplementedError();
        return 0;
    }

    @Override
    public double getScale() {
        notImplementedError();
        return 0;
    }

    @Override
    public int getLayersCount() {

        notImplementedError();
        return 0;
    }

    @Override
    public Canvas getImage() {

        notImplementedError();
        return null;
    }

    @Override
    public void saveImage(File file) {
        notImplementedError();
    }


    private Paint bindPaint(Painter painter){
        Paint paint = paints.get(painter.getLayer());
        if(painter.isStroked()){
            paint.setColor(painter.getStroke());
            paint.setStrokeWidth(painter.getStrokeWeight());
        } else if(painter.isFilled()){
            paint.setColor(painter.getFill());
        }
        return paint;
    }

    private void notImplementedError() {
        Log.e(TAG, new RuntimeException("Not implmented").getStackTrace()[0].toString());
    }
}
