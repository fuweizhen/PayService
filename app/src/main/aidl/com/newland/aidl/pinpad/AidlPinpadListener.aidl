// AidlPinpadListener.aidl
package com.newland.aidl.pinpad;

// Declare any non-default types here with import statements

interface AidlPinpadListener {

/**
* 按键时回调
* @param len 当前密码的长度 * @param key *号掩码键值
* */
void onKeyDown(int len, int key);
/**
* 当用户点击确认按键时被调用
* @param data pin码
*/
void onPinRslt(in byte[] data);
/**
* pinpad设备发生错误时候被调用
* @param errorCode 错误码，不做硬性规定 * @param errorDescription 错误 述
*/
void onError(int errorCode,String errorDescription);
/**
* 当取消密码输入时触发
*/
void onCancel();

}
