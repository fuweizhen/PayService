// AidlPBOC.aidl
package com.newland.aidl.pboc;
import com.newland.aidl.pboc.AidlCheckCardListener;
import com.newland.aidl.pboc.AidlPBOCListener;

// Declare any non-default types here with import statements

interface AidlPBOC {
    void checkCard(in Bundle option, in AidlCheckCardListener listener);
    void cancelCheckCard();
    void startPBOC(in int pbocType, in Bundle option, in AidlPBOCListener listener);
    void selectApplication(in byte[] aid);
    void importAmount(in long amount);
    void confirmPin(in int oper,in byte[] pin);
    void confirmCardInfo(in boolean isConfirm);
    void confirmCertInfo(in boolean isConfirm);
    void importOnlineResult(in Bundle data);
    void endPboc();
    void setEmvData(in int tag,in byte[] data);
    String readKernelData(out int[] taglist);
    String readTransData (int tag);
    boolean updateAID(in int operation, in String dataSource);
    boolean updateCAPK(in int operation, in String dataSource);
}
