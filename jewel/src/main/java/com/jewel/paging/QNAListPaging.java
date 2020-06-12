package com.jewel.paging;

import org.springframework.stereotype.Component;

@Component(value = "qnaListPaging")
public class QNAListPaging {
	private int currentPage;//현재페이지
	private int pageBlock;//[이전][][][다음]
	private int pageSize;//1페이지에 12개씩
	private int totalList;//총글수
	private StringBuffer pagingHTML;
	private String path;
	public void makePagingHTML() {
		pagingHTML=new StringBuffer();
		int totalP=(totalList+pageSize-1)/pageSize;
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		if(endPage>totalP)endPage=totalP;
		pagingHTML.append("<ul class='pagination' style='justify-content: center;'>");
		if(startPage>pageBlock)
			pagingHTML.append("<li class='page-item'><a class='page-link' href='"+path+"/qna/qnalist?pg="+(startPage-1)+"'>이전</a></li>");
		
		for(int i=startPage;i<=endPage;i++) {
			if(i==currentPage) {
				pagingHTML.append("<li class='page-item active'><a class='page-link' href='"+path+"/qna/qnalist?pg="+i+"'>"+i+"</a></li>");
			}else {
				pagingHTML.append("<li class='page-item'><a class='page-link' href='"+path+"/qna/qnalist?pg="+i+"'>"+i+"</a></li>");
			}
			
			
		}
		
		if(endPage<totalP) {
			pagingHTML.append("<li class='page-item'><a class='page-link' href='"+path+"/qna/qnalist?pg="+(endPage+1)+"'>다음</a></li>");
		}
		pagingHTML.append("</ul>");
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String pg) {
		this.currentPage = Integer.parseInt(pg);
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalList() {
		return totalList;
	}
	public void setTotalList(int totalList) {
		this.totalList = totalList;
	}
	public StringBuffer getPagingHTML() {
		return pagingHTML;
	}
	public void setPagingHTML(StringBuffer pagingHTML) {
		this.pagingHTML = pagingHTML;
	}

	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

	/* setter & getter */
	
	
}
