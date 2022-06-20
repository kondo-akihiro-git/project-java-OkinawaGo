import java.util.Map;

@WebServlet(name="login", urlPatterns={"/login"})
public class LoginAction extends BaseServlet {

	@Override
	protected String doAction() throws Exception {
		// 画面入力項目の取得
		String[] param = super.getInputParameter("mail", "pass");
		
		// ログイン処理
		SearchService service = new SearchService();
		Map<String, Object> loginData = service.doLogin(param[0], param[1]);

		// 結果の取得（検索結果0件）
		if (loginData == null || loginData.get("?") == null) {
			// ポップアップの表示方法不明
			String message = "メールアドレスまたはパスワードが間違っています");
			request.setAttribute("message", message)
		}
		session.setAttribute("LOGIN", loginData.get("?"));
		request.getRequestDispatcher("adSearch.jsp");
		
	}
}