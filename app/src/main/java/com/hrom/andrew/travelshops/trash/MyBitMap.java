package com.hrom.andrew.travelshops.trash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

import com.hrom.andrew.travelshops.R;

public class MyBitMap extends View {

    public MyBitMap(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Resources res = getResources();
        Bitmap bitmap0 = BitmapFactory.decodeResource(res, R.drawable.ic_map_2); //blue
        Bitmap bitmap2 = BitmapFactory.decodeResource(res, R.drawable.icon_bizon); //green
        canvas.drawBitmap(getBitmap(bitmap0, bitmap2), 355, 455, null);

    }

    public static Bitmap getBitmap(Bitmap bmp1, Bitmap bmp2) {
        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
        Canvas canvas = new Canvas(bmOverlay);
        canvas.drawBitmap(bmp1, new Matrix(), null);
        canvas.drawBitmap(bmp2, 38, 38, null);
        return bmOverlay;
    }
}
