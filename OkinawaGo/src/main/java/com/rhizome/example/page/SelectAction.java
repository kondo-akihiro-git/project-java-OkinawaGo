import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class SelectAction extends BaseServlet {

	@Override
	protected String getPageName() {
		return "select";
	}
	
	protected String doAction() throws Exception {
		
		if(super.request.getParameter("text") != null) {
			
		String text = super.request.getParameter("text");
		
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
			String 
		}
		//削除完了画面に遷移
		} else if(super.request.getParameter("delete") != null) {
			
		}
		
	}