package com.wuchao.latte.Fragment.web.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.webkit.URLUtil;
import android.webkit.WebView;

import com.wuchao.latte.Fragment.LatteFragment;
import com.wuchao.latte.Fragment.web.WebFragment;
import com.wuchao.latte.Fragment.web.WebFragmentImpl;

/**
 * @author: wuchao
 * @date: 2017/11/29 16:43
 * @desciption:
 */

public class Router {

    private Router() {
    }

    private static class Holder {
        private static final Router INSTANCE = new Router();
    }

    public static Router getInstance() {
        return Holder.INSTANCE;
    }

    public final boolean handleWebView(WebFragment delegate, String url) {
        //如果是电话协议
        if (url.contains("tel:")) {
            callPhone(delegate.getContext(), url);
            return true;
        }
        final LatteFragment topDelegate = delegate.getTopDelegate();
        final WebFragmentImpl webDelegate = WebFragmentImpl.create(url);
        if (topDelegate != null) {
            topDelegate.getSupportDelegate().start(webDelegate);
        } else {
            delegate.getSupportDelegate().start(webDelegate);
        }
        return true;
    }

    private void loadWebPage(WebView webView, String url) {
        if (webView != null) {
            webView.loadUrl(url);
        } else {
            throw new NullPointerException("WebView is null!");
        }
    }

    private void loadLocalPage(WebView webView, String url) {
        loadWebPage(webView, "file:///android_asset/" + url);
    }

    private void loadPage(WebView webView, String url) {
        if (URLUtil.isNetworkUrl(url) || URLUtil.isAssetUrl(url)) {
            loadWebPage(webView, url);
        } else {
            loadLocalPage(webView, url);
        }
    }

    public final void loadPage(WebFragment delegate, String url) {
        loadPage(delegate.getWebView(), url);
    }

    private void callPhone(Context context, String url) {
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        final Uri data = Uri.parse(url);
        intent.setData(data);
        ContextCompat.startActivity(context, intent, null);
    }
}
