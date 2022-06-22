import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Okinawa_DAO {
	//infoテーブル
	private static final String INFO_TBL_NAME = "info_m";
	private static final String INFO_ID = "info_id";
	private static final String S_G_ID = "s_g_id";
	private static final String INFO_NM = "info_nm";
	private static final String INFO_TABLE_AREA_ID = "area_id";
	private static final String POST_CORD = "post_cord";
	private static final String ADDRESS = "address";
	private static final String INFO_IMG = "info_img";
	private static final String CR_DATE = "cr_date";
	private static final String CR_MANA = "cr_mana";
	private static final String UP_DATE = "up_date";
	private static final String UP_MANA = "up_mana";
	//areaテーブル
	private static final String AREA_TABLE_NAME = "area_m";
	private static final String AREA_TABLE_AREA_ID = "area_id";
	private static final String AREA_NM = "area_nm";
	//Categoryテーブル
	private static final String CATEGORY_TABLE_NAME = "category_m";
	private static final String CATEGORY_TABLE_CATEGORY_ID = "category_id";
	private static final String CATEGORY_NM = "category_nm";
	//Commentテーブル
	private static final String COMMENT_TABLE_NAME = "comment_m";
	private static final String COMMENT_TABLE_COMMENT_ID = "comment_id";
	private static final String COMMENT_TABLE_INFO_ID = "info_id";
	private static final String COMMENT_TABLE_COMMENT_NM = "comment_nm";
	private static final String COMMENT_TABLE_COMMENT_TX = "comment_tx";
	private static final String COMMENT_TABLE_COMMENT_IMG = "comment_img";
	private static final String COMMENT_TABLE_CR_DATE = "cr_date";
	private static final String COMMENT_TABLE_CR_MANA_ID = "cr_mana_id";
	//Gurume_Categoryテーブル
	private static final String GURUME_CATEGORY_TABLE_NAME = "g_cat";
	private static final String GURUME_CATEGORY_INFO_ID = "info_id";
	private static final String GURUME_CATEGORY_CATEGORY_ID = "category_id";
	//Spot_Gurumeテーブル
	private static final String SPOT_GURUME_TABLE_NAME = "s_g_m";
	private static final String SPOT_GURUME_S_G_ID= "s_g_id";
	private static final String SPOT_GURUME_S_G_NM = "s_g_nm";

	/** DBコネクション */
	public Connection con;
	/** DBステートメント */
	PreparedStatement stmt;
	/** 検索結果 */
	ResultSet rs;
	
	/**
	 * インスタンス生成時DBコネクション
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Okinawa_DAO(Connection con) {
		this.con = con;
	}
	
	/**
	 * DBから取得した検索結果（info_mテーブル）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs
	 *            検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Info_DTO rowMappingInfo(ResultSet rs) throws SQLException {
		Info_DTO InfoD = new Info_DTO();
		InfoD.setInfo_id(rs.getInt(INFO_ID));
		InfoD.setS_g_id(rs.getInt(S_G_ID));
		InfoD.setInfo_nm(rs.getString(INFO_NM));
		InfoD.setArea_id(rs.getInt(INFO_TABLE_AREA_ID));
		InfoD.setAddress(rs.getString(ADDRESS));
		InfoD.setInfo_img(rs.getString(INFO_IMG));
		InfoD.setCr_date(rs.getString(CR_DATE));
		InfoD.setCr_mana(rs.getString(CR_MANA));
		InfoD.setUp_date(rs.getString(UP_DATE));
		InfoD.setUp_mana(rs.getString(UP_MANA));
		return InfoD;
	}
	
	/**
	 * DBから取得した検索結果（comment_mテーブル）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs
	 *            検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Comment_DTO rowMappingComment_m(ResultSet rs) throws SQLException {
		Comment_DTO InfoD = new Comment_DTO();
		InfoD.setComment_id(rs.getInt(S_G_ID));
		InfoD.setInfo_id(rs.getInt(INFO_ID));
		InfoD.setComment_nm(rs.getString(S_G_ID));
		InfoD.setComment_tx(rs.getString(INFO_NM));
		InfoD.setComment_img(rs.getString(INFO_TABLE_AREA_ID));
		InfoD.setCr_date(rs.getInt(ADDRESS));
		InfoD.setCr_mana_id(rs.getInt(INFO_IMG));
		return InfoD;
	}
	
	/**
	 * 情報掲載テーブル（info_m）の情報を全件取得する
	 *
	 * @return 検索結果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Info_DTO> InfoSelectAll() throws SQLException, ClassNotFoundException {
		List<Info_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + INFO_TBL_NAME);
		try {

			this.stmt = con.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.add(rowMappingInfo(rs));
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtnList;
	}
	
	/**
	 * コメント投稿
	 * @throws NumberFormatException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void CommentInsert(String info_id, String comment_id, String comment_nm, String comment_tx, String comment_img)
			throws NumberFormatException, SQLException, ClassNotFoundException {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT " + " INTO ");
		sql.append("    " + COMMENT_TABLE_NAME);
		sql.append(" ( ");
		sql.append("    " + COMMENT_TABLE_COMMENT_ID);
		sql.append("   ," + COMMENT_TABLE_INFO_ID);
		sql.append("   ," + COMMENT_TABLE_COMMENT_NM);
		sql.append("   ," + COMMENT_TABLE_COMMENT_TX);
		sql.append("   ," + COMMENT_TABLE_COMMENT_IMG);
		sql.append("   ," + COMMENT_TABLE_CR_DATE);
		sql.append(" ) ");
		sql.append(" VALUES ");
		sql.append(" ( ");
		sql.append("    " + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " now() ");
		sql.append(" ) ");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, Integer.parseInt(comment_id));
			stmt.setInt(2, Integer.parseInt(info_id));
			stmt.setString(3, comment_nm);
			stmt.setString(4, comment_tx);
			stmt.setString(5, comment_img);
			stmt.executeUpdate();
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
	}

	
	//掲載情報テーブルへの新規登録
	public void InfoInsert(int s_g_id, String info_nm, int area_id, String address, String post_cord, String info_img, String cr_mana, String[] cateList)
			throws NumberFormatException, SQLException, ClassNotFoundException {
		StringBuilder sql = new StringBuilder();
		
		//情報掲載テーブルへの情報登録
		sql.append(" INSERT " + " INTO ");
		sql.append("    " + INFO_TBL_NAME);
		sql.append(" ( ");
		sql.append("    " + S_G_ID);
		sql.append("   ," + INFO_NM);
		sql.append("   ," + INFO_TABLE_AREA_ID);
		sql.append("   ," + ADDRESS);
		sql.append("   ," + POST_CORD);
		sql.append("   ," + INFO_IMG);
		sql.append("   ," + CR_DATE);
		sql.append("   ," + CR_MANA);
		sql.append("   ," );
		sql.append(" ) ");
		sql.append(" VALUES ");
		sql.append(" ( ");
		sql.append("    " + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " now() ");
		sql.append("   ," + " ? ");
		sql.append(" ) ");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, s_g_id);
			stmt.setString(2, info_nm);
			stmt.setInt(3, area_id);
			stmt.setString(4, address);
			stmt.setString(5, post_cord);
			stmt.setString(6, info_img);
			stmt.setString(7, cr_mana);
			stmt.executeUpdate();
			
			//情報ID取得
			sql.append(" SELECT ");
			sql.append("    " + " MAX( " + INFO_ID + ")");
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			this.stmt = con.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			int infoId;
			infoId = rs.getInt(INFO_ID);
			
			//店カテゴリーテーブルへの情報登録
			for(int i = 0; i < cateList.length; i++) {
				Integer cate = Integer.parseInt(cateList[i]);
				sql.append(" INSERT " + " INTO ");
				sql.append("    " + INFO_TBL_NAME);
				sql.append(" ( ");
				sql.append("    " + INFO_ID);
				sql.append("   ," + CATEGORY_TABLE_CATEGORY_ID);
				sql.append(" ) ");
				sql.append(" VALUES ");
				sql.append(" ( ");
				sql.append("    " + infoId);
				sql.append("   ," + cate);
				sql.append(" ) ");
				this.stmt = con.prepareStatement(sql.toString());
				stmt.executeUpdate();
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
	}
	
	//情報IDを使って詳細情報を検索するメソッド
	public List<Info_DTO> selectByInfoId(String info_id) throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + INFO_TBL_NAME);
		sql.append(" WHERE ");
		sql.append("    " + INFO_ID + " = " + "?");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, info_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.add(rowMappingInfo(rs));
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtnList;
	}
	
	//グルメ条件検索
	public List<Info_DTO> GurumeSelect(int area_id, String[] checkedbox) throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		if (checkedbox.length == 1) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + "AND" + INFO_ID + "IN" + "(" + "SELECT" + INFO_ID + "FROM" +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, area_id);
				stmt.setInt(2, category_id);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingEmployee(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 2) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + "AND" + INFO_ID + "IN" + "(" + "SELECT" + INFO_ID + "FROM" +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id1 = Integer.parseInt(checkedbox[0]);
				int category_id2 = Integer.parseInt(checkedbox[1]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, area_id);
				stmt.setInt(2, category_id1);
				stmt.setInt(3, category_id2);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingEmployee(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 3) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + "AND" + INFO_ID + "IN" + "(" + "SELECT" + INFO_ID + "FROM" +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, area_id);
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingEmployee(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 4) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + "AND" + INFO_ID + "IN" + "(" + "SELECT" + INFO_ID + "FROM" +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				int category_id3 = Integer.parseInt(checkedbox[3]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, area_id);
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				stmt.setInt(5, category_id3);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingEmployee(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 5) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + "AND" + INFO_ID + "IN" + "(" + "SELECT" + INFO_ID + "FROM" +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				int category_id3 = Integer.parseInt(checkedbox[3]);
				int category_id4 = Integer.parseInt(checkedbox[4]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, area_id);
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				stmt.setInt(5, category_id3);
				stmt.setInt(6, category_id4);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingEmployee(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 6) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + "AND" + INFO_ID + "IN" + "(" + "SELECT" + INFO_ID + "FROM" +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				int category_id3 = Integer.parseInt(checkedbox[3]);
				int category_id4 = Integer.parseInt(checkedbox[4]);
				int category_id5 = Integer.parseInt(checkedbox[5]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, area_id);
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				stmt.setInt(5, category_id3);
				stmt.setInt(6, category_id4);
				stmt.setInt(7, category_id5);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingEmployee(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 7) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + "AND" + INFO_ID + "IN" + "(" + "SELECT" + INFO_ID + "FROM" +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + "OR" + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				int category_id3 = Integer.parseInt(checkedbox[3]);
				int category_id4 = Integer.parseInt(checkedbox[4]);
				int category_id5 = Integer.parseInt(checkedbox[5]);
				int category_id6 = Integer.parseInt(checkedbox[6]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, area_id);
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				stmt.setInt(5, category_id3);
				stmt.setInt(6, category_id4);
				stmt.setInt(7, category_id5);
				stmt.setInt(8, category_id6);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingEmployee(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		}
		return rtnList;
		
	}
	
	//スポット条件検索
	public List<Info_DTO> selectByArea(String area_id) throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + INFO_TBL_NAME);
		sql.append(" WHERE ");
		sql.append("    " + INFO_TABLE_AREA_ID + " = " + "?");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, area_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.add(rowMappingInfo(rs));
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtnList;
	}
	
	//フリーワード検索
	public List<Info_DTO> selectByFreeWord(String huri_wa_do) throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + INFO_TBL_NAME);
		sql.append(" WHERE ");
		sql.append("    " + INFO_NM + " LIKE " + "'%" + "?" + "%'");
		sql.append(" OR ");
		sql.append("    " + ADDRESS + " LIKE " + "'%" + "?" + "%'");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, huri_wa_do);
			stmt.setString(2, huri_wa_do);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.add(rowMappingInfo(rs));
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtnList;
	}
	
	//コメント検索
	public List<Comment_DTO> selectComment(String info_id) throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Comment_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + COMMENT_TABLE_NAME);
		sql.append(" WHERE ");
		sql.append("    " + INFO_ID + " = " + "?");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, info_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.add(rowMappingComment_m(rs));
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtnList;
	}
	
	//情報掲載テーブル情報削除
	public void infoDelete(String info_id) throws ClassNotFoundException, SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append(" DELETE " + " FROM ");
		sql.append("    " + COMMENT_TABLE_NAME);
		sql.append(" WHERE ");
		sql.append("    " + INFO_ID + " = " + " ? ");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, info_id);
			stmt.executeUpdate();
			
			sql.append(" DELETE " + " FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE ");
			sql.append("    " + INFO_ID + " = " + " ? ");
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setString(1, info_id);
				stmt.executeUpdate();
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
	}
	
	//コメント削除
	public void commentDelete(String comment_id) throws ClassNotFoundException, SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append(" DELETE " + " FROM ");
		sql.append("    " + COMMENT_TABLE_NAME);
		sql.append(" WHERE ");
		sql.append("    " + COMMENT_TABLE_COMMENT_ID + " = " + " ? ");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, comment_id);
			stmt.executeUpdate();
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
	}
	
}
