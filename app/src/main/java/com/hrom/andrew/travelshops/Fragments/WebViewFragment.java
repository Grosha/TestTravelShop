package com.hrom.andrew.travelshops.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.TrashActivity.StringVariables;
import com.hrom.andrew.travelshops.TrashActivity.MyWebClent;

public class WebViewFragment extends Fragment {
    private WebView webView;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_weview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String url = getArguments().getString(StringVariables.WEB);

        webView = (WebView) getActivity().findViewById(R.id.webView);
        progressBar = (ProgressBar) getActivity().findViewById(R.id.webProgressBar);

        webView.setWebViewClient(new MyWebClent(progressBar));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        if (url != null || !url.isEmpty()) {
            webView.loadUrl(url);
        }
    }

}
