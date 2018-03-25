// AidlDeviceService.aidl
package com.newland.aidl.deviceService;

// Declare any non-default types here with import statements

interface AidlDeviceService {

       IBinder getDeviceInfo();
       IBinder getPBOC();
       IBinder getPinpad();
       IBinder getPrinter();
       IBinder getICCard();
       IBinder getRFCard();
       IBinder getScanner();
       IBinder getLed();
       IBinder getBeeper();
       IBinder getTerminalManage();
       IBinder getSerialComm();

}
