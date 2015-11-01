package com.hrom.andrew.travelshops.trash;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MyWebClent extends WebViewClient {
    private ProgressBar progressBar;

    public MyWebClent() {
    }

    public MyWebClent(ProgressBar progressBar) {
        this.progressBar = progressBar;
        progressBar.setVisibility(WebView.GONE);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
