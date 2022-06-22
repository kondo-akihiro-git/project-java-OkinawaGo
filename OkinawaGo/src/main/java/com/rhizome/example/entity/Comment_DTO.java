package main.java.com.rhizome.example.entity;


public class Comment_DTO {
	//コメントID
	private int comment_id;
	//情報ID
	private int info_id;
	//コメント者名
	private String comment_nm;
	//コメント本文
	private String comment_tx;
	//写真
	private String comment_img;
	//作成日時
	private int cr_date;
	//作成者ID
	private int cr_mana_id;
	//更新日時
	private String up_date;
	//更新者ID
	private int up_mana_id;
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	public String getComment_nm() {
		return comment_nm;
	}
	public void setComment_nm(String comment_nm) {
		this.comment_nm = comment_nm;
	}
	public String getComment_tx() {
		return comment_tx;
	}
	public void setComment_tx(String comment_tx) {
		this.comment_tx = comment_tx;
	}
	public String getComment_img() {
		return comment_img;
	}
	public void setComment_img(String comment_img) {
		this.comment_img = comment_img;
	}
	public int getCr_date() {
		return cr_date;
	}
	public void setCr_date(int cr_date) {
		this.cr_date = cr_date;
	}
	public int getCr_mana_id() {
		return cr_mana_id;
	}
	public void setCr_mana_id(int cr_mana_id) {
		this.cr_mana_id = cr_mana_id;
	}
	public String getUp_date() {
		return up_date;
	}
	public void setUp_date(String up_date) {
		this.up_date = up_date;
	}
	public int getUp_mana_id() {
		return up_mana_id;
	}
	public void setUp_mana_id(int up_mana_id) {
		this.up_mana_id = up_mana_id;
	}
}
