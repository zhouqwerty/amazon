package com.amazon.base.util;

import sun.misc.BASE64Encoder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.27 19:06
 * @describe 工具类 特殊需求的工具类
 * */
public class SpecialUtil {

    private static BASE64Encoder encoder=new BASE64Encoder();

    public static String bufferImageToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        String base64Img = encoder.encode(outputStream.toByteArray());
        return base64Img;
    }
}
