// AidlICCard.aidl
package com.newland.aidl.iccard;

// Declare any non-default types here with import statements

interface AidlICCard {

    byte[] powerOn(int cardSlot, int cardType);
    byte[] call(int cardSlot, int cardType, in byte[] data, int timeout);
    void powerOff(int cardSlot, int cardType);
    boolean isCardExist(int cardSlot);

}
