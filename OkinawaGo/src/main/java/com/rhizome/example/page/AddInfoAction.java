
package com.rhizome.example.page;

import javax.servlet.annotation.WebServlet;

import com.rhizome.example.entity.Employee;
import com.rhizome.example.page.base.BaseServlet;
import com.rhizome.example.service.UpdateService;
import com.rhizome.example.service.UpdateService.UPDATE_MODE;

@WebServlet(name = "add", urlPatterns = { "/add" })
public class AddInfoAction extends BaseServlet {
	@Override
	protected String getPageName() {
		return "insertConfirm";
	}

	@Override
	protected String doAction() throws Exception {
String param = super.getInputParamert("s_g_id");
String[] paramList;
if(param <= 25) {
		paramList = super.getInputParameter(
				,"info_nm"		// 0
				,"area_id"	// 1
				,"post"		// 2
				,"address"	// 3
				,"info_img"	// 4
		);
}else if(param > 25) {
	paramList = super.getInputParameter(
		paramList = super.getInputParameter(
				,"info_nm"		// 0
				,"area_id"	// 1
				,"post"		// 2 //掲載情報テーブル修正後再度確認
				,"address"	// 3
				,"category_id" // 4
				,"info_img"	// 5
		);
}
		/*
		 * 登録->内容編集時の値保持バグの修正
		 */
		
			null info = new null();
			info.setnull(param[0]);
			info.setnull(param[1]);
			info.setnull(param[2]);
			info.setnull(param[3]);
			info.setnull(param[4]);
		if (param[0] == "グルメ") {
			info.setnull(param[5]);
		}
		UpdateService service = new UpdateService();
		if(param[0] == "スポット") {
		service.registerSpot(info);
		}
		else if(param[0] == "グルメ") {
		service.registerGou(info);
		}
		return "adInsert";
	}
}
