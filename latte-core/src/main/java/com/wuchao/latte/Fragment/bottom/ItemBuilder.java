package com.wuchao.latte.Fragment.bottom;

import java.util.LinkedHashMap;

/**
 * @author: wuchao
 * @date: 2017/12/2 18:17
 * @desciption:
 */

public class ItemBuilder {

    private final LinkedHashMap<BottomTabBean, BottomItemFragment> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final LinkedHashMap<BottomTabBean, BottomItemFragment> build() {
        return ITEMS;
    }

    public final ItemBuilder addItem(BottomTabBean bean, BottomItemFragment delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemFragment> items) {
        ITEMS.putAll(items);
        return this;
    }
}
