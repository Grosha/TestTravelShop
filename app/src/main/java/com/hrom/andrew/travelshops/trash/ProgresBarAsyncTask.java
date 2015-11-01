package com.hrom.andrew.travelshops.trash;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;


public class ProgresBarAsyncTask extends AsyncTask<Void, Integer, Void> {

    private int idFragment = 0;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(StringVariables.PROGRESS, "progres start");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(StringVariables.PROGRESS, "progres end");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected Void doInBackground(Void... params) {
        while (idFragment != StringVariables.TAG_MAP_){
            idFragment++;
            publishProgress(idFragment);
            SystemClock.sleep(500);
        }
        return null;
    }
}
