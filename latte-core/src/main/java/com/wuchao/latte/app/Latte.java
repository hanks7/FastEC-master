package com.wuchao.latte.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * @author: wuchao
 * @date: 2017/10/16 22:36
 * @desciption:
 */

public final class Latte {

    /**
     * 返回配置
     *
     * @param context
     */
    public static Configurator init(Context context) {
        getConfigurator().getLatteConfigs().put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        getConfigurator().getLatteConfigs().put(ConfigType.APPLICATION, context);
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

    public static Application getApplication() {
        return getConfiguration(ConfigType.APPLICATION);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER);
    }
}
