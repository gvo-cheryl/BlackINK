package com.semi.tattoo.review.dto;

import java.util.Date;

public class ReviewDto {
		private int no;
		private String writer;
		private String title;
		private String content;
		private String img;
		private Date regdate;
		private int readcount;
		private String filename;
		private int titletab;
		private String delflag;
		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}
		private int step;
	
		public ReviewDto() {
			//기본 생성자 입니다
		}
		
		public ReviewDto(String title, String content) {
			this.title = title;
			this.content = content;
			
		}
		
		public ReviewDto(int no, String title, String content) {
			this.no = no;
			this.title = title;
			this.content = content;
		}
		
		public ReviewDto (String title, String writer, String content, String img) {
			this.title = title;
			this.writer = writer;
			this.content = content;
			this.img = img;
		}
		
		public ReviewDto(int no, String writer, String title, String content, Date regdate, int readcount, String filename, int titletab, String delflag, int step) {
			this.no = no;
			this.writer = writer;
			this.title = title;
			this.content = content;
			this.regdate = regdate;
			this.readcount = readcount;
			this.filename = filename;
			this.titletab = titletab;
			this.delflag = delflag;
			this.step = step;
		}
		
		public int getStep() {
			return step;
		}

		public void setStep(int step) {
			this.step = step;
		}
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
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
		public Date getRegdate() {
			return regdate;
		}
		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}
		public int getReadcount() {
			return readcount;
		}
		public void setReadcount(int readcount) {
			this.readcount = readcount;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		public int getTitletab() {
			return titletab;
		}
		public void setTitletab(int titletab) {
			this.titletab = titletab;
		}
		public String getDelflag() {
			return delflag;
		}
		public void setDelflag(String delflag) {
			this.delflag = delflag;
		}
}
