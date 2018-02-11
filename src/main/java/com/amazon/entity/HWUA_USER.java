package com.amazon.entity;


import java.util.Date;

public class HWUA_USER {
	
	private long HU_USER_ID;	//用户id
	private String HU_USER_NAME; //用户名
	private String HU_PASSWORD; //密码
	private String HU_SEX;		//性别
	private Date HU_BIRTHDAY;//时间
	private String HU_IDENTITY_CODE;//身份证号
	private String HU_EMAIL;		//电子邮件
	private String HU_MOBILE;		//电话
	private String HU_ADDRESS;		//地址
	private int HU_STATUS;			//状态
	private String sex;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String HU_SEX) {
		if(HU_SEX.equals("男")){
			this.sex = "0";
		}else{
			this.sex = "1";
		}
		
	}
	public long getHU_USER_ID() {
		return HU_USER_ID;
	}
	public void setHU_USER_ID(long hU_USER_ID) {
		HU_USER_ID = hU_USER_ID;
	}
	public String getHU_USER_NAME() {
		return HU_USER_NAME;
	}
	public void setHU_USER_NAME(String hU_USER_NAME) {
		HU_USER_NAME = hU_USER_NAME;
	}
	public String getHU_PASSWORD() {
		return HU_PASSWORD;
	}
	public void setHU_PASSWORD(String hU_PASSWORD) {
		HU_PASSWORD = hU_PASSWORD;
	}
	public String getHU_SEX() {
		return HU_SEX;
	}
	public void setHU_SEX(String hU_SEX) {
		HU_SEX = hU_SEX;
	}
	
	public Date getHU_BIRTHDAY() {
		return HU_BIRTHDAY;
	}
	public void setHU_BIRTHDAY(Date hU_BIRTHDAY) {
		HU_BIRTHDAY = hU_BIRTHDAY;
	}
	public String getHU_IDENTITY_CODE() {
		return HU_IDENTITY_CODE;
	}
	public void setHU_IDENTITY_CODE(String hU_IDENTITY_CODE) {
		HU_IDENTITY_CODE = hU_IDENTITY_CODE;
	}
	public String getHU_EMAIL() {
		return HU_EMAIL;
	}
	public void setHU_EMAIL(String hU_EMAIL) {
		HU_EMAIL = hU_EMAIL;
	}
	public String getHU_MOBILE() {
		return HU_MOBILE;
	}
	public void setHU_MOBILE(String hU_MOBILE) {
		HU_MOBILE = hU_MOBILE;
	}
	public String getHU_ADDRESS() {
		return HU_ADDRESS;
	}
	public void setHU_ADDRESS(String hU_ADDRESS) {
		HU_ADDRESS = hU_ADDRESS;
	}
	public int getHU_STATUS() {
		return HU_STATUS;
	}
	public void setHU_STATUS(int hU_STATUS) {
		HU_STATUS = hU_STATUS;
	}
	public HWUA_USER(long hU_USER_ID, String hU_USER_NAME, String hU_PASSWORD, String hU_SEX, Date hU_BIRTHDAY,
			String hU_IDENTITY_CODE, String hU_EMAIL, String hU_MOBILE, String hU_ADDRESS, int hU_STATUS) {
		super();
		HU_USER_ID = hU_USER_ID;
		HU_USER_NAME = hU_USER_NAME;
		HU_PASSWORD = hU_PASSWORD;
		HU_SEX = hU_SEX;
		HU_BIRTHDAY = hU_BIRTHDAY;
		HU_IDENTITY_CODE = hU_IDENTITY_CODE;
		HU_EMAIL = hU_EMAIL;
		HU_MOBILE = hU_MOBILE;
		HU_ADDRESS = hU_ADDRESS;
		HU_STATUS = hU_STATUS;
	}
	public HWUA_USER() {
		super();
	}
	@Override
	public String toString() {
		return "HWUA_USER [HU_USER_ID=" + HU_USER_ID + ", HU_USER_NAME=" + HU_USER_NAME + ", HU_PASSWORD=" + HU_PASSWORD
				+ ", HU_SEX=" + HU_SEX + ", HU_BIRTHDAY=" + HU_BIRTHDAY + ", HU_IDENTITY_CODE=" + HU_IDENTITY_CODE
				+ ", HU_EMAIL=" + HU_EMAIL + ", HU_MOBILE=" + HU_MOBILE + ", HU_ADDRESS=" + HU_ADDRESS + ", HU_STATUS="
				+ HU_STATUS + "]";
	}
	public HWUA_USER(String hU_USER_NAME, String hU_PASSWORD, String hU_SEX, Date hU_BIRTHDAY, String hU_IDENTITY_CODE,
			String hU_EMAIL, String hU_MOBILE, String hU_ADDRESS, int hU_STATUS) {
		super();
		HU_USER_NAME = hU_USER_NAME;
		HU_PASSWORD = hU_PASSWORD;
		HU_SEX = hU_SEX;
		HU_BIRTHDAY = hU_BIRTHDAY;
		HU_IDENTITY_CODE = hU_IDENTITY_CODE;
		HU_EMAIL = hU_EMAIL;
		HU_MOBILE = hU_MOBILE;
		HU_ADDRESS = hU_ADDRESS;
		HU_STATUS = hU_STATUS;
	}
	
	
	
	
}
