package com.rhizome.example.service;

// 決まってない部分はnull
import java.util.HashMap;
import java.util.List;

public class SearchService extends BaseService(){

	public SearchService() throws Exception {
		super(true);
	}

	/**
	 * メールアドレス、パスワードでログイン判定を行う
	 */
	public Map<String, Object> doLogin(String mail, String pass) throws Exception {
		Map<String, Object> loginData = new HashMap<>();
		Manager_DAO dao = new Manager_DAO(this.con);
		try {
			loginData.put("LOGIN", dao.loginInfo(mail, pass));// mailとpassからログイン
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return loginData;
	}

	/**
	 * 管理者トップでフリーワードによるスポット・グルメ検索を行う---------------------------------------------------------------------------------
	 */
	public List<Info_DTO> searchInfo(String huri_wa_do) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		List<Info_DTO> list = null;
		try {
			list = dao.selectByFreeWord(huri_wa_do)); //入力された値で条件検索
			if (list.size() == 0) {
				list = null;
			}
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}

	/**
	 * 管理者トップ画面からスポット・グルメ詳細ページに飛ぶ-------------------------------------------------------------------
	 *　カテゴリーIDとスポット・グルメ名から詳細情報を取得するDAOメソッドをどうするか(06/22)。
	 */
	public List<Info_DTO> searchDetailBykey(Integer cateId, String name) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		List<Info_DTO> AllList = null; // メソッドの戻り値のデータ型がわかっていません…ごめんなさい(06/20)。
		List<Info_DTO> list = null;
		try {
			AllList = dao.selectAll(); // カテゴリーIDはInfo_mテーブルに含まれていないため対策案検討中(06/22)
			while(AllList.contains(cateId) && AllList.contains(name)) {
				list.add(AllList);
			}
			list = dao.findDetailByIdName(cateId, name); // カテゴリーIDと名前からスポット詳細情報を取得
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}

	/*
	 * ユーザー検索画面からスポット・グルメ詳細ページに飛ぶ---------------------------------------------------
	 * 選択された写真から詳細情報を取得するDAOメソッドをどうするか(06/22)
	 * 
	 */
	public List<Info_DTO> searchDetailBykey(String info_id) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		Info_DTO list = null; // メソッドの戻り値のデータ型がわかっていません…ごめんなさい(06/20)。
		try {
			list = dao.selectByInfoId(info_id); // カテゴリーIDと名前からグルメ詳細情報を取得
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}

	/**
	 * 管理者トップ画面からコメント一覧ページに遷移-------------------------------------------------------------------
	 */

	public List<Comment_DTO> searchCommentBykey(String info_id) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		List<Comment_DTO> list = null;
		try {
			list = dao.selectComment(info_id); // カテゴリーIDと名前からコメント一覧を取得
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}

	/**
	 * ユーザー側でのグルメ検索画面からカテゴリー検索後、検索結果画面に遷移-------------------------------------------------------------------
	 */
	public List<Info_DTO> conditionalSearch(Integer area_id, String[] checkedbox) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		List<Info_DTO> list = null;
		try {
			list = dao.GurumeSelect(area_id, checkbox); //地域IDとチェックボックスからスポット・グルメの一覧を取得
		}finnaly {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}

}　