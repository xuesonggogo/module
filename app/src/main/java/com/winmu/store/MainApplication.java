package com.winmu.store;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.winmu.librarycommon.base.BaseApplication;
import com.winmu.librarycommon.utils.Utils;

public class MainApplication extends BaseApplication {
    private final static String TAG = "MainApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        if (Utils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        Log.i(TAG, "onCreate: ");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
      //  MultiDex.install(this);
    }


}
