// AidlSerialComm.aidl
package com.newland.aidl.serialComm;

// Declare any non-default types here with import statements

interface AidlSerialComm {

int open();
int setconfig(int data1,int data2,in byte[] buf);
int ioctl(int cmd ,in byte[] args);
int read(out byte[] buf ,int lengthMax, int timeoutSec);
int write(in byte[] buf ,int lengthMax, int timeoutSec);
int close();

}
