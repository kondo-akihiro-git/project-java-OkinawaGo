
package main.java.com.rhizome.example.page;

import javax.servlet.annotation.WebServlet;

import main.java.com.rhizome.example.dao.Okinawa_DAO;
import main.java.com.rhizome.example.page.base.BaseServlet;

@WebServlet(name = "addinfo", urlPatterns = { "/addinfo" })
public class AddInfoAction extends BaseServlet {
	protected String getPageName() {
		return "insertConfirm";
	}

	protected String doAction() throws Exception {

		// グルメかスポットのラジオボタンを取得
		String name = super.request.getParameter("name");
		Okinawa_DAO dao = new Okinawa_DAO(null);
		
		//スポットの追加
		if (name.equals("スポット")) {
			String s_g_id = super.request.getParameter("s_g_id");
			String info_nm = super.request.getParameter("info_nm");
			String area_id = super.request.getParameter("area_id");
			String address = super.request.getParameter("address");
			String post_cord = super.request.getParameter("post_cord");
			String info_img = super.request.getParameter("info_img");
			String cr_mana = super.request.getParameter("cr_mana");
		
			dao.empInsert(s_g_id,info_nm,area_id,address,post_cord,info_img,cr_mana);
			
		// グルメ追加
		} else if (name.equals("グルメ")) {
			String s_g_id = super.request.getParameter("s_g_id");
			String info_nm = super.request.getParameter("info_nm");
			String area_id = super.request.getParameter("area_id");
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
