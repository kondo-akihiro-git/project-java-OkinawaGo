

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//entityのインポート
//import 

public abstract class BaseServlet extends HttpServlet {
	//-------------------------------------- プロパティ群
	/** HttpServletRequest */
	protected HttpServletRequest request;
	/** HttpServletResponse */
	protected HttpServletResponse response;
	/** HttpSession */
	protected HttpSession session;
	/** ErrorMessage */
	protected String message;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
		this.message = null;

		String nextPage = this.getPageName();
		try {
			// ログインチェック
			if (!"login".equals(this.getPageName())) {
				if (session != null) {
					
					null null = (null) session.getAttribute("LOGIN_EMP");
					@SuppressWarnings("unchecked")
					List<null> null = (List<null>) session.getAttribute("DEP_LIST");
					if (
							(null == null || "".equals(null.get null()))
							||
							(null == null || null.size() == 0)
						){
						/*
						 * 不正アクセス時の遷移先バグに関する修正
						 */
						nextPage = "adLogin";

						throw new Exception("不正なログイン、またはログイン有効期間が過ぎています");
					}
				}
			}

			// 画面ごとの処理
			nextPage = this.doAction();
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}

		/*
		 * エラーメッセージ表示バグの修正
		 */
		request.setAttribute("alertMsg", this.message);

		request.getRequestDispatcher(nextPage + ".jsp").forward(request,  response);
	}
	
	protected String[] getInputParameter(String... names) {
		String[] values = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			values[i] = this.request.getParameter(names[i]);
			/*
			 *下記の処理は理解できていません。
			 */
			this.request.setAttribute(names[i], values[i]);
		}
		return values;
	}
	
	//-------------------------------------- 抽象メソッド群
		protected abstract String getPageName();

		protected abstract String doAction() throws Exception;
	}
	
}
