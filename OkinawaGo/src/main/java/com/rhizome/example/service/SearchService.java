
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
			loginData.put("null", dao.loginInfo(mail, pass));//mailとpassからログイン
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return loginData;
	}

	/**
	 * 管理者トップでフリーワードによるスポット・グルメ検索を行う---------------------------------------------------------------------------------
	 */
	public List< null > searchInfo(String text) throws Exception {
		null dao = new null(this.con);
		List<null> list = null;
		try {
			list = dao.findByInput(text)); //入力された値で条件検索
			if (list.size() == 0) {
				list = null;
			}
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}
/**
	 * 管理者トップ画面からスポット・グルメ詳細ページに飛ぶ-------------------------------------------------------------------

	 */
	public null searchDetailBykey(Integer cateId, String name) throws Exception {
		null dao = new null(this.con);
		null nullA = null; // メソッドの戻り値のデータ型がわかっていません…ごめんなさい。
		try {
			nullA = dao.findDetailByIdName(cateId, name); // カテゴリーIDと名前からスポット詳細情報を取得
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return nullA;
	}
	
	 /* ユーザー検索画面からスポット・グルメ詳細ページに飛ぶ-------------------------------------------------------------------

	 */
	public null searchDetailBykey(String img) throws Exception {
		null dao = new null(this.con);
		null nullA = null; // メソッドの戻り値のデータ型がわかっていません…ごめんなさい。
		try {
			nullA = dao.findDetailByIdName(cateId, name); //カテゴリーIDと名前からグルメ詳細情報を取得
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return nullA;
	}
	/**
	 * 管理者トップ画面からコメント一覧ページに遷移-------------------------------------------------------------------
	 */
	
	public null searchCommentBykey(Integer cateId, String name) throws Exception {
		null dao = new null(this.con);
		List<null> list = null;
		try {
			list = dao.findCommentByIdName(cateId, name); // カテゴリーIDと名前からコメント一覧を取得
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return list;
	}
	/**
	 * グルメ検索画面からカテゴリー検索後、検索結果画面に遷移-------------------------------------------------------------------
	 */
	public null conditionalSearchByRadio(Integer id, String[] array) throws Exception {
		null dao = new null(this.con);
		List<null> list = null;
		try {
			list = dao.findByIdList(id, array); //地域IDとチェックボックスからスポット・グルメの一覧を取得
		}finnaly {
			DbUtil.closeConnection(this.con);
		}
		return list
	}
	
}
　