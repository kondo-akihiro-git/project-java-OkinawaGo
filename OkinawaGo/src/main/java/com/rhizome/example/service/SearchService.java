
// 決まってない部分はnull
import java.util.HashMap;
import java.util.List;

public class SearchService extends BaseService(){

	public SearchService() throws Exception {
		super(true);
	}

/**
	 * メールアドレス、パスワードでログイン判定を行う
	 */
	public Map<String, Object> doLogin(String mail, String pass) throws Exception {
		Map<String, Object> loginData = new HashMap<>();
		//DAOによって変更
		null dao = new null(this.con);
		try {
			loginData.put("null", dao.selectLoginInfo(mail, pass));
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return loginData;
	}

	/**
	 * 管理者側でスポット検索を行う
	 */
	public List< null > searchSpot( null null ) throws Exception {
		null dao = new null(this.con);
		List<null> list = null;
		try {
			list = dao.findByParam(null);
			if (list.size() == 0) {
				list = null;
			}
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}

	/**
	 * 管理者側でスポット検索を行う
	 */
	public List< null > searchGou( null null ) throws Exception {
		null dao = new null(this.con);
		List<null> list = null;
		try {
			list = dao.findByParam(null);
			if (list.size() == 0) {
				list = null;
			}
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}
/**
	 * 管理者側でスポット情報の主キー検索を行う

	 */
	public null searchSpotByPkey(Integer null) throws Exception {
		null dao = new null(this.con);
		null nullA = null;
		try {
			nullA = dao.findByPramaryKey(null);
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return nullA;
	}
	/**
	 * 管理者側でグルメ情報の主キー検索を行う

	 */
	public null searchGouByPkey(Integer null) throws Exception {
		null dao = new EmployeeDao(this.con);
		null nullA = null;
		try {
			nullA = dao.findByPramaryKey(null);
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return nullA;
	}
	

}