package main.java.com.crrypst.example.page;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import main.java.com.crrypst.example.dao.Manager_DAO;
import main.java.com.crrypst.example.dao.Okinawa_DAO;
import main.java.com.crrypst.example.entity.Comment_DTO;
import main.java.com.crrypst.example.entity.Info_DTO;
import main.java.com.crrypst.example.page.base.BaseServlet;
import main.java.com.crrypst.example.util.DbUtil;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class SelectAction extends BaseServlet {

	protected String getPageName() {
		return "adSearch";
	}

	protected String doAction() throws Exception {

		Connection con = DbUtil.getConnection();
		Manager_DAO dao = new Manager_DAO(con);
		if (super.request.getParameter("text") != null) {

			String text = super.request.getParameter("text");
			// フリーワード検索を行う

			List<Info_DTO> spotInfolist = dao.managerFreeWord(text);//
			
			// 検索結果の判定
			if (spotInfolist == null || spotInfolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			super.request.setAttribute("spotInfolist", spotInfolist);
			return "adSearch";
		}
			// 詳細ボタン押下後、詳細画面に遷移
//		} else if (super.request.getParameter("detail") != null) {
//
//			String info_id = super.request.getParameter("info_id");
//
//			List<Info_DTO> detailList = dao.selectByInfoId(info_id);
//
//			super.request.setAttribute("detailList", detailList);
//			return "detail";
//		}

		// コメント管理に遷移
		else if (super.request.getParameter("info_id") != null)

		{
			Okinawa_DAO dao1 = new Okinawa_DAO(con);
			String info_id = super.request.getParameter("info_id");
			
			List<Info_DTO> list = dao1.selectByInfoId(info_id);
			List<Comment_DTO> commentList = dao1.selectComment(info_id);
			

			
			super.request.setAttribute("commentList", commentList);
			super.request.setAttribute("list", list);
			return "adcommentSearch";
		}
		return getPageName();

	}
}