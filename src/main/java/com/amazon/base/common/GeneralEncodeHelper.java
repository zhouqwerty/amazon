package com.amazon.base.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import com.amazon.base.util.CommonUtil;
import org.apache.commons.codec.binary.Base64;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.24 18:58
 * @describe 辅助类 一般的编码类
 * */
public class GeneralEncodeHelper {
    public static final String ALGORITHM_MD5 = "MD5";
    public static final String ALGORITHM_SHA_1 = "SHA-1";
    public static final String ALGORITHM_SHA_256 = "SHA-256";
    private static final GeneralEncodeHelper instance = new GeneralEncodeHelper();

    private GeneralEncodeHelper() {
    }

    public static GeneralEncodeHelper getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        File big = new File("D:\\test.txt");
        String md5 = getInstance().getFileMD5String(big);
        System.out.println(md5);
        System.out.println(getInstance().encode("MD5", "aaa"));
    }

    public String encode(String algorithm, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return this.parseByteToHexStr(messageDigest.digest());
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public byte[] encodeToBase64(String str) {
        return CommonUtil.isNullOrEmpty(str) ? null : Base64.encodeBase64(str.getBytes());
    }

    public byte[] decodeBase64(String str) {
        return CommonUtil.isNullOrEmpty(str) ? null : Base64.decodeBase64(str.getBytes());
    }

    public String getFileMD5String(File file) {
        FileInputStream fileInputStream = null;

        Object var4;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];

            int length;
            while((length = fileInputStream.read(buffer)) != -1) {
                messageDigest.update(buffer, 0, length);
            }

            StringBuffer sb = new StringBuffer();
            sb.append(this.parseByteToHexStr(messageDigest.digest()));
            String var7 = sb.toString();
            return var7;
        } catch (Exception var17) {
            var17.printStackTrace();
            var4 = null;
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException var16) {
                var16.printStackTrace();
            }

        }

        return (String)var4;
    }

    public String parseByteToHexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < buf.length; ++i) {
            String hex = Integer.toHexString(buf[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }

    public String parseByteToHexStr(byte buf) {
        StringBuffer sb = new StringBuffer();
        String hex = Integer.toHexString(buf & 255);
        if (hex.length() == 1) {
            hex = '0' + hex;
        }

        sb.append(hex.toUpperCase());
        return sb.toString();
    }

    public byte[] parseHexStrToByte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        } else {
            byte[] result = new byte[hexStr.length() / 2];

            for(int i = 0; i < hexStr.length() / 2; ++i) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte)(high * 16 + low);
            }

            return result;
        }
    }
}
