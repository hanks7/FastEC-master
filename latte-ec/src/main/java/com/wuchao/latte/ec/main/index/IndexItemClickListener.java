package com.wuchao.latte.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.wuchao.latte.Fragment.LatteFragment;
import com.wuchao.latte.ec.detail.GoodsDetailFragment;
import com.wuchao.latte.ui.recycler.MultipleFields;
import com.wuchao.latte.ui.recycler.MultipleItemEntity;

/**
 * @author: wuchao
 * @date: 2017/12/17 16:24
 * @desciption:
 */

public class IndexItemClickListener extends SimpleClickListener {

    private final LatteFragment DELEGATE;

    public IndexItemClickListener(LatteFragment delegate) {
        this.DELEGATE = delegate;
    }

    public static IndexItemClickListener create(LatteFragment delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final MultipleItemEntity entity = (MultipleItemEntity) baseQuickAdapter.getData().get(position);
        final int goodId = entity.getField(MultipleFields.ID);
        GoodsDetailFragment delegate = GoodsDetailFragment.create(goodId);
        DELEGATE.start(delegate);
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
