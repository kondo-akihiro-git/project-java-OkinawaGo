import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class ShowInfoAction extends BaseServlet {
	//画像から詳細データを取得
	protected String doAction() throws Exception {
		String[] pageParam = super.getInputParameter(
				"info_img"
				,"info_id"
				
				 null img = new null();
		        img.setnull(pageParam[0]);
		        img.setnull(pageParam[1]);
				
				SearchService service = new SearchService();
				
				List<null> imgList = service.searchDetailBykey(pageParam[0],pageParam[1]);
				
				super.request.setAttribute("imgList", imgList);
				
				return "detail";
	}
}