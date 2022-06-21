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
				
				Info_DTO info = new InfoDTO();
				info.setS_g_id(pageParam[0]));
				info.setInfo_nm(pageParam[1]);
				
				UpdateService service = new UpdateService();
				service.deleteInfo(pageParam[0],pageParam[1]);
				
		//コメント検索画面から遷移された時		
		} else if (super.request.getParameter("commentDelete") != null) {
				"comment_nm"
				,"comment_tx"
				
				Comment_DTO comment = new Comment_DTO();
				comment.setComment_nm(pageParam[0]);
				comment.setComment_tx(pageParam[1]);
				
				UpdateService service = new UpdateService();
				service.deleteComment(pageParam[0],pageParam[1]);
				
		}
		return "adDelete";
		}
}
