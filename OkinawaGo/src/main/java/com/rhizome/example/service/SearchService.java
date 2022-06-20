
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
	 * 管理者トップでフリーワードによるスポット・グルメ検索を行う---------------------------------------------------------------------------------
	 */
	public List< null > searchInfo(String null ) throws Exception {
		null dao = new null(this.con);
		List<null> list = null;
		try {
			list = dao.findByParam(null); //入力された値で条件検索
			if (list.size() == 0) {
				list = null;
			}
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}
/**
	 * 管理者トップ画面から詳細トップページに飛ぶ-------------------------------------------------------------------

	 */
	public null searchSpotBykey(Integer cateId, String name) throws Exception {
		null dao = new null(this.con);
		null nullA = null;
		try {
			nullA = dao.findByKey(cateId, name);
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return nullA;
	}
}