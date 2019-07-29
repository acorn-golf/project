package com.squirrel.dto;

public class MemberDTO {
//	user_no	number(5,0)
//	phone_id	varchar2(15 byte)
//	userpw	varchar2(20 char)s
//	username	varchar2(4 char)s
//	nickname	varchar2(10 char)
//	userssn	varchar2(6 byte)
//	gender	char(1 byte)
//	rating	varchar2(3 char)
//	rstartdate	date
//	renddate	date
//	email	varchar2(30 byte)
//	email_chk	char(1 byte)

	private int user_no;
	private String phone_id;
	private String userpw;
	private String username;
	private String nickname;
	private String userssn;
	private String gender;
	private String rating;
	private String rstartdate;
	private String renddate;
	private String email;
	private String email_chk;

	public MemberDTO(int user_no, String phone_id, String userpw, String username, String nickname, String userssn,
			String gender, String rating, String rstartdate, String renddate, String email, String email_chk) {
		super();
		this.user_no = user_no;
		this.phone_id = phone_id;
		this.userpw = userpw;
		this.username = username;
		this.nickname = nickname;
		this.userssn = userssn;
		this.gender = gender;
		this.rating = rating;
		this.rstartdate = rstartdate;
		this.renddate = renddate;
		this.email = email;
		this.email_chk = email_chk;
	}

	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String phone_id, String userpw, String username, String nickname, String userssn,
			String gender, String email) {
		this.phone_id = phone_id;
		this.userpw = userpw;
		this.username = username;
		this.nickname = nickname;
		this.userssn = userssn;
		this.gender = gender;
		this.email = email;
		// TODO Auto-generated constructor stub
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(String phone_id) {
		this.phone_id = phone_id;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserssn() {
		return userssn;
	}

	public void setUserssn(String userssn) {
		this.userssn = userssn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRstartdate() {
		return rstartdate;
	}

	public void setRstartdate(String rstartdate) {
		this.rstartdate = rstartdate;
	}

	public String getRenddate() {
		return renddate;
	}

	public void setRenddate(String renddate) {
		this.renddate = renddate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_chk() {
		return email_chk;
	}

	public void setEmail_chk(String email_chk) {
		this.email_chk = email_chk;
	}

}
