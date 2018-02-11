package com.amazon.entity;

public class Product {

	
	private long HP_ID;
	private String HP_NAME;
	private String HP_DESCRIPTION;
	private double HP_PRICE;
	private long HP_STOCK;
	private long HPC_ID;
	private long HPC_CHILD_ID;
	private String HP_FILE_NAME;
	public Product(long hP_ID, String hP_NAME, String hP_DESCRIPTION, double hP_PRICE, long hP_STOCK, long hPC_ID,
			long hPC_CHILD_ID, String hP_FILE_NAME) {
		super();
		HP_ID = hP_ID;
		HP_NAME = hP_NAME;
		HP_DESCRIPTION = hP_DESCRIPTION;
		HP_PRICE = hP_PRICE;
		HP_STOCK = hP_STOCK;
		HPC_ID = hPC_ID;
		HPC_CHILD_ID = hPC_CHILD_ID;
		HP_FILE_NAME = hP_FILE_NAME;
	}
	public Product() {
		super();
	}
	public long getHP_ID() {
		return HP_ID;
	}
	public void setHP_ID(long hP_ID) {
		HP_ID = hP_ID;
	}
	public String getHP_NAME() {
		return HP_NAME;
	}
	public void setHP_NAME(String hP_NAME) {
		HP_NAME = hP_NAME;
	}
	public String getHP_DESCRIPTION() {
		return HP_DESCRIPTION;
	}
	public void setHP_DESCRIPTION(String hP_DESCRIPTION) {
		HP_DESCRIPTION = hP_DESCRIPTION;
	}
	public double getHP_PRICE() {
		return HP_PRICE;
	}
	public void setHP_PRICE(double hP_PRICE) {
		HP_PRICE = hP_PRICE;
	}
	public long getHP_STOCK() {
		return HP_STOCK;
	}
	public void setHP_STOCK(long hP_STOCK) {
		HP_STOCK = hP_STOCK;
	}
	public long getHPC_ID() {
		return HPC_ID;
	}
	public void setHPC_ID(long hPC_ID) {
		HPC_ID = hPC_ID;
	}
	public long getHPC_CHILD_ID() {
		return HPC_CHILD_ID;
	}
	public void setHPC_CHILD_ID(long hPC_CHILD_ID) {
		HPC_CHILD_ID = hPC_CHILD_ID;
	}
	public String getHP_FILE_NAME() {
		return HP_FILE_NAME;
	}
	public void setHP_FILE_NAME(String hP_FILE_NAME) {
		HP_FILE_NAME = hP_FILE_NAME;
	}
	@Override
	public String toString() {
		return "Product [HP_ID=" + HP_ID + ", HP_NAME=" + HP_NAME + ", HP_DESCRIPTION=" + HP_DESCRIPTION + ", HP_PRICE="
				+ HP_PRICE + ", HP_STOCK=" + HP_STOCK + ", HPC_ID=" + HPC_ID + ", HPC_CHILD_ID=" + HPC_CHILD_ID
				+ ", HP_FILE_NAME=" + HP_FILE_NAME + "]";
	}
	
	
	
	
}
