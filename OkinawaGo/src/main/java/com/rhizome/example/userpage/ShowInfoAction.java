import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "search", urlPatterns = { "/search" })
public class ShowInfoAction extends BaseServlet {
	//画像から詳細データを取得
	protected String doAction() throws Exception {
		String info_img = super.request.getParameter("info_img");
		String info_id = super.request.getParameter("info_id");
				
				Okinawa_DAO dao = new Okinawa_DAO(this.con);
				List<null> list = dao.findDetailByIdName(info_img, info_id);//画像から詳細データを取得するDAOメソッドが必要
				
				super.request.setAttribute("list", list);
				
				return "detail";
	}
}