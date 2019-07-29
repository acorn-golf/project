package com.squirrel.dto;

public class ReCommentDTO {

	
//	re_no	number(5,0)
//	re_date	date
//	re_content	varchar2(100 char)
//	rv_no	varchar2(5 byte)
//	user_no	number(5,0)
	
	private int re_no;
	private String re_date;
	private String re_content;
	private int rv_no;
	private int user_no;
	public ReCommentDTO(int re_no, String re_date, String re_content, int rv_no, int user_no) {
		super();
		this.re_no = re_no;
		this.re_date = re_date;
		this.re_content = re_content;
		this.rv_no = rv_no;
		this.user_no = user_no;
	}
	public ReCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public int getRv_no() {
		return rv_no;
	}
	public void setRv_no(int rv_no) {
		this.rv_no = rv_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
	
}
