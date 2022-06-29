package main.java.com.crrypst.example.entity;

public class Manager_DTO {
	//管理者ID
	private String manager_id;
	//管理者名
	private String manager_nm;
	//管理者カナ
	private String manager_kn;
	//メールアドレス
	private String manager_mail;
	//パスワード
	private String manager_pass;
	//作成日時
	private String cr_date;
	//作成者ID
	private String cr_mana;
	//更新日時
	private String up_date;
	//更新者ID
	private String up_mana;
	
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_nm() {
		return manager_nm;
	}
	public void setManager_nm(String manager_nm) {
		this.manager_nm = manager_nm;
	}
	public String getManager_kn() {
		return manager_kn;
	}
	public void setManager_kn(String manager_kn) {
		this.manager_kn = manager_kn;
	}
	public String getManager_mail() {
		return manager_mail;
	}
	public void setManager_mail(String manager_mail) {
		this.manager_mail = manager_mail;
	}
	public String getManager_pass() {
		return manager_pass;
	}
	public void setManager_pass(String manager_pass) {
		this.manager_pass = manager_pass;
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
