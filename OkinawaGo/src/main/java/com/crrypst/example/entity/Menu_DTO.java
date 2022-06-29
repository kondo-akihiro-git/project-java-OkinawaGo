package main.java.com.crrypst.example.entity;


public class Menu_DTO {
	//情報ID
	private String info_id;
	private String menu_id;
	private String price_nm;
	private String price;
	//作成日時
	private String cr_date;
	//作成者ID
	private String cr_mana_id;
	//更新日時
	private String up_date;
	//更新者ID
	private String up_mana_id;
	
	
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getPrice_nm() {
		return price_nm;
	}
	public void setPrice_nm(String price_nm) {
		this.price_nm = price_nm;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCr_date() {
		return cr_date;
	}
	public void setCr_date(String cr_date) {
		this.cr_date = cr_date;
	}
	public String getCr_mana_id() {
		return cr_mana_id;
	}
	public void setCr_mana_id(String cr_mana_id) {
		this.cr_mana_id = cr_mana_id;
	}
	public String getUp_date() {
		return up_date;
	}
	public void setUp_date(String up_date) {
		this.up_date = up_date;
	}
	public String getUp_mana_id() {
		return up_mana_id;
	}
	public void setUp_mana_id(String up_mana_id) {
		this.up_mana_id = up_mana_id;
	}

}
