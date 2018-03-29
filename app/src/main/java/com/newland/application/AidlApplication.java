package com.newland.application;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.jl.Ddi;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by fu on 2018/3/29.
 */

public class AidlApplication extends Application {

    private static Ddi hal;

    @Override
    public void onCreate() {
        super.onCreate();
        ConfigLog();

    }

    public static Ddi getinstanceDdi(){
        if (null == hal){
            hal = new Ddi();
        }
        return hal;
    }

    private void ConfigLog(){
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("=AIDL=")
                .build();
        Logger.addLogAdapter(new LoogerAdapter(formatStrategy));
    }

    public class LoogerAdapter extends AndroidLogAdapter {

        public LoogerAdapter(@NonNull FormatStrategy formatStrategy) {
            super(formatStrategy);
        }

        @Override
        public boolean isLoggable(int priority, @Nullable String tag) {
            return true;
        }
    }
}
