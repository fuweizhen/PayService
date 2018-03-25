// AidlPrinterListener.aidl
package com.newland.aidl.printer;

// Declare any non-default types here with import statements

interface AidlPrinterListener {
  /**
  * 打印错误
  * @param code 打印机状态码(0x01:数据解析出错，0x02:缺纸， 0x03:超温,0x04:打印机忙,0x05:其他错误)
  * @param detail 错误详情
  */
  void onError(int code, String detail);
  /**
  * 打印完成
  * */
  void onFinish();
}
