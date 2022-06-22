package com.rhizome.example.page;

import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class SelectAction extends BaseServlet {

	@Override
	protected String getPageName() {
		return "adSearch";
	}

	protected String doAction() throws Exception {

		Okinawa_DAO dao = new Okinawa_DAO();

		if (super.request.getParameter("text") != null) {

			String text = super.request.getParameter("text");
			// 検索を行う

			List<Info_DTO> spotInfolist = dao.selectByFreeWord("text");

			// 検索結果の判定
			if (spotInfolist == null || spotInfolist.size() == 0) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
			super.request.setAttribute("spotInfolist", spotInfolist);
			return "adSearch";
 
			// 詳細画面に遷移
		} else if (super.request.getParameter("detail") != null) {

			String info_id = super.request.getParameter("info_id");

			List<Info_DTO> detailList = dao.selectByInfoId(info_id);

			super.request.setAttribute("detailList", detailList);
			return "detail";
		}

		// コメント管理に遷移
		else if (super.request.getParameter("comment") != null)

		{
			String info_id = super.request.getParameter("info_id");

			List<Comment_DTO> commentList = dao.selectComment(info_id);
			
			super.request.setAttribute("detailList", detailList);
			return "adcommentSearch";
		}

	}
}