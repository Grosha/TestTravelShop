package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.hrom.andrew.travelshops.R;

public class MyBitMap extends View {
    private Bitmap bitmap;

    public MyBitMap(Context context) {
        super(context);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.web_);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0f, 0f, null);
        canvas.drawBitmap(bitmap, (canvas.getHeight() / 2), (canvas.getWidth() / 2), null);

        /*Bitmap cs = null;

        int width, height = 0;

        if(c.getWidth() > s.getWidth()) {
            width = c.getWidth() + s.getWidth();
            height = c.getHeight();
        } else {
            width = s.getWidth() + s.getWidth();
            height = c.getHeight();
        }

        cs = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas comboImage = new Canvas(cs);

        comboImage.drawBitmap(c, 0f, 0f, null);
        comboImage.drawBitmap(s, c.getWidth(), 0f, null);*/
    }
}
