package com.squirrel.dto;

public class ProductListDTO {

//	p_id	varchar2(5 byte)
//	p_pdate	date
//	p_uploaddate	date
//	p_maxpeople	number(1,0)
//	p_hole	number(2,0)
//	p_caddyyn	char(1 byte)
//	p_babyn	char(1 byte)
//	p_cartyn	char(1 byte)
//	p_price	number(10,0)
//	p_content	varchar2(400 char)
//	user_no	number(5,0)
//	cc_id	char(6 byte)
//	p_vcount	number(7,0)
	
	private String p_id;
	private String p_pdate;
	private String p_uploaddate;
	private int p_maxpeople;
	private int p_hole;
	private String p_caddyyn;
	private String p_babyn;
	private String p_cartyn;
	private int p_price;
	private String p_content;
	private int user_no;
	private String cc_id;
	private int p_vcount;
	public ProductListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductListDTO(String p_id, String p_pdate, String p_uploaddate, int p_maxpeople, int p_hole,
			String p_caddyyn, String p_babyn, String p_cartyn, int p_price, String p_content, int user_no, String cc_id,
			int p_vcount) {
		super();
		this.p_id = p_id;
		this.p_pdate = p_pdate;
		this.p_uploaddate = p_uploaddate;
		this.p_maxpeople = p_maxpeople;
		this.p_hole = p_hole;
		this.p_caddyyn = p_caddyyn;
		this.p_babyn = p_babyn;
		this.p_cartyn = p_cartyn;
		this.p_price = p_price;
		this.p_content = p_content;
		this.user_no = user_no;
		this.cc_id = cc_id;
		this.p_vcount = p_vcount;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_pdate() {
		return p_pdate;
	}
	public void setP_pdate(String p_pdate) {
		this.p_pdate = p_pdate;
	}
	public String getP_uploaddate() {
		return p_uploaddate;
	}
	public void setP_uploaddate(String p_uploaddate) {
		this.p_uploaddate = p_uploaddate;
	}
	public int getP_maxpeople() {
		return p_maxpeople;
	}
	public void setP_maxpeople(int p_maxpeople) {
		this.p_maxpeople = p_maxpeople;
	}
	public int getP_hole() {
		return p_hole;
	}
	public void setP_hole(int p_hole) {
		this.p_hole = p_hole;
	}
	public String getP_caddyyn() {
		return p_caddyyn;
	}
	public void setP_caddyyn(String p_caddyyn) {
		this.p_caddyyn = p_caddyyn;
	}
	public String getP_babyn() {
		return p_babyn;
	}
	public void setP_babyn(String p_babyn) {
		this.p_babyn = p_babyn;
	}
	public String getP_cartyn() {
		return p_cartyn;
	}
	public void setP_cartyn(String p_cartyn) {
		this.p_cartyn = p_cartyn;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getCc_id() {
		return cc_id;
	}
	public void setCc_id(String cc_id) {
		this.cc_id = cc_id;
	}
	public int getP_vcount() {
		return p_vcount;
	}
	public void setP_vcount(int p_vcount) {
		this.p_vcount = p_vcount;
	}
	
	
	
}
