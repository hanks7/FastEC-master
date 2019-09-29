package com.wuchao.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.wuchao.latte.activitys.ProxyActivity;
import com.wuchao.latte.app.Latte;
import com.wuchao.latte.Fragment.LatteFragment;
import com.wuchao.latte.ec.launcher.ILauncherListener;
import com.wuchao.latte.ec.launcher.LauncherFragment;
import com.wuchao.latte.ec.launcher.OnLauncherFinishTag;
import com.wuchao.latte.ec.main.EcBottomFragment;
import com.wuchao.latte.ec.sign.ISignListener;
import com.wuchao.latte.ec.sign.SignInFragment;

import cn.jpush.android.api.JPushInterface;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }*/
        Latte.getConfigurator().withActivity(this);
        //StatusBarCompat.translucentStatusBar(this, false);
        //StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.app_main));
        StatusBarUtil.setColor(this, getResources().getColor(R.color.app_main));
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override
    public LatteFragment setRootDelegate() {
        return new LauncherFragment();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
        getSupportDelegate().startWithPop(new EcBottomFragment());
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                //Toast.makeText(this, "启动结束，用户登录了", Toast.LENGTH_LONG).show();
                getSupportDelegate().startWithPop(new EcBottomFragment());
                break;
            case NOT_SIGNED:
                //Toast.makeText(this, "启动结束，用户没登录", Toast.LENGTH_LONG).show();
                getSupportDelegate().startWithPop(new SignInFragment());
                break;
            default:
                break;
        }
    }
}
