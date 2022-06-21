import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class CommentAction extends BaseServlet {

String[] pageParam = super.getInputParameter(
		"comment_nm"
		,"comment_tx"
		
		null null = new null
		null.set null(pageParam[0]);
		null.set null(pageParam[1]);
		
		UpdateService service = new UpdateService();
		List<null> commentList =  service.commentInput(pageParam[0],pageParam[1]);
		
		super.request.setAttribute("commentList", commentList);
		
		return "search";
}