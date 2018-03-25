// AidlPrinter.aidl
package com.newland.aidl.printer;
import com.newland.aidl.printer.AidlPrinterListener;

// Declare any non-default types here with import statements

interface AidlPrinter {

void addText(in Bundle format, String text);
void paperSkip(int line);
void addPicture(in Bundle format,in Bitmap bitmap);
void addBarCode(in Bundle format,String barCode);
void addQrCode(in Bundle format, String qrCode);
void setSpace(int ySpace);
void startPrinter(in AidlPrinterListener listener);
String getStatus();

}
