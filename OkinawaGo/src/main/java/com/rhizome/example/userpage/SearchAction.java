

import java.util.List;

import javax.servlet.annotation.WebServlet;

import main.java.com.rhizome.example.dao.Okinawa_DAO;
import main.java.com.rhizome.example.page.base.BaseServlet;

@WebServlet(name = "search", urlPatterns = { "/search" })
public class SearchAction extends BaseServlet {

	public String doAction() {

String text;
String value;
Okinawa_DAO dao = new Okinawa_DAO();
List<Info_DTO> infolist = null;

//検索トップ画面からフリーワードで検索した場合-------------------------------------------------------------
if (super.request.getParameter("toptext") != null) {
	text = super.request.getParameter("text");
	infolist = dao.selectByFreeWord(text);
}

//スポット検索画面からフリーワードで検索した場合------------------------------------------------------------
if(super.request.getParameter("spottext") != null) {
	text = super.request.getParameter("text");
	infolist = dao.selectByFreeWord(text);
	
//スポット検索画面のマップで検索した場合
}else if (super.request.getParameter("spotmap") != null) {
	value = super.request.getParameter("spotmap");
	infolist = dao.selectByArea(value);
}
//グルメ検索画面からフリーワードで検索した場合--------------------------------------------------------------
	if(super.request.getParameter("goutext")!=null){
		
		text = super.request.getParameter("area");
		infolist = dao.selectByFreeWord(text);

//グルメ検索画面からカテゴリー検索した場合
	}else if(super.request.getParameter("map_category") !=null)
	{
		String[] list = null;
		String id = super.request.getParameter("id"); // ラジオボタンでチェックされた値を取得
		if (super.request.getParameter("gou_category") != null)) {
			list = super.request.getParameterValues("checkbox"); // チェックボックスの値を配列で取得 //チェックボックスでチェックされた値を取得
		}
		infolist = dao.GurumeSelect(id, list);
		
	}if(infolist==null||infolist.size()==0){
		throw new Exception("入力された条件で情報が見つかりませんでした");
	}

	super.request.setAttribute("infolist",infolist);

	return"search";
}

	@Override
	protected String getPageName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}