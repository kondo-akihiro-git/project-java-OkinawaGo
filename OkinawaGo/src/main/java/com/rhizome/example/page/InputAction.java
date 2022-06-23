
package main.java.com.rhizome.example.page;

import javax.servlet.annotation.WebServlet;

import main.java.com.rhizome.example.page.base.BaseServlet;


@WebServlet(name = "input", urlPatterns = { "/input" })
public class InputAction extends BaseServlet {

	protected String doAction() throws Exception {

//スポットかグルメか判断
		String cate = super.request.getParameter("cate");

//スポット------------------------------------------------------------------------------
		if (cate.equals("スポット")) {
			String[] paramList = super.getInputParameter("info_nm" // 0
					, "area_id" // 1
					, "post" // 2 //掲載情報テーブル修正後再度確認
					, "address" // 3
					, "info_img" // 4
			);
			super.request.setAttribute("cate", cate);
			super.request.setAttribute("info_nm", paramList[0]);
			super.request.setAttribute("area_id", paramList[1]);
			super.request.setAttribute("post", paramList[2]);
			super.request.setAttribute("address", paramList[3]);
			super.request.setAttribute("info_img", paramList[4]);
//グルメ----------------------------------------------------------------------------
		} else if (cate.equals("グルメ")) {
			String[] paramList = super.getInputParameter("info_nm" // 0
					, "area_id" // 1
					, "post" // 2 //掲載情報テーブル修正後再度確認
					, "address" // 3
					, "category_id" // 4
					, "info_img" // 5
			);
			super.request.setAttribute("cate", cate);
			super.request.setAttribute("info_nm", paramList[0]);
			super.request.setAttribute("area_id", paramList[1]);
			super.request.setAttribute("post", paramList[2]);
			super.request.setAttribute("address", paramList[3]);
			super.request.setAttribute("category_id", paramList[4]);
			super.request.setAttribute("info_img", paramList[5]);
		}

//クリックされたname属性がbackの場合、adInsert_input.jspに遷移、それ以外の場合adInsertConfirmに遷移--------
		if (super.request.getParameter("back") != null) {
			return "adInsert_input.jsp";
		} else {
			return "adInsertConfirm";
		}
	}

	@Override
	protected String getPageName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
