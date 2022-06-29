
package main.java.com.crrypst.example.page;

import javax.servlet.annotation.WebServlet;

import main.java.com.crrypst.example.page.base.BaseServlet;


@WebServlet(name = "input", urlPatterns = { "/input" })
public class InputAction extends BaseServlet {
	@Override
	protected String getPageName() {
		return "adInsert_Input";
	}

	protected String doAction() throws Exception {

//スポットかグルメか判断
		String s_g_id = super.request.getParameter("s_g_id");

//スポット------------------------------------------------------------------------------
		if (s_g_id.equals("1")) {
			
			String[] paramList = super.getInputParameter(
					  "s_g_id"  // 0
					, "info_nm" // 1
					, "area_id" // 2
					, "post_code" // 3 //掲載情報テーブル修正後再度確認
					, "address" // 4
					, "info_img" // 5
			);
//
//グルメ----------------------------------------------------------------------------
		} else if (s_g_id.equals("2")) {
			String[] paramList = super.getInputParameter(
					  "s_g_id"  // 0
					, "info_nm" // 1
					, "area_id" // 2
					, "post_code" // 3 //掲載情報テーブル修正後再度確認
					, "address" // 4
					, "info_img" // 5
			);
			
			
			String[] cateList = super.request.getParameterValues("category_id"); 
			request.setAttribute("cateList", cateList);		
			}
			
//クリックされたname属性がbackの場合、adInsert_input.jspに遷移、それ以外の場合adInsertConfirmに遷移--------
		if (super.request.getParameter("back") != null) {
			return "adInsert_input.jsp";
		} else {
			return "adInsertConfirm";
		}
	}


}
