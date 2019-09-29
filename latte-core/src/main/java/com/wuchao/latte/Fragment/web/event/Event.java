package com.wuchao.latte.Fragment.web.event;

import android.content.Context;
import android.webkit.WebView;

import com.wuchao.latte.Fragment.web.WebFragment;

/**
 * @author: wuchao
 * @date: 2017/11/29 22:22
 * @desciption:
 */

public abstract class Event implements IEvent {

    private Context mContext;
    private String mAction;
    private WebFragment mDelegate;
    private String mUrl;
    private WebView mWebView;

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        mAction = action;
    }

    public WebFragment getDelegate() {
        return mDelegate;
    }

    public void setDelegate(WebFragment delegate) {
        mDelegate = delegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public WebView getWebView() {
        return mDelegate.getWebView();
    }
}
