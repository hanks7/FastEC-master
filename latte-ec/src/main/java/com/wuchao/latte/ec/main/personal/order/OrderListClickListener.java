package com.wuchao.latte.ec.main.personal.order;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.wuchao.latte.Fragment.LatteFragment;

/**
 * @author: wuchao
 * @date: 2018/1/9 22:38
 * @desciption:
 */

public class OrderListClickListener extends SimpleClickListener{

    private final LatteFragment mDelegate;

    public OrderListClickListener(LatteFragment delegate) {
        mDelegate = delegate;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        mDelegate.getSupportDelegate().start(new OrderCommentFragment());
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
