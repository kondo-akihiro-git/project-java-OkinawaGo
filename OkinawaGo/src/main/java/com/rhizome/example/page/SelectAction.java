import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class SelectAction extends BaseServlet {

	@Override
	protected String getPageName() {
		return "adSearch";
	}

	protected String doAction() throws Exception {
		
		if(super.request.getParameter("text") != null) {
			
		String text = super.getInputParameter(
				"text"
				);
		// 検索を行う
				SearchService service = new SearchService();
				List<null> spotInfolist = service.searchInfo(text);
				
		//検索結果の判定
		if (spotInfolist == null || spotInfolist.size() == 0) {
			throw new Exception("入力された条件で情報が見つかりませんでした");
		}
		super.request.setAttribute("spotInfolist", spotInfolist);
		return "adSearch";
		
		//追加画面に遷移
		} else if (super.request.getParameter("insert") != null) {
			
			return "adInsert_Input";
		//詳細画面に遷移
		} else if (super.request.getParameter("detail") != null) {
			
			String[] pageParam = super.getInputParameter(
					"s_g_id"
					, "info_nm" 
					);
			
					Info_DTO info = new Info_DTO();
					info.setS_g_id(pageParam[0]);
					info.setInfo_nm(pageParam[1]);
					
					SearchService service = new SearchService();
					List<null> detailList = service.searchDetailBykey(pageParam[0],pageParam[1]);
					
					super.request.setAttribute("detailList", detailList);
					return "detail";
		}
			
		//コメント管理に遷移	
		}else if(super.request.getParameter("comment")!=null)

	{
			String[] pageParam = super.getInputParameter(
					"s_g_id"
					, "info_nm" 
					
					Info_DTO info = new Info_DTO();
					info.setInfo_DTO(pageParam[0]);
					info.setInfo_DTO(pageParam[1]);
					
					SearchService service = new SearchService();
					List<null> commentList = searchCommentBykey(pageParam[0],pageParam[1]);
					super.request.setAttribute("detailList", detailList);
					return "adcommentSearch";
		}

}