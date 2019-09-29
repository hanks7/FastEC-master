package com.wuchao.latte.Fragment.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.wuchao.latte.Fragment.web.event.Event;
import com.wuchao.latte.Fragment.web.event.EventManager;

/**
 * @author: wuchao
 * @date: 2017/11/28 23:06
 * @desciption:
 */

final class LatteWebInterface {

    private final WebFragment DELEGATE;

    private LatteWebInterface(WebFragment delegate) {
        this.DELEGATE = delegate;
    }

    static LatteWebInterface create(WebFragment delegate) {
        return new LatteWebInterface(delegate);
    }

    @JavascriptInterface
    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        if (event != null) {
            event.setAction(action);
            event.setContext(DELEGATE.getContext());
            event.setDelegate(DELEGATE);
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }
}
