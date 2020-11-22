/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-13 22:59
 **/

package com.taobao.groundstandard.utils;

import com.google.zxing.WriterException;

import java.io.IOException;

public class Zxing {
    public void getphoto(String stallId){
        String content = "http://122.51.231.211:8080/user/tologin?a="+stallId;
//        String outFileUri="E:/Projects/test/"+ stallId +".jpg";
        String outFileUri="/usr/etc/photo/"+stallId+".jpg";
        int[]  size=new int[]{430,430};
        String format = "jpg";

        try {
            new QRCodeFactory().CreatQrImage(content,format,outFileUri,size);
        }catch (IOException e){
            e.printStackTrace();
        }catch (WriterException e){
            e.printStackTrace();
        }
    }
}
