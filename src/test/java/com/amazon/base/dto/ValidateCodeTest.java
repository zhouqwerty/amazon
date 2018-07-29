package com.amazon.base.dto;

import com.amazon.base.util.SpecialUtil;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public class ValidateCodeTest {
    @Test
    public void testValidCode(){
        Map<String,Object> map=new ValidateCode().getCode();
        String code=(String) map.get("code");
        BufferedImage image=(BufferedImage)map.get("image");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", outputStream);
            byte[] bs=outputStream.toByteArray();
            System.out.println(bs.length);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
