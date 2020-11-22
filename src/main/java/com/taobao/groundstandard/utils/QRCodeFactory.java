/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-13 21:54
 **/

package com.taobao.groundstandard.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class QRCodeFactory {
    public void CreatQrImage(String content,String format,String outFileUri,int ...size)throws IOException, WriterException{
        int width = 430;
        int height=430;
        if (size.length==2){
            width=size[0];
            height=size[1];
        }else if (size.length==1){
            width=height=size[0];
        }

        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.MARGIN,1);

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        File file = new File(outFileUri);

        System.out.println("输出文件路径为"+file.getPath());

        MatrixToImageWriter.writeToFile(bitMatrix,format,file);
    }
}
