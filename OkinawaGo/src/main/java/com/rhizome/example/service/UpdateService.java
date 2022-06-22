// 決まっていない部分はnull

package com.rhizome.example.service;

import java.util.ArrayList;

public class UpdateService extends BaseService {

	public UpdateService() throws Exception {
		super(false);
	}

	/**
	 * 管理者側でスポットの登録を行う--------------------------------------------------------------------------
	 */
public int registerSpot(Info_DTO info) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		int count = -1;
				try{
					count = dao.insertSpot(info);
					this.con.comit();
					} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
				}finally {
					DbUtil.closeConnection(this.con);
				}
				return count;
}
/**
	 * 管理者側でグルメの登録を行う------------------------------------------------------------------------------
	 */
public int registerGou(Info_DTO info) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		int count = -1;
				try{
					count = dao.insertGou(info);
					this.con.comit();
					} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
				}finally {
					DbUtil.closeConnection(this.con);
				}
				return count;
}
	/**
	 * スポット・グルメ情報の削除--------------------------------------------------------------------
	 */

	public int deleteInfo(Integer id) throws Exception { // 削除するスポット・グルメのIDを引数とする
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.infoDelete(id);
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("削除できませんでした:" + e.getMessage());
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return deleteCount;
	}
	
	/**
	 * コメントの削除---------------------------------------------------------------------------
	 */

	public int deleteComment(Integer id) throws Exception { // 削除するコメントが所属するスポット・グルメのIDを引数とする
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.commentDelete(id);
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("削除できませんでした:" + e.getMessage());
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return deleteCount;
	}
	/*
	 * コメントとユーザー投稿の追加-------------------------------------------------------------
	 */
	public int commentInput(String info_id, String comment_id, String comment_nm, String comment_tx, String comment_img) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		int count = -1;
				try{
					count = dao.empInsert(info_id, comment_id, comment_nm, comment_tx, comment_img);
					this.con.comit();
					} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
				}finally {
					DbUtil.closeConnection(this.con);
				}
				return count;
}
