package main.java.com.rhizome.example.userpage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import main.java.com.rhizome.example.dao.Okinawa_DAO;
import main.java.com.rhizome.example.entity.Comment_DTO;
import main.java.com.rhizome.example.entity.Info_DTO;
import main.java.com.rhizome.example.userpage.base.BaseUser;
import main.java.com.rhizome.example.util.DbUtil;

@WebServlet(name = "showinfo", urlPatterns = { "/showinfo" })
public class ShowInfoAction extends BaseUser {
	// 画像から詳細データを取得
	protected String doPost() throws Exception {
		List<Info_DTO> recom = new ArrayList<>();
		String info_img = super.request.getParameter("info_img");
		String info_id = super.request.getParameter("info_id");
		String s_g_id = super.request.getParameter("s_g_id");
		String area_id = super.request.getParameter("area_id");

		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		List<Info_DTO> list = dao.selectByInfoId(info_id);// 画像から詳細データを取得するDAOメソッドが必要
		List<Comment_DTO> commentList = dao.selectComment(info_id);
		recom = getRecommendlist(area_id , s_g_id);
		super.request.setAttribute("info_id", info_id);
		super.request.setAttribute("info_img", info_img);
		super.request.setAttribute("list", list);
		super.request.setAttribute("commentList", commentList);
		super.request.setAttribute("s_g_id", s_g_id );
		super.request.setAttribute("area_id", area_id );
		super.request.setAttribute("recomlist", recom);
		return "detail";
	}
	
	public List<Info_DTO> getRecommendlist(String area_id,String s_g_id) throws NumberFormatException, ClassNotFoundException, SQLException {
		List<Info_DTO>infolist = new ArrayList<>();
		List<Info_DTO> recom = new ArrayList<>();
		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		if(s_g_id.equals("1")) {
			infolist = dao.selectGulumeByArea(area_id);
		}else if(s_g_id.equals("2")) {
			infolist = dao.selectByArea(area_id);
		}
		Collections.shuffle(infolist);
		for(int i= 0; i <3; i++) {
			recom.add(infolist.get(i));
    	}

//		for(Info_DTO ki:recom) {
//			System.out.println("show_recom"+ki.getInfo_nm());
//		}
		return recom;
	}

	@Override
	protected String getPageName() {
		return "search";
	}
}