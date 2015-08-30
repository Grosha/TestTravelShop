package com.hrom.andrew.travelshops.TrashActivity;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.renderscript.Int4;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;


public class ProgresBarAsyncTask extends AsyncTask<Void, Integer, Void> {

    private int idFragment = 0;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(MyTag.PROGRESS, "progres start");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(MyTag.PROGRESS, "progres end");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected Void doInBackground(Void... params) {
        while (idFragment != MyTag.TAG_MAP_){
            idFragment++;
            publishProgress(idFragment);
            SystemClock.sleep(500);
        }
        return null;
    }
}
