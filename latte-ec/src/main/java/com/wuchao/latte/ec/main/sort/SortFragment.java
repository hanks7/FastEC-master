package com.wuchao.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wuchao.ec.R;
import com.wuchao.latte.Fragment.bottom.BottomItemFragment;
import com.wuchao.latte.ec.main.sort.content.ContentFragment;
import com.wuchao.latte.ec.main.sort.list.VerticalListFragment;

/**
 * @author: wuchao
 * @date: 2017/12/17 16:45
 * @desciption:
 */

public class SortFragment extends BottomItemFragment {

    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListFragment listDelegate = new VerticalListFragment();
        loadRootFragment(R.id.vertical_list_container, listDelegate);
        //设置右侧第一个分类显示，默认显示分类一
        getSupportDelegate().loadRootFragment(R.id.sort_content_container, ContentFragment.newInstance(1));
    }
}
