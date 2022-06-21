@WebServlet(name = "select", urlPatterns = { "/select" })
public class SelectAction extends BaseServlet {

String text;
String value;
SearchService service = new SearchService();
List<null> infolist;

//検索トップ画面からフリーワードで検索した場合-------------------------------------------------------------
if (super.request.getParameter("toptext") != null) {
	text = super.request.getParameter("text");
	infolist = service.searchInfo(text);
}

//スポット検索画面からフリーワードで検索した場合------------------------------------------------------------
if(super.request.getParameter("spottext") != null) {
	text = super.request.getParameter("text");
	infolist = service.searchInfo(text);
	
//スポット検索画面のマップで検索した場合
}else if (super.request.getParameter("spotmap") != null)
	value = super.request.getParameter("spotmap");
	infolist = service.searchInfo(value);
}
//グルメ検索画面からフリーワードで検索した場合--------------------------------------------------------------
if(super.request.getParameter("goutext") != null) {
	text = super.request.getParameter("text");
	infolist = service.searchInfo(text);
	

//グルメ検索画面からカテゴリー検索した場合
}else if (super.request.getParameter("map_category" != null) {
		int id = super.request.getParameter("id");       // ラジオボタンでチェックされた値を取得
		if(super.request.getParameter("gou_category" != null)) {
			 String[] list = super.request.getParameterValues("checkbox");     //チェックボックスの値を配列で取得                                          //チェックボックスでチェックされた値を取得
		}
		infolist = service.conditionalSearchByRadio(id, list);
}
	if (infolist == null || infolist.size() == 0) {
		throw new Exception("入力された条件で情報が見つかりませんでした");
		}
	
super.request.setAttribute("infolist", infolist);
	

return "search";
}