package main.java.com.rhizome.example.userpage;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import main.java.com.rhizome.example.dao.Okinawa_DAO;
import main.java.com.rhizome.example.entity.Info_DTO;
import main.java.com.rhizome.example.userpage.base.BaseServlet;
import main.java.com.rhizome.example.util.DbUtil;

@WebServlet(name = "search", urlPatterns = { "/search" })
public class ShowInfoAction extends BaseServlet {
	// 画像から詳細データを取得
	protected String doAction() throws Exception {
		String info_img = super.request.getParameter("info_img");
		String info_id = super.request.getParameter("info_id");

		Connection con = DbUtil.getConnection();
		Okinawa_DAO dao = new Okinawa_DAO(con);
		List<Info_DTO> list = dao.selectByInfoId(info_id);// 画像から詳細データを取得するDAOメソッドが必要

		super.request.setAttribute("info_img", info_img);
		super.request.setAttribute("list", list);

		return "detail";
	}

	@Override
	protected String getPageName() {
		return "search";
	}
}