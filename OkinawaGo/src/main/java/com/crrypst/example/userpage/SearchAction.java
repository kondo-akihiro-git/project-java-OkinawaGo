package main.java.com.crrypst.example.userpage;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import main.java.com.crrypst.example.dao.Okinawa_DAO;
import main.java.com.crrypst.example.entity.Info_DTO;
import main.java.com.crrypst.example.entity.Info_id_img_DTO;
import main.java.com.crrypst.example.userpage.base.BaseUser;
import main.java.com.crrypst.example.util.DbUtil;

@WebServlet(name = "search", urlPatterns = { "/search" })
public class SearchAction extends BaseUser {

	public String doPost() throws Exception {
		String text;
		String value;
		String area_nm;
		String[] cate_nm;
		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		List<Info_DTO> infolist = null;
		String name = "search";

//検索トップ画面からフリーワードで検索した場合-------------------------------------------------------------
		if (super.request.getParameter("toptext") != null) {
			text = super.request.getParameter("toptext");
			infolist = dao.selectByFreeWord(text);

			if (infolist == null || infolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			super.request.setAttribute("text", text);
			super.request.setAttribute("infolist", infolist);
			super.request.setAttribute("check", "1");
			return name;
		}

//スポット検索画面からフリーワードで検索した場合------------------------------------------------------------
		if (super.request.getParameter("spottext") != null) {
			text = super.request.getParameter("spottext");
			infolist = dao.selectByFreeWord(text);
			if (infolist == null || infolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			super.request.setAttribute("check", "1");
			super.request.setAttribute("text", text);
			super.request.setAttribute("infolist", infolist);
			return name;
//スポット検索画面のマップで検索した場合
		} else if (super.request.getParameter("spotmap") != null && super.request.getParameter("s_g_id").equals("1")) {
			value = super.request.getParameter("spotmap");
			area_nm = dao.searcharea_nm(value);
			infolist = dao.selectByArea(value);
			if (infolist == null || infolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			for(Info_DTO list : infolist) {
				super.request.setAttribute("check", list.getS_g_id());
			}
			super.request.setAttribute("area_nm", area_nm);
			super.request.setAttribute("infolist", infolist);
			return name;
		}
//グルメ検索画面からフリーワードで検索した場合--------------------------------------------------------------
		if (super.request.getParameter("goutext") != null) {

			text = super.request.getParameter("goutext");
			infolist = dao.selectByFreeWord(text);

			if (infolist == null || infolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			super.request.setAttribute("check", "1");
			super.request.setAttribute("text", text);
			super.request.setAttribute("infolist", infolist);
			return name;
//グルメ検索画面からカテゴリー検索した場合
		} else if (super.request.getParameter("category") != null) {
			String[] list = null;
			String id = super.request.getParameter("id"); // ラジオボタンでチェックされた値を取得
			list = super.request.getParameterValues("category"); // チェックボックスの値を配列で取得 //チェックボックスでチェックされた値を取得
			area_nm = dao.searcharea_nm(id);
			cate_nm = getCategoryNm(list);
			List<Info_id_img_DTO> List = null;
			List = dao.GurumeSelect(id, list);
			if (List == null || List.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			for(Info_id_img_DTO list_sg :  List ) {
				super.request.setAttribute("check", list_sg.getS_g_id());
			}
			super.request.setAttribute("infolist", List);
			super.request.setAttribute("area_nm", area_nm);
			super.request.setAttribute("cate_nm", cate_nm);
			return name;
//グルメ検索画面からエリアのみで検索した場合
		}else if(super.request.getParameter("category") == null && super.request.getParameter("s_g_id").equals("2")) {													//"s_g_id"がnullエラー
			String id = super.request.getParameter("id");
			area_nm = dao.searcharea_nm(id);
			List<Info_id_img_DTO> List = null;
			List = dao.InfoSelectAll(id);
			if (List == null || List.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			for(Info_id_img_DTO list_sg :  List ) {
				super.request.setAttribute("check", list_sg.getS_g_id());
			}
			super.request.setAttribute("infolist", List);
			super.request.setAttribute("area_nm", area_nm);		
		}

		return name;
	}

	public String[] getCategoryNm(String[] list) {
		String[] rtnArray = new String[7];
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals("1")) {
				rtnArray[i] = "レストラン";
			} else if (list[i].equals("2")) {
				rtnArray[i] = "カフェ";
			} else if (list[i].equals("3")) {
				rtnArray[i] = "居酒屋";
			} else if (list[i].equals("4")) {
				rtnArray[i] = "ランチ";
			} else if (list[i].equals("5")) {
				rtnArray[i] = "ディナー";
			} else if (list[i].equals("6")) {
				rtnArray[i] = "沖縄料理";
			} else if (list[i].equals("7")) {
				rtnArray[i] = "スイーツ";
			}
		}
		return rtnArray;
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