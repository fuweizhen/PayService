// AidlCheckCardListener.aidl
package com.newland.aidl.pboc;

// Declare any non-default types here with import statements

interface AidlCheckCardListener {

    /**
    * 检测到磁条卡
    * @param trackData:磁卡数据 * <ul>
    * <li>PAN(String):卡号</li>
    * <li>TRACK1(String):磁道 1 数据</li> *<li>TRACK2(String):磁道 2 数据 </li>
    * <li>TRACK3(String):磁道 3 数据</li>
    * <li>SERVICE_CODE(String):服务码 </li>
    * <li>EXPIRED_DATE(String):卡片有效期 </li> * </ul>
    */
    void onFindMagCard(in Bundle trackData);

    /**
    * 检测到 IC 卡
    * */
    void onFindICCard();

    /**
    * 检测到非接卡*/
    void onFindRFCard();

    /**
    * 检卡超时*/
    void onTimeout();

    /**
    * 撤销检卡*/
    void onCancel();

    /**
    * 检卡失败
    * @param error - 错误码，不做硬性要求 * @param message - 错误 述
    */
    void onError( int error,  String message);

}
