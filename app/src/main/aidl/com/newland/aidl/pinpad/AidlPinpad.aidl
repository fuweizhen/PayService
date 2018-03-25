// AidlPinpad.aidl
package com.newland.aidl.pinpad;
import com.newland.aidl.pinpad.AidlPinpadListener;
import com.newland.aidl.pinpad.TusnData;

// Declare any non-default types here with import statements

interface AidlPinpad {

boolean loadTEK(in byte[] key, in byte[] checkValue);
boolean loadTMKByTEK(int keyId, in byte[] key, in byte[] checkValue);
boolean loadMainKey(int mkIndex, in byte[] keyValue, in byte[] kcv);
boolean loadMainKeyByPlaintext(int keyId,in byte[] keyValue,in byte[] kcv);
boolean loadWorkKey(int keyType,int mkIndex, int wkIndex, in byte[] keyValue, in byte[] kcv);
byte[] calcMAC(int macMode,int macIndex, in byte[] data,in byte[] cbcData);
byte[] encryptData(int encryptMode,int keyIndex, in byte[] data,in byte[] cbcData);
byte[] decryptData(int decryptMode,int keyIndex, in byte[] data,in byte[] cbcData);
byte[] setPinpadLayout(in byte[] layout);
void startPininput(in Bundle param, in AidlPinpadListener listener);
String getRandom();
void cancelPininput();
TusnData getTusnInfo(in String radom);
void setKeyAlgorithm(int keyAlgorithm);
boolean isSM4Enabled();

}
