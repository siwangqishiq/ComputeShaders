package com.xinlan.computeshader;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class ProcessTask extends AsyncTask<Bitmap, Integer , Bitmap> {
    @Override
    protected Bitmap doInBackground(Bitmap... bitmaps) {
        Bitmap srcBitmap = bitmaps[0];
        return FastBlur.doBlur(srcBitmap , 50 , false);
    }
}
