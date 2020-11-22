/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-13 21:19
 **/

package com.taobao.groundstandard.utils;


import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MatrixToImageWriter {
    // 图案的颜色
    private static final int BLACK = 0xFF000000;
    // 背景颜色
    private static final int WHITE = 0xFFFFFFFF;

    private MatrixToImageWriter(){}

    public static BufferedImage toBufferedImage(BitMatrix matrix){

        int width = matrix.getWidth();
        int height = matrix.getHeight();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for (int x=0;x<width;x++){
            for (int y=0;y<height;y++){
                bufferedImage.setRGB(x,y,(matrix.get(x,y)?BLACK:WHITE));
            }
        }
        return bufferedImage;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file)throws IOException{
        System.out.println("write to file");
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image,format,file)){
            System.out.println("生成图片失败");
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }else{
            System.out.println("图片生成成功！");
        }
    }
}
