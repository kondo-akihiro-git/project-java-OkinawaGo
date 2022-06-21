import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "comment", urlPatterns = { "/comment" })
public class CommentAction extends BaseServlet {

	//ユーザー名と投稿内容をデータベースに追加
	
String[] pageParam = super.getInputParameter(
		"comment_nm"
		,"comment_tx"
		."comment_img"
		);
        CommentDTO comment = new Comment_DTO();
        comment.setComment_nm(pageParam[0]);
        comment.setComment_tx(pageParam[1]);
        comment.setComment(pageParam[2]);
        
		UpdateService service = new UpdateService();
		List<comment_DTO> commentList =  service.commentInput(comment);
		
		super.request.setAttribute("commentList", commentList); // リストのままsetAttributeするかどうか放置。
		
		return "detail";
}