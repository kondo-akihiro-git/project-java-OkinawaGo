package main.java.com.crrypst.example.page;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import main.java.com.crrypst.example.dao.Okinawa_DAO;
import main.java.com.crrypst.example.entity.Manager_DTO;
import main.java.com.crrypst.example.page.base.BaseServlet;
import main.java.com.crrypst.example.util.DbUtil;

@WebServlet(name="login", urlPatterns={"/login"})
public class LoginAction extends BaseServlet {

	@Override
	protected String getPageName() {
		return "adLogin";
	}

	@Override
	protected String doAction() throws Exception {
		// 画面入力項目の取得
		String[] param = super.getInputParameter("mail", "pass");
		// ログイン処理
		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		List<Manager_DTO> loginData = dao.loginInfo(param[0], param[1]);
		for(Manager_DTO login : loginData) {
			super.session.setAttribute("LOGIN_Manager_nm", login.getManager_nm());
			super.session.setAttribute("LOGIN_Manager_id", login.getManager_id());
		}
		// 結果の取得（検索結果0件）
		if (loginData == null || loginData.size() == 0) {
			// ポップアップの表示方法不明
			String message = "メールアドレスまたはパスワードが間違っています";
			throw new Exception("メールアドレスまたはパスワードが間違っています");
			//request.setAttribute("alertMsg", message);
		}

		super.session.setAttribute("LOGIN_Manager", loginData);
		return "adSearch";
		
	}
}