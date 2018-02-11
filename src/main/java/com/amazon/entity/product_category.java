package com.amazon.entity;

public class product_category {
	
	private long HPC_ID;	//商品类别id
	private String HPC_NAME; //类别名称
	private long HPC_PARENT_ID; //
	public long getHPC_ID() {
		return HPC_ID;
	}
	public void setHPC_ID(long hPC_ID) {
		HPC_ID = hPC_ID;
	}
	public String getHPC_NAME() {
		return HPC_NAME;
	}
	public void setHPC_NAME(String hPC_NAME) {
		HPC_NAME = hPC_NAME;
	}
	public long getHPC_PARENT_ID() {
		return HPC_PARENT_ID;
	}
	public void setHPC_PARENT_ID(long hPC_PARENT_ID) {
		HPC_PARENT_ID = hPC_PARENT_ID;
	}
	public product_category(long hPC_ID, String hPC_NAME, long hPC_PARENT_ID) {
		super();
		HPC_ID = hPC_ID;
		HPC_NAME = hPC_NAME;
		HPC_PARENT_ID = hPC_PARENT_ID;
	}
	public product_category() {
		super();
	}
	@Override
	public String toString() {
		return "product_category [HPC_ID=" + HPC_ID + ", HPC_NAME=" + HPC_NAME + ", HPC_PARENT_ID=" + HPC_PARENT_ID
				+ "]";
	}
	
	
}
