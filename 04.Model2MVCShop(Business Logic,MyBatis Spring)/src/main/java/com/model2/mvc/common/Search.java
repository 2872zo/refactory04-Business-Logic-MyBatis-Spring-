package com.model2.mvc.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/*
 * FileName : Search.java
 *   �� Dynamic SQL ������  <foreach> elements �� �̿� �ݺ��� ���������� ���޵Ǵ� 
 *       Collection List , Array ���� ValueObeject  
  */
public class Search {
	///Field
	private String userId;
	private int currentPage;
	private String searchCondition;
	private String searchKeyword;
	private String[] splitKeyword;
	private int pageSize;
	private int sortCode;
	private boolean hiddingEmptyStock;
	private int endRowNum;
	private int startRowNum;
	
	///Constructor
	public Search() {
	}

	///Method
	public int getCurrentPage() {
		return currentPage;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getSortCode() {
		return sortCode;
	}

	public boolean isHiddingEmptyStock() {
		return hiddingEmptyStock;
	}
	
	public String[] getSplitKeyword() {
		return splitKeyword;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
		if(searchKeyword.indexOf(",") != -1) {
			splitKeyword = searchKeyword.split(",");
			Arrays.sort(splitKeyword);
		}
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}

	public void setHiddingEmptyStock(boolean hiddingEmptyStock) {
		this.hiddingEmptyStock = hiddingEmptyStock;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	//==> Select Query �� ROWNUM ������ �� 
	public int getEndRowNum() {
		return getCurrentPage()*getPageSize();
	}
	//==> Select Query �� ROWNUM ���� ��
	public int getStartRowNum() {
		return (getCurrentPage()-1)*getPageSize()+1;
	}

	@Override
	public String toString() {
		return "Search [userId=" + userId + ", currentPage=" + currentPage
				+ ", searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + ", pageSize=" + pageSize
				+ ", sortCode=" + sortCode + ", hiddingEmptyStock=" + hiddingEmptyStock + "]";
	}
	
	
	
}//end of class