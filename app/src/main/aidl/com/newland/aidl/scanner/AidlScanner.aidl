// AidlScanner.aidl
package com.newland.aidl.scanner;
import com.newland.aidl.scanner.AidlScannerListener;

// Declare any non-default types here with import statements

interface AidlScanner {

    void startScan(int scanType,int timeout, AidlScannerListener listener);
    void stopScan();

}
