package com.pengwl.newstop;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.pengwl.newstop.appaction.AppAction;

/**
 * Created by Administrator on 2016/11/4 0004.
 */

public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static Context getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final AppAction INSTANCE = new AppAction();
    }

    //获取单例
    public static AppAction getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
