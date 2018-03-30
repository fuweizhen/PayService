package com.newland.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.newland.aidl.deviceService.AidlDeviceService;
import com.newland.aidl.impl.AidlDeviceInfo;
import com.newland.aidl.impl.AidlICCard;
import com.newland.aidl.impl.AidlLed;
import com.newland.aidl.impl.AidlPrinter;
import com.newland.aidl.impl.AidlRFCard;

/**
 * Created by Administrator on 2018\3\22 0022.
 */

public class DeviceService extends Service
{

    public DeviceService()
    {

    }

    public IBinder onBind(Intent intent)
    {
        return new AidlDevice();
    }

    private class AidlDevice extends AidlDeviceService.Stub
    {


        @Override
        public IBinder getDeviceInfo() throws RemoteException {
            return new AidlDeviceInfo();
        }

        @Override
        public IBinder getPBOC() throws RemoteException {
            return null;
        }

        @Override
        public IBinder getPinpad() throws RemoteException {
            return null;
        }

        @Override
        public IBinder getPrinter() throws RemoteException {
            return new AidlPrinter();
        }

        @Override
        public IBinder getICCard() throws RemoteException {
            return new AidlICCard();
        }

        @Override
        public IBinder getRFCard() throws RemoteException {
            return new AidlRFCard();
        }

        @Override
        public IBinder getScanner() throws RemoteException {
            return null;
        }

        @Override
        public IBinder getLed() throws RemoteException {
            return new AidlLed();
        }

        @Override
        public IBinder getBeeper() throws RemoteException {
            return null;
        }

        @Override
        public IBinder getTerminalManage() throws RemoteException {
            return null;
        }

        @Override
        public IBinder getSerialComm() throws RemoteException {
            return null;
        }
    }

}
