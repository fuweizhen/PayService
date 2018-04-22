package com.newland.aidl.impl;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import com.jl.TerminalInfo;
import com.jl.pinpad.IRemotePinpad;
import com.jollytech.app.Base16EnDecoder;
import com.jollytech.app.Security;
import com.newland.aidl.pinpad.AidlPinpad;
import com.newland.aidl.pinpad.AidlPinpadListener;
import com.newland.aidl.pinpad.TusnData;
import com.newland.application.AidlApplication;

import java.util.Arrays;


/**
 * Created by Mark on 2018/4/12.
 */

public class Pinpad extends AidlPinpad.Stub {
    public static final int ALG_DES = 0;
    public static final int ALG_SM = 1;
    private IRemotePinpad pinad = AidlApplication.getPinpad();
    private int keyAlg = ALG_SM;
    private int kekindex = 0xF2;
    private byte[] pinblock;

    @Override
    public boolean loadTEK(byte[] key, byte[] checkValue) throws RemoteException {
        int ret = 0;
        ret = pinad.storeTmk(key, kekindex, -1, checkValue, (byte) keyAlg);

        if (ret != 0) {
            Log.e(getClass().getName(), "StoreKek failed:"+ret);
            return false;
        }

        return true;
    }

    @Override
    public boolean loadTMKByTEK(int keyId, byte[] key, byte[] checkValue) throws RemoteException {
        int ret = 0;

        ret = pinad.storeTmk(key, keyId, kekindex, checkValue, (byte) keyAlg);

        if (ret != 0) {
            Log.e(getClass().getName(), "StoreTmk failed:"+ret);
            return false;
        }

        return true;
    }

    @Override
    public boolean loadMainKey(int mkIndex, byte[] keyValue, byte[] kcv) throws RemoteException {
        int ret = 0;

        ret = pinad.storeTmk(keyValue, mkIndex, -1, kcv, (byte) keyAlg);

        if (ret != 0) {
            Log.e(getClass().getName(), "StoreTmk failed:"+ret);
            return false;
        }

        return true;
    }

    @Override
    public boolean loadMainKeyByPlaintext(int keyId, byte[] keyValue, byte[] kcv) throws RemoteException {
        int ret = 0;

        ret = pinad.storeTmk(keyValue, keyId, -1, kcv, (byte) keyAlg);

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
                ret = pinad.storePinWK(keyValue, mkIndex, wkIndex, kcv,  keyAlg);
                break;
            case 0x02:
                ret = pinad.storeTDK(keyValue, mkIndex, wkIndex, kcv, (byte) keyAlg);
                break;
            case 0x03:
                ret = pinad.storeMacWK(keyValue, mkIndex, wkIndex, kcv, (byte) keyAlg);
                break;
            case 0x11:
                ret = pinad.storePinWK(keyValue, mkIndex, wkIndex, kcv, (byte) keyAlg);
                break;
            case 0x12:
                ret = pinad.storeTDK(keyValue, mkIndex, wkIndex, kcv, (byte) keyAlg);
                break;
            case 0x13:
                ret = pinad.storeMacWK(keyValue, mkIndex, wkIndex, kcv, (byte) keyAlg);
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
        int ret = 0;
        byte[] mac = new byte[8];
        int alg = 0;

        switch(macMode){
            case 0x01:
                alg = Security.ANSI_X9_9;
                break;
            case 0x02:
                alg = Security.ANSI_X9_19;
                break;
            case 0x03:
                alg = Security.XOR;
                break;
            case 0x04:
                alg = Security.CUP;
                break;
            case 0x05:
                alg = Security.ANSI_X9_9;
                break;
            case 0x06:
                alg = Security.ANSI_X9_9;
                break;
        }

        ret = pinad.CalculateMac(data, macIndex, alg, mac, cbcData);

        if (ret != 0){
            Log.e(getClass().getName(), "genmac failed:"+ ret);
            return null;
        }
        return mac;
    }

    @Override
    public byte[] encryptData(int encryptMode, int keyIndex, byte[] data, byte[] cbcData) throws RemoteException {
        int ret = 0;
        byte[] enc = new byte[data.length];

        ret = pinad.desEncrypt(data, keyIndex, enc, cbcData);

        if(ret != 0){
            Log.e(getClass().getName(), "DesEncrypt failed:"+ ret);
            return null;
        }

        return enc;
    }

    @Override
    public byte[] decryptData(int decryptMode, int keyIndex, byte[] data, byte[] cbcData) throws RemoteException {
        int ret = 0;
        byte[] pt = new byte[data.length];

        ret = pinad.desDecrypt(data, keyIndex, pt, cbcData);

        if(ret != 0){
            Log.e(getClass().getName(), "DesEncrypt failed:"+ ret);
            return null;
        }

        return pt;
    }

    @Override
    public byte[] setPinpadLayout(byte[] layout) throws RemoteException {
//        return new byte[0];
        return null;
    }

    @Override
    public void startPininput(Bundle param, AidlPinpadListener listener) throws RemoteException {
        int pwk = param.getInt("pinKeyIndex");
        boolean isOnlinPin = param.getBoolean("isOnline");
        String pan = param.getString("pan");
        byte[] pinlimit = param.getByteArray("pinLimit");
        int timeoutS = param.getInt("timeout");
        String lenSet = "";
        int ret = 0;

        for (byte len :
                pinlimit) {
            lenSet += (len + ",");
        }

        lenSet = lenSet.substring(0, lenSet.length()-1);

        pinblock = new byte[16];
        ret = pinad.InputPin(timeoutS, 0, lenSet, pwk, pan, 0, pinblock);

        if (ret != 0){
            Log.e(getClass().getName(), "InputPin failed:"+ret);
            listener.onError(ret, "ERROR("+ret+")");
        }

        listener.onPinRslt(pinblock);
    }

    @Override
    public String getRandom() throws RemoteException {
        byte[] rand = new byte[8];
        int ret = AidlApplication.getinstanceDdi().ddi_security_rand(rand);

        return Base16EnDecoder.Encode(rand);
    }

    @Override
    public void cancelPininput() throws RemoteException {

    }

    @Override
    public TusnData getTusnInfo(String radom) throws RemoteException {

        int ret = 0;
        TusnData tusnData = null;
        TerminalInfo info = new TerminalInfo();

        ret = AidlApplication.getinstanceDdi().ddi_read_terminalinfo(info);

        if (ret != 0){
            Log.e(getClass().getName(), "ddi_read_terminalinfo failed:"+ret);
        }else{
            tusnData = new TusnData();
            tusnData.setSn(info.getSn());
            tusnData.setDeviceType("");
        }

        return tusnData;
    }

    @Override
    public void setKeyAlgorithm(int keyAlgorithm) throws RemoteException {
        keyAlg = keyAlgorithm;
    }

    @Override
    public boolean isSM4Enabled() throws RemoteException {
        return (keyAlg == ALG_SM);
    }
}
