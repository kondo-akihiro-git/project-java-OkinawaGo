package main.java.com.crrypst.example.userpage;

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

import main.java.com.crrypst.example.dao.Okinawa_DAO;
import main.java.com.crrypst.example.entity.Comment_DTO;
import main.java.com.crrypst.example.entity.Info_DTO;
import main.java.com.crrypst.example.entity.Menu_DTO;
import main.java.com.crrypst.example.userpage.base.BaseUser;
import main.java.com.crrypst.example.util.DbUtil;

@WebServlet(name = "comment", urlPatterns = { "/comment" })
@MultipartConfig
public class CommentAction extends BaseUser {

	@Override
	protected String getPageName() {

		return "detail";
	}

	protected String doPost() throws NumberFormatException, ClassNotFoundException, SQLException, IOException, ServletException {
		
		super.request.setCharacterEncoding("utf-8");
		
		String filename = null;
		String imgcheck = "1";
		Part part = super.request.getPart("comment_img");
		filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

		if(filename.equals("")) {
			imgcheck = "0"; 
		}
		
		if (imgcheck.equals("1")) {
			String path = getServletContext().getRealPath("/upload");
			part.write(path + File.separator + filename);
		}
		// ユーザー名と投稿内容をデータベースに追加
				List<Info_DTO> List = null;
				List<Info_DTO> recom = new ArrayList<>();
				String info_img = super.request.getParameter("info_img");
				String info_id = super.request.getParameter("info_id");
				String area_id = super.request.getParameter("area_id");
				String s_g_id = super.request.getParameter("s_g_id");
				String comment_nm = super.request.getParameter("comment_nm");
				String comment_tx = super.request.getParameter("comment_tx");
				Connection con = DbUtil.getConnection();
				Okinawa_DAO dao = new Okinawa_DAO(con);
				if(imgcheck.equals("1")) {
					dao.CommentInsert(info_id, comment_nm, comment_tx, filename);
				}else if(imgcheck.equals("0")) {
					dao.CommentInsert(info_id, comment_nm, comment_tx, null);
				}
				List = dao.selectByInfoId(info_id);
				
				List<Comment_DTO> commentList = dao.selectComment(info_id);
				List<Menu_DTO> priceList = dao.selectByPrice(info_id);
				
				ShowInfoAction showinfo = new ShowInfoAction();
				recom = showinfo.getRecommendlist(area_id,s_g_id);
				
				super.request.setAttribute("list", List);
				super.request.setAttribute("commentList", commentList);
				super.request.setAttribute("info_id", info_id);
				super.request.setAttribute("info_img", info_img);
				super.request.setAttribute("s_g_id", s_g_id);
				super.request.setAttribute("area_id", area_id);
				super.request.setAttribute("recomlist", recom);
				if(s_g_id.equals("2")){
					super.request.setAttribute("pricelist", priceList);
				}else if(s_g_id.equals("1")) {
				}
				return "detail";
	}
}