r// 決まっていない部分はnull
public class UpdateService extends BaseService {

	public UpdateService() throws Exception {
		super(false);
	}

	/**
	 * スポットの登録を行う--------------------------------------------------------------------------
	 */
public int registerSpot(null null) throws Exception {
		null dao = new null(this.con);
		int count = -1;
				try{
					count = dao.insertSpot(null);
					this.con.comit();
					} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
				}finally {
					DbUtil.closeConnection(this.con);
				}
				return count;
}
/**
	 * グルメの登録を行う------------------------------------------------------------------------------
	 */
public int registerGou(null null) throws Exception {
		null dao = new null(this.con);
		int count = -1;
				try{
					count = dao.insertGou(null);
					this.con.comit();
					} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
				}finally {
					DbUtil.closeConnection(this.con);
				}
				return count;
}


	/**
	 * スポット・グルメ情報の削除--------------------------------------------------------------------
	 */

	public int deleteInfo(Integer id) throws Exception { // 削除するスポット・グルメのIDを引数とする
		null dao = new null(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.deleteInfoByPrimaryKey(id);
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("削除できませんでした:" + e.getMessage());
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return deleteCount;
	}
	
	/**
	 * コメントの削除--------------------------------------------------------------------
	 */

	public int deleteComment(Integer id) throws Exception { // 削除するコメントが所属するスポット・グルメのIDを引数とする
		null dao = new null(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.deleteCommentByPrimaryKey(id);
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("削除できませんでした:" + e.getMessage());
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return deleteCount;
	}

}
