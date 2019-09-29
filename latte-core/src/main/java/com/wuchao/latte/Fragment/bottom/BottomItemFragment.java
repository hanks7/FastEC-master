package com.wuchao.latte.Fragment.bottom;

import android.widget.Toast;

import com.wuchao.latte.Fragment.LatteFragment;
import com.wuchao.latte.R;
import com.wuchao.latte.app.Latte;

/**
 * @author: wuchao
 * @date: 2017/12/2 17:44
 * @desciption:
 */

public abstract class BottomItemFragment extends LatteFragment {

    //再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long touchTime = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - touchTime > WAIT_TIME) {
            Toast.makeText(_mActivity, "双击退出"+ Latte.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
            touchTime = System.currentTimeMillis();
        } else {
            _mActivity.finish();
        }
        return true;
    }
}
