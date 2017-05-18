package com.example.paulwintz.spirotechnicsapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    public AndroidCanvas(int width, int height, int numLayers) {
        if(numLayers < 1) throw new IllegalArgumentException("There must be at least one layer");
        this.width = width;
        this.height = height;
        layers = new ArrayList<>(numLayers);
        for(int i = 0; i < numLayers; i++){
            layers.add(createLayer());
            paints.add(new Paint());
        }
        Log.d(TAG, String.format("Layers: %s, paints: %s", layers, paints));
    }

    @Override
    public void setSize(int width, int height) {
        notImplementedError();
    }

    @Override
    public void setScale(float scale) {
        this.scale = scale;
    }

    private Canvas createLayer(){
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Log.d(TAG, String.format("canvas: %s", canvas));
        return canvas;
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
    public void line(float x0, float y0, float x1, float y1, Painter painter) {
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
    public void arc(float v, float v1, float v2, float v3, float v4, float v5, Painter painter) {
        notImplementedError();
    }

    @Override
    public void quad(float v, float v1, float v2, float v3, float v4, float v5, float v6, float v7, Painter painter) {
        notImplementedError();
    }

    @Override
    public void drawPath(List<Vector> list, Painter painter, Queue<Transformation<Canvas>> queue) {
        notImplementedError();

    }

    @Override
    public void drawPolygon(List<Vector> list, Painter painter, Queue<Transformation<Canvas>> queue) {

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
    }

    @Override
    public void clearLayer(Painter painter) {
        notImplementedError();
        Canvas layer = layers.get(painter.getLayer());
        layer.drawColor(painter.getFill());
    }

    @Override
    public void background(Painter painter) {
        Canvas layer = layers.get(painter.layer);
    }

    @Override
    public int getWidth(){
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public double getScale() {
        return scale;
    }

    @Override
    public int getLayersCount() {
        return layers.size();
    }

    @Override
    public Canvas getImage() {
        return layers.get(0);
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
        Log.e(TAG, "Option not implemented", new RuntimeException());
    }
}
