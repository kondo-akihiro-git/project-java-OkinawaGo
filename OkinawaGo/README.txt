
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
	