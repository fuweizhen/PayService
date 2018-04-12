package com.newland.aidl.impl;

import android.os.Bundle;
import android.os.RemoteException;

import com.newland.aidl.pboc.AidlCheckCardListener;
import com.newland.aidl.pboc.AidlPBOC.Stub;
import com.newland.aidl.pboc.AidlPBOCListener;

/**
 * Created by Mark on 2018/4/12.
 */

public class PBOC extends Stub {
    @Override
    public void checkCard(Bundle option, AidlCheckCardListener listener) throws RemoteException {

    }

    @Override
    public void cancelCheckCard() throws RemoteException {

    }

    @Override
    public void startPBOC(int pbocType, Bundle option, AidlPBOCListener listener) throws RemoteException {

    }

    @Override
    public void selectApplication(byte[] aid) throws RemoteException {

    }

    @Override
    public void importAmount(long amount) throws RemoteException {

    }

    @Override
    public void confirmPin(int oper, byte[] pin) throws RemoteException {

    }

    @Override
    public void confirmCardInfo(boolean isConfirm) throws RemoteException {

    }

    @Override
    public void confirmCertInfo(boolean isConfirm) throws RemoteException {

    }

    @Override
    public void importOnlineResult(Bundle data) throws RemoteException {

    }

    @Override
    public void endPboc() throws RemoteException {

    }

    @Override
    public void setEmvData(int tag, byte[] data) throws RemoteException {

    }

    @Override
    public String readKernelData(int[] taglist) throws RemoteException {
        return null;
    }

    @Override
    public String readTransData(int tag) throws RemoteException {
        return null;
    }

    @Override
    public boolean updateAID(int operation, String dataSource) throws RemoteException {
        return false;
    }

    @Override
    public boolean updateCAPK(int operation, String dataSource) throws RemoteException {
        return false;
    }
}
