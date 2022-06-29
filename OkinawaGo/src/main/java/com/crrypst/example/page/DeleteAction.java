package main.java.com.crrypst.example.page;

import java.sql.Connection;

import javax.servlet.annotation.WebServlet;

import main.java.com.crrypst.example.dao.Okinawa_DAO;
import main.java.com.crrypst.example.page.base.BaseServlet;
import main.java.com.crrypst.example.util.DbUtil;

@WebServlet(name = "delete", urlPatterns = { "/delete" })
public class DeleteAction extends BaseServlet {

	@Override
	protected String getPageName() {

		if (super.request.getParameter("infoDetail") != null) {
			return "adcommentSearch";
		}
		return "adSearch";
	}

	protected String doAction() throws Exception {
		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		// トップページから遷移した時
		if (super.request.getParameter("info_id") != null) {
			String info_id = super.request.getParameter("info_id");
			dao.infoDelete(info_id);

			// コメント検索画面から遷移した時
		} else if (super.request.getParameter("comment_id") != null) {
			String comment_id = super.request.getParameter("comment_id");
			dao.commentDelete(comment_id);

		}
		return "adDelete";
	}
}
