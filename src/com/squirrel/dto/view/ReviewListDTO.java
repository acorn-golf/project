package com.squirrel.dto.view;

public class ReviewListDTO {
	private String cc_name;
	private int score;
	private String rv_title;
	private String nickname;
	private String score_date;
	
	public ReviewListDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewListDTO(String cc_name, int score, String rv_title, String nickname, String score_date) {
		super();
		this.cc_name = cc_name;
		this.score = score;
		this.rv_title = rv_title;
		this.nickname = nickname;
		this.score_date = score_date;
	}

	public String getCc_name() {
		return cc_name;
	}

	public void setCc_name(String cc_name) {
		this.cc_name = cc_name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRv_title() {
		return rv_title;
	}

	public void setRv_title(String rv_title) {
		this.rv_title = rv_title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getScore_date() {
		return score_date;
	}

	public void setScore_date(String score_date) {
		this.score_date = score_date;
	}

	@Override
	public String toString() {
		return "ReviewList [cc_name=" + cc_name + ", score=" + score + ", rv_title=" + rv_title + ", nickname="
				+ nickname + ", score_date=" + score_date + "]";
	}
	
	
}
