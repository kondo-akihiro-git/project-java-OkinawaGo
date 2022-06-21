import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "delete", urlPatterns = { "/delete" })
public class DeleteAction extends BaseServlet {

	@Override
	protected String getPageName() {
		
		if (super.request.getParameter("detail") != null) {
		return "adcommentSearch";
		} else if (super.request.getParameter("commntDelete") != null) {
		return("adSearch")
		}
	}

	@Override
	protected String doAction() throws Exception {
		
		//トップページから遷移した時
		if (super.request.getParameter("delete") != null) {
		String[] pageParam = super.getInputParameter(
				"s_g_id"
				, "info_nm" 
				
				null del = new null
				null.set null(Integer.parseInt(pageParam[0]));
				null.set null(pageParam[1]);
				
				UpdateService service = new UpdateService();
				List<null> deleteList =  service.deleteInfo(pageParam[0],pageParam[1]);
				
				super.request.setAttribute("deleteList", delitelList);
				
		//コメント検索画面から遷移された時		
		} else if (super.request.getParameter("commentDelete") != null) {
				"comment_nm"
				,"comment_tx"
				
				null com = new null
				null.set null(pageParam[0]);
				null.set null(pageParam[1]);
				
				UpdateService service = new UpdateService();
				List<null> commnetList =  service.deleteComment(pageParam[0],pageParam[1]);
				
				super.request.setAttribute("commentList", commentList);
				
		}
		return "adDelete";
		}
}
