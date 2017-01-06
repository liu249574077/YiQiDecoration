package com.finesdk;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Fanhy on 2016/11/14.
 * description：应用Application超类
 */

public class BaseApplication extends Application{
    private Context mContext;
    private volatile static BaseApplication mBaseApp;

    public static BaseApplication newInstance(){

        return mBaseApp;
    }

    public Context getAppContext(){
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mBaseApp=this;
        Fresco.initialize(this);
    }
}
