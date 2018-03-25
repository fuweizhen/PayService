// AidlRFCard.aidl
package com.newland.aidl.rfcard;
import com.newland.aidl.rfcard.PowerOnRFResult;

// Declare any non-default types here with import statements

interface AidlRFCard {

PowerOnRFResult powerOn(in int[] cardTypes, int timeout);
byte[] call(in byte[] reqData, int timeout);
void powerOff();
boolean authenticate (int keyMode, in byte[] cardSerialNo, int blockNo,in byte[] key);
boolean writeData(int blockNo,in byte[] data);
byte[] readData (int blockNo);
boolean incrementOper(int blockNo, in byte[] data);
boolean decrementOper (int blockNo, in byte[] data);
boolean isCardExist();

}
