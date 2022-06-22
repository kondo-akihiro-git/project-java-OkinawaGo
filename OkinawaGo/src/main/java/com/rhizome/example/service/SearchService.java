package main.java.com.rhizome.example.service;

// 決まってない部分はnull
import java.util.HashMap;
import java.util.List;

import main.java.com.rhizome.example.service.base.BaseService;

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
	 * 管理者トップ画面からスポット・グルメ詳細ページに飛ぶ-------------------------------------------------------------------
	 *　カテゴリーIDとスポット・グルメ名から詳細情報を取得するDAOメソッドをどうするか(06/22)。
	 */
	
	//下のメソッドが必要かどうか要確認(06/22)
	public List<Info_DTO> searchDetailBykey(Integer cateId, String name) throws Exception {
		Okinawa_DAO dao = new Okinawa_DAO(this.con);
		List<Info_DTO> AllList = null; // メソッドの戻り値のデータ型がわかっていません…ごめんなさい(06/20)。
		List<Info_DTO> list = null;
		try {
			AllList = dao.selectAll(); // カテゴリーIDはInfo_mテーブルに含まれていないため対策案検討中(06/22)
			for(int i = 0; AllList>i; i++) {
			if(AllList.get(i).contains(cateId) && AllList.get(i).contains(name)) {
				list.add(AllList.get(i));
			}
			list = dao.findDetailByIdName(cateId, name); // カテゴリーIDと名前からスポット詳細情報を取得
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}
}　