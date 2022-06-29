
package main.java.com.crrypst.example.page;

import java.sql.Connection;

import javax.servlet.annotation.WebServlet;

import main.java.com.crrypst.example.dao.Okinawa_DAO;
import main.java.com.crrypst.example.page.base.BaseServlet;
import main.java.com.crrypst.example.util.DbUtil;

@WebServlet(name = "addinfo", urlPatterns = { "/addinfo" })
public class AddInfoAction extends BaseServlet {
	protected String getPageName() {
		return "insertConfirm";
	}

	protected String doAction() throws Exception {

		// グルメかスポットのラジオボタンを取得
		String s_g_id1 = super.request.getParameter("s_g_id");
		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		// スポットの追加
		if (s_g_id1.equals("1")) {
			String[] paramList = super.getInputParameter(
					  "s_g_id"  // 0
					, "info_nm" // 1
					, "area_id" // 2
					, "post_code" // 3 //掲載情報テーブル修正後再度確認
					, "address" // 4
					, "info_img" // 5
			);

			dao.spotInsert(paramList[0], paramList[1], paramList[2], paramList[4], paramList[3], paramList[5], (String)super.session.getAttribute("LOGIN_Manager_id"));

			// グルメ追加
		} else if (s_g_id1.equals("2")) {
			String[] cateList = super.request.getParameterValues("cateList");
			String[] paramList = super.getInputParameter(
					  "s_g_id"  // 0
					, "info_nm" // 1
					, "area_id" // 2
					, "post_code" // 3 //掲載情報テーブル修正後再度確認
					, "address" // 4
					, "info_img" // 5
			);
			
			dao.InfoInsert(paramList[0], paramList[1], paramList[2], paramList[4], paramList[3], paramList[5], (String)super.session.getAttribute("LOGIN_Manager_id"),cateList);
		}

		return "adInsert";
	}
}
