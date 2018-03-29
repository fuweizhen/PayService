package com.newland.aidl.impl;

import android.os.RemoteException;

import com.jl.Ddi;
import com.newland.aidl.led.AidlLED;
import com.newland.application.AidlApplication;

/**
 * Created by fu on 2018/3/29.
 */

public class AidlLed extends AidlLED.Stub {


    private Ddi hal;

    public AidlLed (){
        hal = AidlApplication.getinstanceDdi();
    }

    @Override
    public boolean ledOperation(int color, int operation, int times) throws RemoteException {
        return false;
    }
}
