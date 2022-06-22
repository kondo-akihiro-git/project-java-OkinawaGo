package com.rhizome.example.userpage;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.apache.coyote.Request;

@WebServlet(name = "comment", urlPatterns = { "/comment" })
public class CommentAction extends BaseServlet {

	protected String doAction() {

		// ユーザー名と投稿内容をデータベースに追加
		String info_id = super.request.getParameter("info_id");
		String comment_id = super.request.getParameter("comment_id");
		String comment_nm = super.request.getParameter("comment_nm");
		String comment_tx = super.request.getParameter("comment_tx");
		String comment_img = super.request.getParameter("comment_img");

		Okinawa_DAO dao = new Okinawa_DAO();
		List<comment_DTO> commentList = dao.CommentInsert(info_id, comment_id, comment_nm, comment_tx, comment_img);

		super.request.setAttribute("commentList", commentList); // リストのままsetAttributeするかどうか放置(06/17)。

		return "detail";
	}
}