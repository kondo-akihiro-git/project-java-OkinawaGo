import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "select", urlPatterns = { "/select" })
public class CommentAction extends BaseServlet {

	//ユーザー名と投稿内容をデータベースに追加
String[] pageParam = super.getInputParameter(
		"comment_nm"
		,"comment_tx"
		
		null info = new null;
		info.set null(pageParam[0]);
		info.set null(pageParam[1]);
		
		UpdateService service = new UpdateService();
		List<null> commentList =  service.commentInput(pageParam[0],pageParam[1]);
		
		super.request.setAttribute("commentList", commentList);
		
		return "search";
}