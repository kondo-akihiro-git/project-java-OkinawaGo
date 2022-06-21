import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class ShowInfoAction extends BaseServlet {
	//画像から詳細データを取得
	protected String doAction() throws Exception {
		String[] pageParam = super.getInputParameter(
				"info_img"
				,"info_id"
				
				Info_DTO img = new Info_DTO();
		        img.setInfo_img(pageParam[0]);
		        img.setInfo_id(pageParam[1]);
				
				SearchService service = new SearchService();
				
				List<null> imgList = service.searchDetailBykey(pageParam[0],pageParam[1]);
				
				super.request.setAttribute("imgList", imgList);
				
				return "detail";
	}
}