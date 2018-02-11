package com.amazon.entity;

import java.util.ArrayList;
import java.util.List;
public class Pager {
	
	public static final int PAGE_RECORD = 12;//每页展示的商品的数量
	public static final int GROUP_RECORD = 5;//下边导航栏的数量
	private int currentPage;	// 当前页码
	private int totalPage;		// 总页数
	private int recordCount;	// 总记录数
	private int currentGroup;// 当前组数
	private int hpc_id;
	private String qname;
	private String source;
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getHpc_id() {
		return hpc_id;
	}

	public void setHpc_id(int hpc_id) {
		this.hpc_id = hpc_id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public static int getPageRecord() {
		return PAGE_RECORD;
	}

	public static int getGroupRecord() {
		return GROUP_RECORD;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setCurrentGroup(int currentGroup) {
		this.currentGroup = currentGroup;
	}

	public void setGroupList(List<Integer> groupList) {
		this.groupList = groupList;
	}

	private List<Integer> groupList;//页面中需要的分组页索引
	// 构造方法
	public Pager(int page){
		currentPage = page;
	}
	
	//获取当前页页码
	public int getCurrentPage(){
		return currentPage;
	}
	
	
	public int getStart(){
		return (getCurrentPage() - 1) * Pager.PAGE_RECORD;
	}
	public int getEnd(){
		return  getStart() + Pager.PAGE_RECORD;
	}
	// 获取下一页页码
	public int getNextPage(){
		if(currentPage < totalPage)
			return currentPage+1;
		else
			return totalPage;
	}
	// 获取上一页页码
	public int getPrevPage(){
		if(currentPage <= 1)
			return 1;
		else
			return currentPage - 1;
	}
	
	//  获取当前组数
	public int getCurrentGroup(){
		return currentGroup;
	}
	
	public List<Integer> getGroupList(){
		// 计算当前组数
		currentGroup = (int)Math.ceil((float)currentPage / GROUP_RECORD);
		groupList = new ArrayList<Integer>();
		int start = (currentGroup-1) * GROUP_RECORD;
		int end = (start + GROUP_RECORD) < totalPage ? start + GROUP_RECORD : totalPage;
		for (int i = start + 1; i <= end; i++) {
			groupList.add(i);
		}
		return groupList;
	}
/*//	select t.* from(select rownum as r, table_goods.* from table_goods)t where t.r > start and t.r <=end
	1
	2
	3
	4
	5
	
	上  1*5 2*5 3*5 4*5 下一页*/
	
	
	
	
	
	
	// 获取总页数
	public int getPageCount(){
		return totalPage;
	}
	
	// 设置总记录数
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		totalPage = (int)Math.ceil(((float)recordCount / PAGE_RECORD));
	}
	
	// 获取总记录数
	public int getRecordCount() {
		return recordCount;
	}

	
}
