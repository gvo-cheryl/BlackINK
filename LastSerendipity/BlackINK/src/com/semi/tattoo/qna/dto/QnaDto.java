package com.semi.tattoo.qna.dto;

import java.sql.Date;

public class QnaDto {
	
	private int no;
	private int me;
	private int groupno;
	private int groupseq;
	private int titletab;
	private String title;
	private String writer;
	private String content;
	private String img;
	private int readcount;
	private String regdate;
	private String delflag;
	private String category;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public QnaDto() {

	}

	public QnaDto(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public QnaDto(int no, String title, String content) {
		this.no = no;
		this.title = title;
		this.content = content;
	}

	public QnaDto(String title, String content, String img) {
		this.title = title;
		this.content = content;
		this.img = img;

	}

	public QnaDto(int no, String title, String writer, String content) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public QnaDto(String title, String content, String img, int me) {
		this.title = title;
		this.content = content;
		this.img = img;
		this.me = me;
	}

	public QnaDto(String writer, String title, String content, String img, int me) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.img = img;
		this.me = me;
	}

	public QnaDto(int no, String title, String writer, String content, int me) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.me = me;

	}

	public QnaDto(int no, int me, int groupno, int groupseq, int titletab, String title, String writer, String content,
			String img, int readcount, String regdate, String delflag) {

		this.no = no;
		this.me = me;
		this.groupno = groupno;
		this.groupseq = groupseq;
		this.titletab = titletab;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.img = img;
		this.readcount = readcount;
		this.regdate = regdate;
		this.delflag = delflag;
	}

	public QnaDto(int no, int me, int groupno, int groupseq, int titletab, String title, String writer, String content,
			String img, int readcount, String regdate, String delflag, String category) {

		this.no = no;
		this.me = me;
		this.groupno = groupno;
		this.groupseq = groupseq;
		this.titletab = titletab;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.img = img;
		this.readcount = readcount;
		this.regdate = regdate;
		this.delflag = delflag;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getMe() {
		return me;
	}

	public void setMe(int me) {
		this.me = me;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getGroupseq() {
		return groupseq;
	}

	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}

	public int getTitletab() {
		return titletab;
	}

	public void setTitletab(int titletab) {
		this.titletab = titletab;
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

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
}