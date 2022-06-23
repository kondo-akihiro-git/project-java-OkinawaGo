package main.java.com.rhizome.example.service;

// 決まってない部分はnull
import java.util.HashMap;
import java.util.Map;

import main.java.com.rhizome.example.dao.Okinawa_DAO;
import main.java.com.rhizome.example.service.base.BaseService;
import main.java.com.rhizome.example.util.DbUtil;

public class SearchService extends BaseService{

	public SearchService() throws Exception {
		super(true);
	}

	/**
	 * メールアドレス、パスワードでログイン判定を行う
	 */
	public Map<String, Object> doLogin(String mail, String pass) throws Exception {
		Map<String, Object> loginData = new HashMap<>();
		Okinawa_DAO dao = new Okinawa_DAO(this.con);//ログインで入力された情報で取得するDAOが必要
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
	
}



/*
//管理者ログイン機能
public Manager_DTO selectLoginInfo(String mail, String pass) throws SQLException {
		Manager_DTO manager = null;
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT * FROM " + MANAGER_TABLE;
		sql.append(" WHERE" + MANAGER_MAIL +"="+ "?" +"AND"+ MANAGER_PASS + "=" +"?");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		stmt.setString(1, mail);
		stmt.setString(2, pass);

		ResultSet rs = stmt.executeQuery();

		// 主キー検索のため、0件、または1件と想定
		if (rs.next()) {
			manager = rowMappingManager_m(rs);
		}

		// 見つからなかった
		DbUtil.colseStatement();
		return manager;
	}

*/











