package com.squirrel.dto;

public class CcScoreDTO {
//	score_no	number(5,0)
//	score	number(1,0)
//	cc_id	char(6 byte)
//	score_date	date
//	user_no	number(5,0)
//	rv_no	varchar2(5 byte)
	
	private int score_no;
	private int score;
	private String cc_id;
	private String score_date;
	private int user_no;
	private String rv_no;
	
	public CcScoreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CcScoreDTO(int score_no, int score, String cc_id, String score_date, int user_no, String rv_no) {
		super();
		this.score_no = score_no;
		this.score = score;
		this.cc_id = cc_id;
		this.score_date = score_date;
		this.user_no = user_no;
		this.rv_no = rv_no;
	}



	public int getScore_no() {
		return score_no;
	}

	public void setScore_no(int score_no) {
		this.score_no = score_no;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getCc_id() {
		return cc_id;
	}

	public void setCc_id(String cc_id) {
		this.cc_id = cc_id;
	}

	public String getScore_date() {
		return score_date;
	}

	public void setScore_date(String score_date) {
		this.score_date = score_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getRv_no() {
		return rv_no;
	}

	public void setRv_no(String rv_no) {
		this.rv_no = rv_no;
	}
	
	
	
}
