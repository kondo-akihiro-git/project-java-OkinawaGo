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

}




/*
 //MANAGERテーブル
    private static final String MANAGER_TABLE_NAME = "manager_table";
	private static final String MANAGER_ID = "manager_id";
	private static final String MANAGER_NM = "manager_nm";
	private static final String MANAGER_KN = "manager_kn";
	private static final String MANAGER_MAIL = "manager_mail";
	private static final String MANAGER_PASS = "manager_pass";
	private static final String MANAGER_CR_DATE = "cr_date";
	private static final String MANAGER_CR_MANA = "cr_mana";
	private static final String MANAGER_UP_DATE = "up_date";
	private static final String MANAGER_UP_MANA = "up_mana";



//rowMappingメソッド
public Manager_DTO rowMappingManager_m(ResultSet rs) throws SQLException {
		Manager_DTO ManagerD = new Manager_DTO();
		ManagerD.setManager_id(rs.getInt(MANAGER_ID));
		ManagerD.setManager_nm(rs.getString(MANAGER_NM));
		ManagerD.setMANAGER_kn(rs.getString(MANAGER_KN));
		ManagerD.setManager_mail(rs.getString(MANAGER_MAIL));
		ManagerD.setManager_pass(rs.getString(MANAGER_PASS));
		ManagerD.setCr_date(rs.getString(MANAGER_CR_DATE));
		ManagerD.setCr_mana(rs.getInt(MANAGER_CR_MANA));
		ManagerD.setUp_date(rs.getString(MANAGER_UP_DATE));
		ManagerD.setUp_mana(rs.getInt(MANAGER_UP_MANA));
		return InfoD;
	}
//管理者ログイン機能
public Manager_DTO loginInfo(String mail, String pass) throws SQLException {
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

		
		DbUtil.colseStatement();
		return manager;
	}

*/











