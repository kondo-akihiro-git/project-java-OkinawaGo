import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class ShowInfoAction extends BaseServlet {
	
	protected String doAction() throws Exception {
		String pageParam = super.getInputParameter(
				"info_img"
				
				null null = new null
				null.set null(pageParam);
				
				SearchService service = new SearchService();
				List<null> imgList = searchDetailBykey(pageParam);
				
				super.request.setAttribute("imgList", imgList);
				return "detail";
	}
}