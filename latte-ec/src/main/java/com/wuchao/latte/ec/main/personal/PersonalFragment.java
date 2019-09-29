package com.wuchao.latte.ec.main.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wuchao.ec.R;
import com.wuchao.ec.R2;
import com.wuchao.latte.Fragment.bottom.BottomItemFragment;
import com.wuchao.latte.ec.main.personal.address.AddressFragment;
import com.wuchao.latte.ec.main.personal.list.ListAdapter;
import com.wuchao.latte.ec.main.personal.list.ListBean;
import com.wuchao.latte.ec.main.personal.list.ListItemType;
import com.wuchao.latte.ec.main.personal.order.OrderListFragment;
import com.wuchao.latte.ec.main.personal.profile.UserProfileFragment;
import com.wuchao.latte.ec.main.personal.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: wuchao
 * @date: 2018/1/1 21:48
 * @desciption:
 */

public class PersonalFragment extends BottomItemFragment {

    @BindView(R2.id.rv_personal_setting)
    RecyclerView mRvSettings = null;

    public static final String ORDER_TYPE = "ORDER_TYPE";
    private Bundle mArgs = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    @OnClick(R2.id.tv_all_order)
    void onClickAllOrder() {
        mArgs.putString(ORDER_TYPE, "all");
        startOrderListByType();
    }

    @OnClick(R2.id.img_user_avatar)
    void onClickAvatar() {
        getParentDelegate().getSupportDelegate().start(new UserProfileFragment());
    }

    private void startOrderListByType() {
        final OrderListFragment delegate = new OrderListFragment();
        delegate.setArguments(mArgs);
        getParentDelegate().start(delegate);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArgs = new Bundle();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        final ListBean address = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(1)
                .setDelegate(new AddressFragment())
                .setText("收货地址")
                .build();

        final ListBean system = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setDelegate(new SettingsFragment())
                .setText("系统设置")
                .build();

        final List<ListBean> data = new ArrayList<>();
        data.add(address);
        data.add(system);

        //设置RecyclerView
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvSettings.setLayoutManager(manager);
        final ListAdapter adapter = new ListAdapter(data);
        mRvSettings.setAdapter(adapter);
        mRvSettings.addOnItemTouchListener(new PersonalClickListener(this));
    }
}
