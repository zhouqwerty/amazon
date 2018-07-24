package com.amazon.base.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.24 18:58
 * @describe 辅助类 中国数字解析
 * */
public class ChineseNumParser {
    private static final Map<String, Integer> CHINESE_ARABIC_NUMBER_MAP = new HashMap<String, Integer>() {
        {
            this.put("零", Integer.valueOf(0));
            this.put("一", Integer.valueOf(1));
            this.put("二", Integer.valueOf(2));
            this.put("三", Integer.valueOf(3));
            this.put("四", Integer.valueOf(4));
            this.put("五", Integer.valueOf(5));
            this.put("六", Integer.valueOf(6));
            this.put("七", Integer.valueOf(7));
            this.put("八", Integer.valueOf(8));
            this.put("九", Integer.valueOf(9));
        }
    };

    public ChineseNumParser() {
    }

    public static String getArabicByChinese(String chineseNum) {
        return CHINESE_ARABIC_NUMBER_MAP.containsKey(chineseNum) ? ((Integer)CHINESE_ARABIC_NUMBER_MAP.get(chineseNum)).toString() : "";
    }
}
