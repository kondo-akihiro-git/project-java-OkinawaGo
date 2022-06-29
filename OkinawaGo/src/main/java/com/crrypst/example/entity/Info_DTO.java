package main.java.com.crrypst.example.entity;


public class Info_DTO {
	//情報ID
	private String info_id;
	//スポット・グルメID
	private String s_g_id;
	//名
	private String info_nm;
	//地域ID
	private String area_id;
	//郵便番号
	private String post_code;
	//住所
	private String address;
	//写真
	private String info_img;
	//作成日時
	private String cr_date;
	//作成者
	private String cr_mana;
	//更新日
	private String up_date;
	//更新者
	private String up_mana;
	
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	public String getS_g_id() {
		return s_g_id;
	}
	public void setS_g_id(String s_g_id) {
		this.s_g_id = s_g_id;
	}
	public String getInfo_nm() {
		return info_nm;
	}
	public void setInfo_nm(String info_nm) {
		this.info_nm = info_nm;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInfo_img() {
		return info_img;
	}
	public void setInfo_img(String string) {
		this.info_img = string;
	}
	public String getCr_date() {
		return cr_date;
	}
	public void setCr_date(String cr_date) {
		this.cr_date = cr_date;
	}
	public String getCr_mana() {
		return cr_mana;
	}
	public void setCr_mana(String cr_mana) {
		this.cr_mana = cr_mana;
	}
	public String getUp_date() {
		return up_date;
	}
	public void setUp_date(String up_date) {
		this.up_date = up_date;
	}
	public String getUp_mana() {
		return up_mana;
	}
	public void setUp_mana(String up_mana) {
		this.up_mana = up_mana;
	}

}
