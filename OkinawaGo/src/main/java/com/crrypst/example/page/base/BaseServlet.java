package main.java.com.crrypst.example.page.base;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.crrypst.example.entity.Manager_DTO;

//entityのインポート
//import 

public abstract class BaseServlet extends HttpServlet {
	// -------------------------------------- プロパティ群
	/** HttpServletRequest */
	protected HttpServletRequest request;
	/** HttpServletResponse */
	protected HttpServletResponse response;
	/** HttpSession */
	protected HttpSession session;
	/** ErrorMessage */
	protected String message;

	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		this.request = request;
		this.response = response;
		this.session = request.getSession();

		message = null;
		String nextPage = this.getPageName();
			try {
				if (!"adLogin".equals(this.getPageName())) {
					if (session != null) {
						@SuppressWarnings("unchecked")
						List<Manager_DTO> managerList = (List<Manager_DTO>) session.getAttribute("LOGIN_Manager");
						
						if (
								(managerList == null || managerList.size() == 0)
							){
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

		request.getRequestDispatcher(nextPage + ".jsp").forward(request, response);
	}

	protected String[] getInputParameter(String... names) {
		String[] values = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			values[i] = this.request.getParameter(names[i]);
			/*
			 * 下記の処理は理解できていません。
			 */
			this.request.setAttribute(names[i], values[i]);
		}
		return values;
	}

	// -------------------------------------- 抽象メソッド群
	protected abstract String getPageName();

	protected abstract String doAction() throws Exception;
}
