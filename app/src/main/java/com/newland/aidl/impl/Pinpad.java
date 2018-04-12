package com.newland.aidl.impl;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import com.jollytech.app.Base16EnDecoder;
import com.jollytech.app.Security;
import com.newland.aidl.pinpad.AidlPinpad;
import com.newland.aidl.pinpad.AidlPinpadListener;
import com.newland.aidl.pinpad.TusnData;

import java.util.Arrays;


/**
 * Created by Mark on 2018/4/12.
 */

public class Pinpad extends AidlPinpad.Stub {
    @Override
    public boolean loadTEK(byte[] key, byte[] checkValue) throws RemoteException {
        int ret = 0;
        ret = Security.StoreKek(0, key, checkValue);

        if (ret != 0) {
            Log.e(getClass().getName(), "StoreKek failed:"+ret);
            return false;
        }

        return true;
    }

    @Override
    public boolean loadTMKByTEK(int keyId, byte[] key, byte[] checkValue) throws RemoteException {
        int ret = 0;
        ret = Security.StoreTmk(0, keyId,key, checkValue);

        if (ret != 0) {
            Log.e(getClass().getName(), "StoreTmk failed:"+ret);
            return false;
        }

        return true;
    }

    @Override
    public boolean loadMainKey(int mkIndex, byte[] keyValue, byte[] kcv) throws RemoteException {
        int ret = 0;
        ret = Security.StoreTmk(mkIndex , keyValue, kcv);

        if (ret != 0) {
            Log.e(getClass().getName(), "StoreTmk failed:"+ret);
            return false;
        }

        return true;
    }

    @Override
    public boolean loadMainKeyByPlaintext(int keyId, byte[] keyValue, byte[] kcv) throws RemoteException {
        int ret = 0;
        ret = Security.StoreTmk(keyId , keyValue, kcv);

        if (ret != 0) {
            Log.e(getClass().getName(), "StoreTmk failed:"+ret);
            return false;
        }

        return true;
    }

    @Override
    public boolean loadWorkKey(int keyType, int mkIndex, int wkIndex, byte[] keyValue, byte[] kcv) throws RemoteException {
        int ret = 0;

        switch(keyType){
            case 0x01:
                ret = Security.StorePinWorkingKey(mkIndex, wkIndex, keyValue, kcv);
                break;
            case 0x02:
                ret = Security.StoreTDWorkingKey(mkIndex, wkIndex, keyValue, kcv);
                break;
            case 0x03:
                ret = Security.StoreMacWorkingKey(mkIndex, wkIndex, keyValue, kcv);
                break;
            case 0x11:
                ret = Security.StorePinWorkingKey(mkIndex, wkIndex, keyValue, kcv);
                break;
            case 0x12:
                ret = Security.StoreTDWorkingKey(mkIndex, wkIndex, keyValue, kcv);
                break;
            case 0x13:
                ret = Security.StoreMacWorkingKey(mkIndex, wkIndex, keyValue, kcv);
                break;
            default:
                Log.e(getClass().getName(), "unknow key type:"+keyType);
                ret = -1;
                break;
        }

        if (ret != 0) {
            Log.e(getClass().getName(), "StoreTmk failed:"+ret);
            return false;
        }

        return true;
    }

    @Override
    public byte[] calcMAC(int macMode, int macIndex, byte[] data, byte[] cbcData) throws RemoteException {
        return new byte[0];
    }

    @Override
    public byte[] encryptData(int encryptMode, int keyIndex, byte[] data, byte[] cbcData) throws RemoteException {
        return new byte[0];
    }

    @Override
    public byte[] decryptData(int decryptMode, int keyIndex, byte[] data, byte[] cbcData) throws RemoteException {
        return new byte[0];
    }

    @Override
    public byte[] setPinpadLayout(byte[] layout) throws RemoteException {
        return new byte[0];
    }

    @Override
    public void startPininput(Bundle param, AidlPinpadListener listener) throws RemoteException {

    }

    @Override
    public String getRandom() throws RemoteException {
        return null;
    }

    @Override
    public void cancelPininput() throws RemoteException {

    }

    @Override
    public TusnData getTusnInfo(String radom) throws RemoteException {
        return null;
    }

    @Override
    public void setKeyAlgorithm(int keyAlgorithm) throws RemoteException {

    }

    @Override
    public boolean isSM4Enabled() throws RemoteException {
        return false;
    }
}
