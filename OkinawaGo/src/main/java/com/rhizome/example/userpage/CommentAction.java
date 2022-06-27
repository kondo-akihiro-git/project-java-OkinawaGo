package main.java.com.rhizome.example.userpage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

import main.java.com.rhizome.example.dao.Okinawa_DAO;
import main.java.com.rhizome.example.entity.Comment_DTO;
import main.java.com.rhizome.example.entity.Info_DTO;
import main.java.com.rhizome.example.userpage.base.BaseUser;
import main.java.com.rhizome.example.util.DbUtil;

@WebServlet(name = "comment", urlPatterns = { "/comment" })
@MultipartConfig
public class CommentAction extends BaseUser {

	@Override
	protected String getPageName() {

		return "detail";
	}

	protected String doPost() throws NumberFormatException, ClassNotFoundException, SQLException, IOException, ServletException {
		super.request.setCharacterEncoding("utf-8");
		Part part=super.request.getPart("comment_img");
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String path=getServletContext().getRealPath("/upload");
		part.write(path+File.separator+filename);
		System.out.println("2");
		
		
		// ユーザー名と投稿内容をデータベースに追加
				List<Info_DTO> List = null;
				List<Info_DTO> recom = new ArrayList<>();
				String info_img = super.request.getParameter("info_img");
				String info_id = super.request.getParameter("info_id");
				String area_id = super.request.getParameter("area_id");
				String s_g_id = super.request.getParameter("s_g_id");
				String comment_nm = super.request.getParameter("comment_nm");
				String comment_tx = super.request.getParameter("comment_tx");
				//String comment_img = super.request.getParameter("comment_img");
				Connection con = DbUtil.getConnection();
				Okinawa_DAO dao = new Okinawa_DAO(con);
				if(filename.length() != 0) {
					dao.CommentInsert(info_id, comment_nm, comment_tx, filename);
				}else if(filename.length() == 0) {
					dao.CommentInsert(info_id, comment_nm, comment_tx, null);
				}
				List = dao.selectByInfoId(info_id);
//				for(Info_DTO kis:List) {
//					System.out.println("list"+kis.getInfo_nm());
//				}
				List<Comment_DTO> commentList = dao.selectComment(info_id);
//				for(Comment_DTO ki:commentList) {
//					System.out.println("recom"+ki.getComment_tx());
//				}
				
				
				ShowInfoAction showinfo = new ShowInfoAction();
				recom = showinfo.getRecommendlist(area_id,s_g_id);
//				for(Info_DTO ki:recom) {
//					System.out.println("recom"+ki.getInfo_nm());
//				}
				

				super.request.setAttribute("list", List);
				super.request.setAttribute("commentList", commentList);
				super.request.setAttribute("info_id", info_id);
				super.request.setAttribute("info_img", info_img);
				super.request.setAttribute("s_g_id", s_g_id);
				super.request.setAttribute("area_id", area_id);
				super.request.setAttribute("recomlist", recom);
				return "detail";
	}
	
	
	
	/*protected String doAction() throws NumberFormatException, ClassNotFoundException, SQLException, IOException, ServletException {
		
		
		
		// ユーザー名と投稿内容をデータベースに追加
		List<Info_DTO> List = null;
		List<Info_DTO> recom = new ArrayList<>();
		String info_img = super.request.getParameter("info_img");
		String info_id = super.request.getParameter("info_id");
		String area_id = super.request.getParameter("area_id");
		String s_g_id = super.request.getParameter("s_g_id");
		String comment_nm = super.request.getParameter("comment_nm");
		String comment_tx = super.request.getParameter("comment_tx");
		String comment_img = super.request.getParameter("comment_img");
		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		if(comment_img.length() != 0) {
			dao.CommentInsert(info_id, comment_nm, comment_tx, comment_img);
		}else if(comment_img.length() == 0) {
			dao.CommentInsert(info_id, comment_nm, comment_tx, null);
		}
		List = dao.selectByInfoId(info_id);
//		for(Info_DTO kis:List) {
//			System.out.println("list"+kis.getInfo_nm());
//		}
		List<Comment_DTO> commentList = dao.selectComment(info_id);
//		for(Comment_DTO ki:commentList) {
//			System.out.println("recom"+ki.getComment_tx());
//		}
		
		
		ShowInfoAction showinfo = new ShowInfoAction();
		recom = showinfo.getRecommendlist(area_id,s_g_id);
//		for(Info_DTO ki:recom) {
//			System.out.println("recom"+ki.getInfo_nm());
//		}
		

		super.request.setAttribute("list", List);
		super.request.setAttribute("commentList", commentList);
		super.request.setAttribute("info_id", info_id);
		super.request.setAttribute("info_img", info_img);
		super.request.setAttribute("s_g_id", s_g_id);
		super.request.setAttribute("area_id", area_id);
		super.request.setAttribute("recomlist", recom);
		return "detail";
	}*/

}