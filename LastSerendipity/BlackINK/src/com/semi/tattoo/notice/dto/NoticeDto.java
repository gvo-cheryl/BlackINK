package com.semi.tattoo.notice.dto;

public class NoticeDto {

	private int no;
	private String writer;
	private String title;
	private String content;
	private int view;
	private String regdate;
	
	public NoticeDto() {
		// 기본 생성자입니다.
	}
	
	public NoticeDto(int no, String title, String content) {
		this.no = no;
		this.title = title;
		this.content = content;
	}
	
	public NoticeDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public NoticeDto(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public NoticeDto(int no, String writer, String title, String content, int view, String regdate) {
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.view = view;
		this.regdate = regdate;
		// 5개 생성자.
	}
	
	
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getNo() {
		return this.no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
	
	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
