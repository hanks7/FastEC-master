package com.wuchao.latte.ec.main;

import android.graphics.Color;

import com.wuchao.latte.Fragment.bottom.BaseBottomFragment;
import com.wuchao.latte.Fragment.bottom.BottomItemFragment;
import com.wuchao.latte.Fragment.bottom.BottomTabBean;
import com.wuchao.latte.Fragment.bottom.ItemBuilder;
import com.wuchao.latte.ec.main.cart.ShopCartFragment;
import com.wuchao.latte.ec.main.discover.DiscoverFragment;
import com.wuchao.latte.ec.main.index.IndexFragment;
import com.wuchao.latte.ec.main.personal.PersonalFragment;
import com.wuchao.latte.ec.main.sort.SortFragment;

import java.util.LinkedHashMap;

/**
 * @author: wuchao
 * @date: 2017/12/3 21:44
 * @desciption:
 */

public class EcBottomFragment extends BaseBottomFragment {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemFragment> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemFragment> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexFragment());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortFragment());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoverFragment());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartFragment());
        items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalFragment());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
