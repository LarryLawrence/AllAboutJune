/*
 * The fragment to show the webView.
 * @author DrunkPiano
 * @version 1.0
 * Modifying History:
 * Modifier: DrunkPiano, June 5th 2016, fixed to accord it with the standard coding disciplines.
 */

package com.drunkpiano.allaboutthejune;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewPageFragment extends Fragment {
    private WebView mWebView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_page, container, false);

        android.support.v7.widget.Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar_custom);
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout_web);
        if (null != mSwipeRefreshLayout) {
            mSwipeRefreshLayout.setColorSchemeResources(
                    R.color.swipe_color_1, R.color.swipe_color_2,
                    R.color.swipe_color_3, R.color.swipe_color_4);
            mSwipeRefreshLayout.setProgressViewOffset(false, 40, 120);
            mSwipeRefreshLayout.setRefreshing(true);
        }
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mWebView.reload();
            }
        });
        mWebView = (WebView) rootView.findViewById(R.id.web_view_main);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://sale.jd.com/act/1k5RrLgYKnUFWI6T.html?t=1463931873456&cpdad=1DLSUE");
        mWebView.setWebViewClient(new MainWebViewClient());
        return rootView;
    }

    class MainWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            mSwipeRefreshLayout.setRefreshing(false);
            super.onPageFinished(view, url);
        }
    }
}
