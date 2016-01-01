package com.hrom.andrew.travelshops.trash;

import android.app.Activity;
import android.os.Bundle;

public class TestBitmap extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyBitMap(this));
    }
}
