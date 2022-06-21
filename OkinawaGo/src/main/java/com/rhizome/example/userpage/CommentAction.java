import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "comment", urlPatterns = { "/comment" })
public class CommentAction extends BaseServlet {

	//ユーザー名と投稿内容をデータベースに追加
	
String[] pageParam = super.getInputParameter(
		"comment_nm"
		,"comment_tx"
		."info_img"
		);
        null comment = new null();
        comment.setnull(pageParam[0]);
        comment.setnull(pageParam[1]);
        comment.setnull(pageParam[2]);
        
		UpdateService service = new UpdateService();
		List<null> commentList =  service.commentInput(comment);
		
		super.request.setAttribute("commentList", commentList); // リストのままsetAttributeするかどうか放置。
		
		return "detail";
}