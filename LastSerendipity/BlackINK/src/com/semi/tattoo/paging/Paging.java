package com.semi.tattoo.paging;

public class Paging {

	private int total;
	private int curPage;
	private int totalPage;
	private int startPage;
	private int endPage;


	public Paging (int total, int curPage) {
		
		this.total = total;
		this.curPage = curPage;
		
		int countList = 10; // 한 페이지당 보일 게시물 수 : countList
		int countPage = 5; // 한 페이지당 보일 페이지 갯수 5개 = 1,2,3,4,5
		
		totalPage = total / countList; // 전체 개시글에 따른 페이지의 총 갯수(1,2,3,,,) : totalPage
		if(total%countList > 0){ // 나눴을때 나머지가 있다면 +1
			totalPage++;
		}
		
		
		startPage = ((curPage - 1) / 10) * 10 + 1;  // countPage중 첫번째 
		endPage = startPage + countPage - 1;  // countPage중 마지막
		if(totalPage < endPage){
			endPage = totalPage;
		}
	}
	
	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public int getCurPage() {
		return curPage;
	}



	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}



	public int getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public int getStartPage() {
		return startPage;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public int getEndPage() {
		return endPage;
	}



	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}
