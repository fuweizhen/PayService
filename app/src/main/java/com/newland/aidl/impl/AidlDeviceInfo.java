package com.newland.aidl.impl;

import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by Administrator on 2018\3\23 0023.
 */

public class AidlDeviceInfo extends com.newland.aidl.deviceInfo.AidlDeviceInfo.Stub {
    @Override
    public String getTUSN() throws RemoteException {
        return "1111";
    }

    @Override
    public String getSN() throws RemoteException {
        return "1111";
    }

    @Override
    public String getCSN() throws RemoteException {
        return "1111";
    }

    @Override
    public String getVID() throws RemoteException {
        return "1111";
    }

    @Override
    public String getVName() throws RemoteException {
        return "1111";
    }

    @Override
    public String getKSN() throws RemoteException {
        return "1111";
    }

    @Override
    public String getAndroidOSVersion() throws RemoteException {
        return "1111";
    }

    @Override
    public String getAndroidKernelVersion() throws RemoteException {
        return "1111";
    }

    @Override
    public String getFirmwareVersion() throws RemoteException {
        return "1111";
    }

    @Override
    public String getDeviceModel() throws RemoteException {
        return "1111";
    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
