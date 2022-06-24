package main.java.com.rhizome.example.userpage;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import main.java.com.rhizome.example.dao.Okinawa_DAO;
import main.java.com.rhizome.example.entity.Info_DTO;
import main.java.com.rhizome.example.entity.Info_id_img_DTO;
import main.java.com.rhizome.example.page.base.BaseServlet;
import main.java.com.rhizome.example.util.DbUtil;

@WebServlet(name = "search", urlPatterns = { "/search" })
public class SearchAction extends BaseServlet {

	public String doAction() throws Exception {

		String text;
		String value;
		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		List<Info_DTO> infolist = null;

//検索トップ画面からフリーワードで検索した場合-------------------------------------------------------------
		if (super.request.getParameter("toptext") != null) {
			text = super.request.getParameter("toptext");

			infolist = dao.selectByFreeWord(text);
			super.request.setAttribute("text", text);
			if (infolist == null || infolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
		}

//スポット検索画面からフリーワードで検索した場合------------------------------------------------------------
		if (super.request.getParameter("spottext") != null) {
			text = super.request.getParameter("spottext");
			infolist = dao.selectByFreeWord(text);
			super.request.setAttribute("text", text);
			if (infolist == null || infolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
//スポット検索画面のマップで検索した場合
		} else if (super.request.getParameter("spotmap") != null) {
			value = super.request.getParameter("spotmap");
			infolist = dao.selectByArea(value);
			super.request.setAttribute("map_id", value);
			if (infolist == null || infolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
		}
//グルメ検索画面からフリーワードで検索した場合--------------------------------------------------------------
		if (super.request.getParameter("goutext") != null) {

			text = super.request.getParameter("goutext");
			infolist = dao.selectByFreeWord(text);
			super.request.setAttribute("text", text);
			if (infolist == null || infolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
//グルメ検索画面からカテゴリー検索した場合
		} else if (super.request.getParameter("category") != null) {
			String[] list = null;
			String id = super.request.getParameter("id"); // ラジオボタンでチェックされた値を取得
			list = super.request.getParameterValues("category"); // チェックボックスの値を配列で取得 //チェックボックスでチェックされた値を取得
			List<Info_id_img_DTO> List = null;
			List = dao.GurumeSelect(id, list);
			if (List == null || List.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			super.request.setAttribute("infolist", List);
			super.request.setAttribute("list", list);
			super.request.setAttribute("id", id);
		}

		super.request.setAttribute("infolist", infolist);
		return "search";
	}

	@Override
	protected String getPageName() {
		if (super.request.getParameter("toptext") != null) {
			return "index";
		} else if (super.request.getParameter("spotmap") != null || super.request.getParameter("spottext") != null) {
			return "searchSpo";
		}

		return "searchGul";
	}
}