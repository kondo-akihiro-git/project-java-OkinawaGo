// 決まっていない部分はnull
public class UpdateService extends BaseService {

	public UpdateService() throws Exception {
		super(false);
	}

	/**
	 * スポットの登録を行う
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
	 * グルメの登録を行う
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
	 * スポットの更新を行う
	 */
public int updateSpot(null null ) {
				null dao = null new null(this.con);
				int count = -1;
				try {
					List<Object> paramList = new ArrayList<>();
					paramList.add(null.getnull());
					paramList.add(null.getnull());
					paramList.add(null.getnull());
					paramList.add(null.getnull());
					paramList.add(null.getnull());
					paramList.add(null.getnull());
					count = dao.updateByPrimaryKey(paramList, null.getnull());
			this.con.comit();
			} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return count;
	}

/**
	 * グルメの更新を行う
	 */
public int updateGou(null null ) {
	null dao = null new null(this.con);
	int count = -1;
	try {
				List<Object> paramList = new ArrayList<>();
				paramList.add(null.getnull());
				paramList.add(null.getnull());
				paramList.add(null.getnull());
				paramList.add(null.getnull());
				paramList.add(null.getnull());
				paramList.add(null.getnull());
				count = dao.updateByPrimaryKey(paramList, emp.getnull());
			this.con.comit();
			} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return count;
	}

	/**
	 * 社員情報の物理削除を行う
	 */

	public int deleteEmployee(Integer empId) throws Exception {
		EmployeeDao dao = new EmployeeDao(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.deleteByPrimaryKey(empId);
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
