
package com.rhizome.example.page;

import javax.servlet.annotation.WebServlet;

import com.rhizome.example.entity.Employee;
import com.rhizome.example.page.base.BaseServlet;
import com.rhizome.example.service.UpdateService;
import com.rhizome.example.service.UpdateService.UPDATE_MODE;

@WebServlet(name = "input", urlPatterns = { "/input" })
public class AddInfoAction extends BaseServlet {

	@Override
	protected String doAction() throws Exception {
String param = super.getInputParamert("s_g_id");
String[] paramList;
if(param <= 25) {
		paramList = super.getInputParameter(
				"info_nm"		// 0
				,"area_id"	// 1
				,"post"		// 2
				,"address"	// 3
				,"info_img"	// 4
		);
}else if(param > 25) {
	paramList = super.getInputParameter(
		paramList = super.getInputParameter(
				"info_nm"		// 0
				,"area_id"	// 1
				,"post"		// 2 //掲載情報テーブル修正後再度確認
				,"address"	// 3
				,"category_id" // 4
				,"info_img"	// 5
		);
	
}
if(super.request.getParameter("back") != null) {
	return "adInsert_input.jsp";
}else {return 	"adInsertConfirm";
}
}