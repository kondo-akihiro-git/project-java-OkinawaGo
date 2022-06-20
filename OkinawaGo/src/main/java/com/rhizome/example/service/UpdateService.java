// 決まっていない部分はnull
public class UpdateService extends BaseService {

	public UpdateService() throws Exception {
		super(false);
	}

	/**
	 * スポットの登録を行う--------------------------------------------------------------------------
	 */
public int insertSpot(null null) throws Exception {
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
public int insertGou(null null) throws Exception {
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
	 * スポット情報の物理削除を行う--------------------------------------------------------------------
	 */

	public int deleteSpot(Integer null) throws Exception {
		null dao = new null(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.deleteByPrimaryKey(null);
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
	 * グルメ情報の物理削除を行う--------------------------------------------------------------------
	 */

	public int deleteGou(Integer null) throws Exception {
		null dao = new null(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.deleteByPrimaryKey(null);
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
