import java.util.HashMap;
import java.util.List;
public class SearchService extends BaseService(){

	public SearchService() throws Exception {
		super(true);
	}
	
/**
	 * メールアドレス、パスワードでログイン判定を行う
	 * @param mail
	 * @param pass
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doLogin(String mail, String pass) throws Exception {
		Map<String, Object> loginData = new HashMap<>();
		//DAOによって変更
		EmployeeDao dao = new EmployeeDao(this.con);
		try {
			loginData.put("EMP", dao.selectLoginInfo(mail, pass));
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return loginData;
	}
	
}