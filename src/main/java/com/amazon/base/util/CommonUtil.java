package com.amazon.base.util;

import com.alibaba.fastjson.util.IOUtils;
import com.amazon.base.common.ChineseNumParser;
import com.amazon.base.common.GeneralEncodeHelper;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import java.awt.Color;
import java.io.*;
import java.lang.Character.UnicodeBlock;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.http.HttpMethod;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.24 18:58
 * @describe 工具类 常用的工具类
 * */
public class CommonUtil {
    public CommonUtil() {
    }

    public static String transformHalfToFull(String str) {
        str = trimToEmpty(str);
        StringBuffer buf = new StringBuffer(str.length());
        char[] ca = str.toCharArray();

        for(int i = 0; i < ca.length; ++i) {
            if (ca[i] == ' ') {
                buf.append('　');
            } else if (ca[i] >= '!' && ca[i] <= '~') {
                buf.append((char)(ca[i] + 'ﻠ'));
            } else {
                buf.append(ca[i]);
            }
        }

        return buf.toString();
    }

    public static String transformFullToHalf(String str) {
        str = trimToEmpty(str);
        StringBuffer buf = new StringBuffer(str.length());
        char[] ca = str.toCharArray();

        for(int i = 0; i < str.length(); ++i) {
            if (ca[i] >= '！' && ca[i] <= '～') {
                buf.append((char)(ca[i] - 'ﻠ'));
            } else if (ca[i] == 12288) {
                buf.append(' ');
            } else {
                buf.append(ca[i]);
            }
        }

        return buf.toString();
    }

    public static String generateUUID(String... separator) {
        if (separator != null && separator.length != 0) {
            String sep = trimToEmpty(separator[0]);
            return UUID.randomUUID().toString().replaceAll("-", sep);
        } else {
            return UUID.randomUUID().toString();
        }
    }

    public static String getStrEncoding(String str) {
        if (isNullOrEmpty(str)) {
            return "";
        } else {
            String encode = StandardCharsets.ISO_8859_1.toString();

            try {
                if (str.equals(new String(str.getBytes(encode), encode))) {
                    return encode;
                }
            } catch (Exception var6) {
                ;
            }

            encode = StandardCharsets.UTF_8.toString();

            try {
                if (str.equals(new String(str.getBytes(encode), encode))) {
                    return encode;
                }
            } catch (Exception var5) {
                ;
            }

            encode = "GBK";

            try {
                if (str.equals(new String(str.getBytes(encode), encode))) {
                    return encode;
                }
            } catch (Exception var4) {
                ;
            }

            encode = "GB2312";

            try {
                if (str.equals(new String(str.getBytes(encode), encode))) {
                    return encode;
                }
            } catch (Exception var3) {
                ;
            }

            return "";
        }
    }

    public static String parseBlobToString(Blob blob) {
        if (blob == null) {
            return "";
        } else {
            try {
                InputStream is = blob.getBinaryStream();
                Throwable var2 = null;

                String var4;
                try {
                    byte[] ba = ByteStreams.toByteArray(is);
                    var4 = new String(ba, StandardCharsets.UTF_8);
                } catch (Throwable var14) {
                    var2 = var14;
                    throw var14;
                } finally {
                    if (is != null) {
                        if (var2 != null) {
                            try {
                                is.close();
                            } catch (Throwable var13) {
                                var2.addSuppressed(var13);
                            }
                        } else {
                            is.close();
                        }
                    }

                }

                return var4;
            } catch (Exception var16) {
                var16.printStackTrace();
                return "";
            }
        }
    }

    public static Blob parseStringToBlob(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        } else {
            try {
                return new SerialBlob(str.getBytes(StandardCharsets.UTF_8));
            } catch (Exception var2) {
                var2.printStackTrace();
                return null;
            }
        }
    }

    public static String parseClobToString(Clob clob) {
        if (clob == null) {
            return "";
        } else {
            try {
                Reader reader = clob.getCharacterStream();
                Throwable var2 = null;

                String var3;
                try {
                    var3 = CharStreams.toString(reader);
                } catch (Throwable var13) {
                    var2 = var13;
                    throw var13;
                } finally {
                    if (reader != null) {
                        if (var2 != null) {
                            try {
                                reader.close();
                            } catch (Throwable var12) {
                                var2.addSuppressed(var12);
                            }
                        } else {
                            reader.close();
                        }
                    }

                }

                return var3;
            } catch (Exception var15) {
                var15.printStackTrace();
                return "";
            }
        }
    }

    public static Clob parseStringToClob(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        } else {
            SerialClob clob = null;

            try {
                clob = new SerialClob(str.toCharArray());
            } catch (SerialException var3) {
                var3.printStackTrace();
            } catch (SQLException var4) {
                var4.printStackTrace();
            }

            return clob;
        }
    }

    public static int parseLongToInt(Long l) {
        return l.intValue();
    }

    public static int parseToInt(Object value, int defalut) {
        try {
            return Integer.parseInt(trimToEmpty(value));
        } catch (Exception var3) {
            return defalut;
        }
    }

    public static long parseToLong(Object value, long defalut) {
        try {
            return Long.parseLong(trimToEmpty(value));
        } catch (Exception var4) {
            return defalut;
        }
    }

    public static double parseToDouble(Object value, double defaultValue) {
        try {
            return Double.parseDouble(trimToEmpty(value));
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    public static float parseToFloat(Object value, float defaultValue) {
        try {
            return Float.parseFloat(trimToEmpty(value));
        } catch (Exception var3) {
            return defaultValue;
        }
    }

    public static BigDecimal parseToBigDecimal(String str, String defaultValue) {
        return isNullOrEmpty(str) ? new BigDecimal(defaultValue) : new BigDecimal(str);
    }

    public static boolean parseToBoolean(Object value, boolean defaultValue) {
        String v = trimToEmpty(value);
        if (v.isEmpty()) {
            return defaultValue;
        } else if (v.equals("0")) {
            return false;
        } else if (v.equals("1")) {
            return true;
        } else {
            try {
                return Boolean.parseBoolean(trimToEmpty(value));
            } catch (Exception var4) {
                return defaultValue;
            }
        }
    }

    public static int parseBooleanToInt(boolean bool) {
        return bool ? 1 : 0;
    }

    public static double formatDouble(double d, int scale) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(scale);
        return Double.valueOf(nf.format(d).replaceAll(",", "")).doubleValue();
    }

    public static String formatDoubleToStr(double d, int scale) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(scale);
        return nf.format(d).replaceAll(",", "");
    }

    public static float formatFloat(float f, int scale) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(scale);
        return Float.valueOf(nf.format((double)f).replaceAll(",", "")).floatValue();
    }

    public static String formatFloatToStr(float f, int scale) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(scale);
        return nf.format((double)f).replaceAll(",", "");
    }

    public static boolean isEnglishLetter(char input) {
        return input >= 'a' && input <= 'z' || input >= 'A' && input <= 'Z';
    }

    public static boolean isArabicNumber(char input) {
        return input >= '0' && input <= '9';
    }

    public static boolean isCJKCharacter(char input) {
        return UnicodeBlock.of(input) == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;
    }

    public static boolean isEnglishLetter(String str) {
        return isNullOrEmpty(str) ? false : str.matches("^[A-Za-z]+$");
    }

    public static boolean isArabicNumber(String str, boolean ignoreDecimal) {
        if (isNullOrEmpty(str)) {
            return false;
        } else {
            return ignoreDecimal ? str.matches("[\\d]+") : str.matches("[\\d.]+");
        }
    }

    public static boolean isCoordinate(String str) {
        if (isNullOrEmpty(str)) {
            return false;
        } else if (!str.replaceAll(",", "").matches("[\\d.]+[\\d.]")) {
            return false;
        } else if (!str.contains(",")) {
            return false;
        } else {
            String str1 = str.split(",")[0];
            String str2 = str.split(",")[1];
            return str1.matches("[\\d.]+") && str2.matches("[\\d.]+");
        }
    }

    public static boolean isChinese(String str) {
        return isNullOrEmpty(str) ? false : str.matches("^[一-龥]*$");
    }

    public static boolean isNullOrEmpty(Object obj) {
        return trimToNull(obj) == null;
    }

    public static boolean isLegalURL(String url, String requestMethod) {
        if (StringUtils.isBlank(url)) {
            return false;
        } else {
            try {
                requestMethod = StringUtils.trimToEmpty(requestMethod);
                if (requestMethod.isEmpty()) {
                    requestMethod = HttpMethod.GET.toString();
                }

                requestMethod = requestMethod.toUpperCase();
                HttpURLConnection.setFollowRedirects(false);
                HttpURLConnection con = (HttpURLConnection)(new URL(url)).openConnection();
                con.setRequestMethod(requestMethod);
                return con.getResponseCode() == 200;
            } catch (Exception var3) {
                var3.printStackTrace();
                return false;
            }
        }
    }

    public static String trimToNull(Object o) {
        if (o == null) {
            return null;
        } else if (o instanceof String) {
            return StringUtils.trimToNull(o.toString());
        } else {
            if (o instanceof Object[]) {
                Object[] objs = (Object[])((Object[])o);
                if (objs.length == 0) {
                    return null;
                }

                boolean flag = false;
                Object[] arr$ = objs;
                int len$ = objs.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    Object obj = arr$[i$];
                    if (obj != null && !obj.toString().trim().isEmpty()) {
                        flag = true;
                    }
                }

                if (!flag) {
                    return null;
                }
            }

            if (o instanceof Map && MapUtils.isEmpty((Map)o)) {
                return null;
            } else {
                return o instanceof Collection && CollectionUtils.isEmpty((Collection)o) ? null : o.toString();
            }
        }
    }

    public static String trimToEmpty(Object o) {
        String temp = trimToNull(o);
        return temp == null ? "" : StringUtils.trimToEmpty(temp);
    }

    public static String trimToEmptyComplete(String str) {
        return str == null ? "" : str.replaceAll("[\\s\\p{Zs}]+", "");
    }

    public static String trimToEmptyComplete2(Object o) {
        String str = trimToEmpty(o);
        str = CharMatcher.WHITESPACE.trimAndCollapseFrom(str, ' ');
        str = str.replaceAll(" ", "");
        return str;
    }

    public static <T> List<T> filterBlankList(List<T> list, boolean filterMultiValue) {
        List<T> result = new ArrayList();
        if (isNullOrEmpty(list)) {
            return result;
        } else {
            Iterator i$ = list.iterator();

            while(true) {
                Object t;
                do {
                    do {
                        if (!i$.hasNext()) {
                            return result;
                        }

                        t = i$.next();
                    } while(isNullOrEmpty(t));
                } while(filterMultiValue && result.contains(t));

                if (t instanceof String) {
                    t = trimToEmpty(t);
                }

                result.add((T)t);
            }
        }
    }

    public static <T> T[] filterBlankArray(T[] array, boolean filterMultiValue) {
        if (isNullOrEmpty(array)) {
            return (T[])ArrayUtils.nullToEmpty(array);
        } else {
            List<T> list = Arrays.asList(array);
            List<T> temp = filterBlankList(list, filterMultiValue);
            return temp.toArray(array);
        }
    }

    public static String replaceStr(String oldStr, String newStr, int start, int end) {
        if (start >= 0 && start <= end) {
            String before = oldStr.substring(0, start);
            String after = oldStr.substring(end);
            StringBuffer sb = new StringBuffer(before);
            sb.append(newStr);
            sb.append(after);
            return sb.toString();
        } else {
            return "";
        }
    }

    public static String joinArrayToStr(String[] array, String separator) {
        return isNullOrEmpty(array) ? "" : Joiner.on(separator).skipNulls().join(array);
    }

    public static List<String> splitStrToList(String str, String separator) {
        str = trimToEmpty(str);
        return (List)(str.isEmpty() ? Lists.newArrayList() : Splitter.on(separator).trimResults().omitEmptyStrings().splitToList(str));
    }

    public static Object[] splitStrToArray(String str, String separator) {
        List<String> list = splitStrToList(str, separator);
        return list.toArray(new Object[0]);
    }

    public static String generateRandomStr(int length) {
        int i = 0;
        StringBuffer out = new StringBuffer();

        while(true) {
            int c;
            do {
                if (i >= length) {
                    return out.toString();
                }

                Random r = new Random();
                c = r.nextInt(122);
            } while((c <= 47 || c >= 58) && (c <= 64 || c >= 91) && (c <= 96 || c >= 123));

            out.append(c);
            ++i;
        }
    }

    public static Color generateRandomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public static String generateRandomChinese(int length) {
        StringBuffer sb = new StringBuffer();

        try {
            for(int i = length; i > 0; --i) {
                Random random = new Random((new Date()).getTime());
                Integer highPos = 176 + Math.abs(random.nextInt(39));
                Integer lowPos = 161 + Math.abs(random.nextInt(93));
                byte[] b = new byte[]{highPos.byteValue(), lowPos.byteValue()};
                String str = new String(b, "GBK");
                sb.append(str);
            }
        } catch (UnsupportedEncodingException var8) {
            var8.printStackTrace();
        }

        return sb.toString();
    }

    public static String generateRandomRangeChinese(int start, int end) {
        int length = (new Random()).nextInt(end + 1);
        return length < start ? generateRandomRangeChinese(start, end) : generateRandomChinese(length);
    }

    public static int generateRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    public static int generateRandom(int number) {
        Random random = new Random();
        return random.nextInt(number + 1);
    }

    public static String parseChineseNumToArabic(String str) {
        StringBuffer sb = new StringBuffer();
        int size = str.length();

        for(int i = 0; i < size; ++i) {
            char ch = str.charAt(i);
            String chStr = String.valueOf(ch);
            chStr = ChineseNumParser.getArabicByChinese(chStr);
            sb.append(chStr);
        }

        return sb.toString();
    }

    public static String getArabicNumber(String str) {
        str = trimToEmpty(str);
        return CharMatcher.DIGIT.retainFrom(str);
    }

    public static String getArabicNumber(String str, boolean transformChineseNum) {
        str = trimToEmpty(str);
        StringBuffer sb = new StringBuffer();
        int size = str.length();

        for(int i = 0; i < size; ++i) {
            char ch = str.charAt(i);
            String chStr = String.valueOf(ch);
            if (isArabicNumber(ch)) {
                sb.append(ch);
            } else if (transformChineseNum) {
                sb.append(ChineseNumParser.getArabicByChinese(chStr));
            }
        }

        return sb.toString();
    }

    public static List<String> getArabicNumberGroup(String str, boolean transformChineseNum) {
        str = trimToEmpty(str);
        StringBuffer sb = new StringBuffer();
        int size = str.length();

        for(int i = 0; i < size; ++i) {
            char ch = str.charAt(i);
            String chStr = String.valueOf(ch);
            if (isArabicNumber(ch)) {
                sb.append(ch);
            } else if (transformChineseNum) {
                sb.append(ChineseNumParser.getArabicByChinese(chStr));
            } else {
                sb.append(" ");
            }
        }

        return splitStrToList(sb.toString(), " ");
    }

    public static String retainDigitAndLetter(String str) {
        str = trimToEmpty(str);
        return CharMatcher.JAVA_DIGIT.or(CharMatcher.javaLetter()).retainFrom(str);
    }

    public static String getStackTrace(Throwable throwable) {
        try {
            Writer result = new StringWriter();
            Throwable var2 = null;

            Object var5;
            try {
                PrintWriter printWriter = new PrintWriter(result);
                Throwable var4 = null;

                try {
                    throwable.printStackTrace(printWriter);
                    var5 = result.toString();
                } catch (Throwable var30) {
                    var5 = var30;
                    var4 = var30;
                    throw var30;
                } finally {
                    if (printWriter != null) {
                        if (var4 != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable var29) {
                                var4.addSuppressed(var29);
                            }
                        } else {
                            printWriter.close();
                        }
                    }

                }
            } catch (Throwable var32) {
                var2 = var32;
                throw var32;
            } finally {
                if (result != null) {
                    if (var2 != null) {
                        try {
                            result.close();
                        } catch (Throwable var28) {
                            var2.addSuppressed(var28);
                        }
                    } else {
                        result.close();
                    }
                }

            }

            return (String)var5;
        } catch (Exception var34) {
            var34.printStackTrace();
            return "";
        }
    }

    public static URL getClasspathURL() {
        return Thread.currentThread().getContextClassLoader().getResource("");
    }

    public static String getMacAddress() {
        String firstMac = "";

        try {
            Enumeration el = NetworkInterface.getNetworkInterfaces();

            while(el.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface)el.nextElement();
                if (!ni.isVirtual()) {
                    byte[] mac = ni.getHardwareAddress();
                    if (mac != null && mac.length >= 1) {
                        StringBuffer sb = new StringBuffer();
                        byte[] arr$ = mac;
                        int len$ = mac.length;

                        for(int i$ = 0; i$ < len$; ++i$) {
                            byte b = arr$[i$];
                            sb.append("-").append(GeneralEncodeHelper.getInstance().parseByteToHexStr(b));
                        }

                        firstMac = sb.substring(1);
                        break;
                    }
                }
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return firstMac;
    }

    public static String[] getLocalHostIpAndName() {
        String[] arr = new String[2];

        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();

            while(true) {
                while(netInterfaces.hasMoreElements()) {
                    NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
                    Enumeration nii = ni.getInetAddresses();

                    while(nii.hasMoreElements()) {
                        InetAddress ip = (InetAddress)nii.nextElement();
                        if (!(ip instanceof Inet6Address) && !"127.0.0.1".equals(ip.getHostAddress())) {
                            arr[0] = ip.getHostAddress();
                            arr[1] = ip.getHostName();
                            break;
                        }
                    }
                }

                return arr;
            }
        } catch (SocketException var5) {
            var5.printStackTrace();
            return arr;
        }
    }

    public static String[] getOSInfo() {
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        return new String[]{osName, osVersion, javaVersion};
    }

    public String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

}
