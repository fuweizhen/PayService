// AidlPBOCListener.aidl
package com.newland.aidl.pboc;
import com.newland.aidl.pboc.AidEntry;
import com.newland.aidl.pboc.CardInfo;
import com.newland.aidl.pboc.TransferLog;
import com.newland.aidl.pboc.EcLog;

// Declare any non-default types here with import statements

interface AidlPBOCListener {
   /**
   * 要求选择应用
   * @param aidEntry 应用列表对象 */
   void onSelectApplication(in AidEntry[] aidEntry);
   /**
   * 请求输入金额
   */
   void onRequestAmount();
  /*** 要求确认认证信息
  * @param certType 证件类型 * @param certInfo 证件信息
  * */
  void onConfirmCertInfo(in String certType, in String certInfo);
  /**
  * 要求确认卡信息
  * @param cardNo 卡号
  * */
  void onConfirmCardInfo(in String cardNo);
  /**
  * 要求输入 PIN
  * @param isOnlinePin 是否是联机 pin
  * @param retryTimes pin 的剩余输入次数
  * */
  void onRequestPinEntry(boolean isOnlinePin,int retryTimes);
  /**
  * 联机请求
  *@param respData:联机数据
  *RESULT_CODE –结果码，0x01:行为结果 arqc;0x02:qpboc 联机 * ARQC_TLV(String) – 55 域 TLV 数据
  * REVERSAL_TLV(String) – 冲正数据
  *EQUAL_TRACK2 等效二磁道 *CARD_SN 卡序列号 *CARD_VALID_DATE 卡有效期
  */
  void onRequestOnline(in Bundle respData);
  /**
  * 降级请求
  */
  void onFallback();
  /**
  * pboc 流程结果
  * @param resultCode 交易结果
  ** <ul> 
  * <li>0x01 - EMV 流程结束(未联机)</li> * <li>0x02 – 交易成功</li>
  * <li>0x03 – 交易拒绝</li>
  * <li>0x04 – 找不到支持的应用</li>
  * <li>0x05 - 脱机数据认证失败</li>
  * <li>0x06 - 持卡人认证失败</li>
  * <li>0x07 - 卡片锁定</li>
  * <li>0x08 - 卡片已过期 </li>
  * <li>0x09 - 卡片未生效</li>
  * <li>0x0A - 电子现金余额不足</li> * <li>0x0B– 圈存金额超出限额</li> * <li>0x0C - 脚本错误</li>
  * <li>0x0D - 脚本超限</li>
  * <li>0x0E – 交易金额超出限额</li>
  * <li>0x0F - 纯电子现金卡不能联机</li>
  * <li>0x10 - 卡片拒绝</li>
  * <li>0x11 – EMV 参数错误</li>
  * @param respData 交易结果数据
  * ARQC_TLV(String) – 55 域 TLV 数据
  * REVERSAL_TLV(String) – 冲正数据
  * SCRIPT_TLV(String) – 脚本数据
  * ERRORMSG(String) – 错误信息,当 resultCode 为 0x11 时填入
  * */
  void onPbocFinished(int resultCode ,in Bundle respData);
  /**
  * 读取电子现金的余额
  * @param cardInfo 电子现金余额对象
  * * *
  *String acctNo;// 卡号
  *String balance;// 电子现金余额(单位:分) String cardExpirationDate;// 卡过期日期
  * */
  void onReadECBalance(in CardInfo cardInfo);
  /**
  * 读取电子现金日志
  * @param transLog pboc 交易日志对象
  * */
  void onReadPBOCLog(in List<TransferLog> transLog);
  /**
  * 读取圈存日志
  * @param transLog 圈存日志对象
  * */
  void onReadECLog(in List<EcLog> ecLog);
}
