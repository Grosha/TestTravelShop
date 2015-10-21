package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.hrom.andrew.travelshops.R;

public class MyBitMap extends View {
    private Bitmap bitmap;

    public MyBitMap(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*canvas.drawBitmap(bitmap, 0f, 0f, null);
        canvas.drawBitmap(bitmap, (canvas.getHeight() / 2), (canvas.getWidth() / 2), null);*/

        bitmap = null;
        try {

            bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            Resources res = getResources();


            Bitmap bitmap1 = BitmapFactory.decodeResource(res, R.drawable.ic_map_2); //blue

            Bitmap bitmap2 = BitmapFactory.decodeResource(res, R.drawable.icon_bizon); //green
            Drawable drawable1 = new BitmapDrawable(bitmap1);
            Drawable drawable2 = new BitmapDrawable(bitmap2);


            drawable1.setBounds(100, 100, 400, 400);
            drawable2.setBounds(150, 150, 350, 350);
            drawable1.draw(canvas);
            drawable2.draw(canvas);


        } catch (Exception e) {
        }
        //return bitmap;
    }
}
