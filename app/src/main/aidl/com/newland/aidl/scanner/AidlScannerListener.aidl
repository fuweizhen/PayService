// AidlScannerListener.aidl
package com.newland.aidl.scanner;

// Declare any non-default types here with import statements

interface AidlScannerListener {

/**
* 读码成功的回调
* @param barcode 读取到的码数据
* */
void onScanResult(in String barcod);
/**
* 读码超时
*/
void onTimeout();
/**
* 扫码错误
* @param errorCode 错误码
* @param detail 错误详情 *0x01(打开摄像头失败) *0x02(设备不支持前置/后置扫码) *0x03(其他错误)
*/
void onError(int errorCode, String detail);
/**
* 取消扫码
*/
   void onCancel();
}
