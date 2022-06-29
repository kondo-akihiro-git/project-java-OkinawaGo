package main.java.com.crrypst.example.entity;


public class Info_id_img_DTO {
	//情報ID
	private String info_id;
	//写真
	private String info_img;
	//スポット・グルメID
	private String s_g_id;
	//地域ID
	private String area_id;

	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	
	public String getInfo_img() {
		return info_img;
	}
	public void setInfo_img(String string) {
		this.info_img = string;
	}
	public String getS_g_id() {
		return s_g_id;
	}
	public void setS_g_id(String s_g_id) {
		this.s_g_id = s_g_id;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
}
