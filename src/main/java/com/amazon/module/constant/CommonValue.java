package com.amazon.module.constant;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.8.2 19:04
 * @describe 该类是常量类
 * */
public class CommonValue {
    /*Controller*/
    public static final String UNLOGIN="unLogin";//未登录
    public static final String USER="user";//存储在session中用户信息的属性名
    public static final String TOKEN="token";//token属性名
    public static final String VALID_CODE_ERROR="codeError";//验证码错误
    public static final String VALID_CODE="validateCode";//验证码
    public static final String DESIRED="1";//预期的结果
    public static final String UNDESIRED="0";//非预期的结果
    /*Service*/
    public static final String  PAGE_COUNT_KEY="count";//分页总数的key
    public static final String PAGE_START_KEY="start";//分页开始的行数key
    public static final String PAGE_END_KEY="end";//分页结束的行数key
    public static final String PAGE_PRODUCT_KEY="product";//商品分页的集合key
    public static final String PAGE_CID_KEY="cid";//分页时的分类key
    public static final String PAGE_SEARCH_KEY="search";//分页时的搜索内容key
    public static final String PC_PCID_KEY="pcid";//商品分类中的id key
    public static final String PC_NAME_KEY="name";//商品分类中的名字 key
    public static final String PC_CHILDREN_KEY="children";//商品分类中的子分类 key



    /*----------------------------------------分割线-----------------------------------------*/
    public static final String VALID_CODE_KEY="code";//验证码对象返回的map集合中验证码的键
    public static final String VALID_IMAGE_KEY="image";//验证码对象返回的map集合中验证码图片对象的键
}
