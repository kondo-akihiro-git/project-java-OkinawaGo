

import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "delete", urlPatterns = { "/delete" })
public class DeleteAction extends BaseServlet {

	@Override
	protected String getPageName() {
		
		if (super.request.getParameter("infoDetail") != null) {
		return "adcommentSearch";
		} else if (super.request.getParameter("commntDelete") != null) {
		return("adSearch")
		}
	}

	@Override
	protected String doAction() throws Exception {
		
		//トップページから遷移した時
		if (super.request.getParameter("infoDelete") != null) {
		String info_id = super.getParameter("info_id"); 
				
				Okinawa_DAO dao = new Okinawa_DAO();
				dao.infoDelete(info_id);
				
		//コメント検索画面から遷移した時		
		} else if (super.request.getParameter("commentDelete") != null) {
		String comment_id = super.getParameter("comment_id");
				
				Okinawa_DAO dao = new Okinawa_DAO();
				dao.commentDelete(comment_id);
				
		}
		return "adDelete";
		}
}
