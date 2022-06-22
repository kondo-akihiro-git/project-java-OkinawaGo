
package com.rhizome.example.page;

import javax.servlet.annotation.WebServlet;

import com.rhizome.example.entity.Employee;
import com.rhizome.example.page.base.BaseServlet;
import com.rhizome.example.service.UpdateService;
import com.rhizome.example.service.UpdateService.UPDATE_MODE;

@WebServlet(name = "addinfo", urlPatterns = { "/addinfo" })
public class AddInfoAction extends BaseServlet {
	@Override
	protected String getPageName() {
		return "insertConfirm";
	}

	@Override
	protected String doAction() throws Exception {

		// グルメかスポットのラジオボタンを取得
		String name = super.request.getParamert("name");
		Okinawa_DAO dao = new Okinawa_DAO();
		
		//スポットの追加
		if (name.equals("スポット")) {
			int s_g_id = super.request.getParamert("s_g_id");
			String info_nm = super.request.getParamert("info_nm");
			int area_id = super.request.getParameter("area_id");
			String address = super.request.getParameter("address");
			String post_cord = super.request.getParameter("post_cord");
			String info_img = super.request.getParameter("info_img");
			String cr_mana = super.request.getParameter("cr_mana");
		
			dao.empInsert(s_g_id,info_nm,area_id,address,post_cord,info_img,cr_mana);
			
		// グルメ追加
		} else if (name.equals("グルメ")) {
			int s_g_id = super.request.getParamert("s_g_id");
			String info_nm = super.request.getParamert("info_nm");
			int area_id = super.request.getParameter("area_id");
			String address = super.request.getParameter("address");
			String post_cord = super.request.getParameter("post_cord");
			String info_img = super.request.getParameter("info_img");
			String cr_mana = super.request.getParameter("cr_mana");
			String[] cateList = super.request.getParameter("cateList");

			
			dao.InfoInsert(s_g_id, info_nm, area_id, address, post_cord, info_img, cr_mana, cateList);

		}

		return "adInsert";
	}
}
