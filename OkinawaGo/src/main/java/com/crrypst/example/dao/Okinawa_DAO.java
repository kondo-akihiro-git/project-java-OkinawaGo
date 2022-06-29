package main.java.com.crrypst.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.crrypst.example.entity.Area_DTO;
import main.java.com.crrypst.example.entity.Category_DTO;
import main.java.com.crrypst.example.entity.Comment_DTO;
import main.java.com.crrypst.example.entity.Gurume_Category_DTO;
import main.java.com.crrypst.example.entity.Info_DTO;
import main.java.com.crrypst.example.entity.Info_id_DTO;
import main.java.com.crrypst.example.entity.Info_id_img_DTO;
import main.java.com.crrypst.example.entity.Manager_DTO;
import main.java.com.crrypst.example.entity.Menu_DTO;
import main.java.com.crrypst.example.util.DbUtil;



public class Okinawa_DAO {
	//infoテーブル
	private static final String INFO_TBL_NAME = "info_m";
	private static final String INFO_ID = "info_id";
	private static final String S_G_ID = "s_g_id";
	private static final String INFO_NM = "info_nm";
	private static final String INFO_TABLE_AREA_ID = "area_id";
	private static final String POST_CODE = "post_code";
	private static final String ADDRESS = "address";
	private static final String INFO_IMG = "info_img";
	private static final String CR_DATE = "cr_date";
	private static final String CR_MANA = "cr_mana";
	private static final String UP_DATE = "up_date";
	private static final String UP_MANA = "up_mana";
	private static final String MAX = "MAX(info_id)";
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
	//Managerテーブル
	private static final String MANAGER_TABLE_NAME = "manager_m";
	private static final String MANAGER_ID = "manager_id";
	private static final String MANAGER_NM = "manager_nm";
	private static final String MANAGER_KN = "manager_kn";
	private static final String MANAGER_MAIL = "manager_mail";
	private static final String MANAGER_PASS = "manager_pass";
	private static final String MANAGER_CR_DATE = "cr_date";
	private static final String MANAGER_CR_MANA = "cr_mana";
	private static final String MANAGER_UP_DATE = "up_date";
	private static final String MANAGER_UP_MANA = "up_mana";
	//s_g_priceテーブル
	private static final String PRICE_TBL_NAME = "s_g_price";
	private static final String PRICE_INFO_ID = "info_id";
	private static final String PRICE_MENU_ID = "menu_id";
	private static final String PRICE_NM = "price_nm";
	private static final String PRICE = "price";
	
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
	
	//rowMappingメソッド
	public Manager_DTO rowMappingManager_m(ResultSet rs) throws SQLException {
			Manager_DTO ManagerD = new Manager_DTO();
			ManagerD.setManager_id(rs.getString(MANAGER_ID));
			ManagerD.setManager_nm(rs.getString(MANAGER_NM));
			ManagerD.setManager_kn(rs.getString(MANAGER_KN));
			ManagerD.setManager_mail(rs.getString(MANAGER_MAIL));
			ManagerD.setManager_pass(rs.getString(MANAGER_PASS));
			ManagerD.setCr_date(rs.getString(MANAGER_CR_DATE));
			ManagerD.setCr_mana(rs.getString(MANAGER_CR_MANA));
			ManagerD.setUp_date(rs.getString(MANAGER_UP_DATE));
			ManagerD.setUp_mana(rs.getString(MANAGER_UP_MANA));
			return ManagerD;
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
		InfoD.setInfo_id(rs.getString(INFO_ID));
		InfoD.setS_g_id(rs.getString(S_G_ID));
		InfoD.setInfo_nm(rs.getString(INFO_NM));
		InfoD.setArea_id(rs.getString(INFO_TABLE_AREA_ID));
		InfoD.setPost_code(rs.getString(POST_CODE));
		InfoD.setAddress(rs.getString(ADDRESS));
		InfoD.setInfo_img(rs.getString(INFO_IMG));
		InfoD.setCr_date(rs.getString(CR_DATE));
		InfoD.setCr_mana(rs.getString(CR_MANA));
		InfoD.setUp_date(rs.getString(UP_DATE));
		InfoD.setUp_mana(rs.getString(UP_MANA));
		return InfoD;
	}
	
	/**
	 * DBから取得した検索結果（info_id_img_DTO）をDTO型のインスタンスにセットし、リストに格納する
	 *+ "," + S_G_ID + "," + S_G_ID + "," + S_G_ID + "," + S_G_ID
	 * @param rs
	 *            検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Info_id_img_DTO rowMappingInfoIdImg(ResultSet rs) throws SQLException {
		Info_id_img_DTO InfoD = new Info_id_img_DTO();
		InfoD.setInfo_id(rs.getString(INFO_ID));
		InfoD.setInfo_img(rs.getString(INFO_IMG));
		InfoD.setS_g_id(rs.getString(S_G_ID));
		InfoD.setArea_id(rs.getString(AREA_TABLE_AREA_ID));
		return InfoD;
	}
	
	/**
	 * DBから取得した検索結果（Area_DTO）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs
	 *            検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Area_DTO rowMappingArea(ResultSet rs) throws SQLException {
		Area_DTO InfoD = new Area_DTO();
		InfoD.setArea_id(rs.getString(AREA_TABLE_AREA_ID));
		InfoD.setArea_nm(rs.getString(AREA_NM));
		return InfoD;
	}
	
	/**
	 * DBから取得した検索結果（Gurume_Category_DTO）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs
	 *            検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Gurume_Category_DTO rowMappingGurumeCategory(ResultSet rs) throws SQLException {
		Gurume_Category_DTO InfoD = new Gurume_Category_DTO();
		InfoD.setInfo_id(rs.getString(INFO_ID));
		InfoD.setCategory_id(rs.getString(CATEGORY_TABLE_CATEGORY_ID));
		return InfoD;
	}
	
	/**
	 * DBから取得した検索結果（Category_DTO）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs
	 *            検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Category_DTO rowMappingCategory(ResultSet rs) throws SQLException {
		Category_DTO InfoD = new Category_DTO();
		InfoD.setCategory_id(rs.getString(CATEGORY_TABLE_CATEGORY_ID));
		InfoD.setCategory_nm(rs.getString(CATEGORY_NM));
		return InfoD;
	}
	
	/**
	 * DBから取得した検索結果（info_id_DTO）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs
	 *            検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Info_id_DTO rowMappingInfoId(ResultSet rs) throws SQLException {
		Info_id_DTO InfoD = new Info_id_DTO();
		InfoD.setInfo_id(rs.getString(MAX));
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
		InfoD.setComment_id(rs.getString(COMMENT_TABLE_COMMENT_ID));
		InfoD.setInfo_id(rs.getString(INFO_ID));
		InfoD.setComment_nm(rs.getString(COMMENT_TABLE_COMMENT_NM));
		InfoD.setComment_tx(rs.getString(COMMENT_TABLE_COMMENT_TX));
		InfoD.setComment_img(rs.getString(COMMENT_TABLE_COMMENT_IMG));
		return InfoD;
	}
	
	public Menu_DTO rowMappingPrice(ResultSet rs) throws SQLException {
		Menu_DTO InfoD = new Menu_DTO();
		InfoD.setInfo_id(rs.getString(PRICE_INFO_ID));
		InfoD.setMenu_id(rs.getString(PRICE_MENU_ID));
		InfoD.setPrice_nm(rs.getString(PRICE_NM));
		InfoD.setPrice(rs.getString(PRICE));
		return InfoD;
	}
	/**
	 * 情報掲載テーブル（info_m）の情報を全件取得する
	 *
	 * @return 検索結果
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Info_id_img_DTO> InfoSelectAll(String area_id) throws SQLException, ClassNotFoundException {
		List<Info_id_img_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + INFO_TBL_NAME + " WHERE " + S_G_ID +" = " + "2" + " AND " + INFO_TABLE_AREA_ID +" = " + " ? " );
		try {

			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, area_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.add(rowMappingInfoIdImg(rs));
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
	public void CommentInsert(String info_id, String comment_nm, String comment_tx, String comment_img)
			throws NumberFormatException, SQLException, ClassNotFoundException {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT " + " INTO ");
		sql.append("    " + COMMENT_TABLE_NAME);
		sql.append(" ( ");
		sql.append("    " + COMMENT_TABLE_INFO_ID);
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
		sql.append("   ," + " now() ");
		sql.append(" ) ");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, Integer.parseInt(info_id));
			stmt.setString(2, comment_nm);
			stmt.setString(3, comment_tx);
			stmt.setString(4, comment_img);
			
			stmt.executeUpdate();
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
	}

	//(スポット)掲載情報テーブルへの新規登録
	public void spotInsert(String s_g_id, String info_nm, String area_id, String address, String post_code, String info_img, String cr_mana)
			throws NumberFormatException, SQLException, ClassNotFoundException {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT " + " INTO ");
		sql.append("    " + INFO_TBL_NAME);
		sql.append(" ( ");
		sql.append("    " + S_G_ID);
		sql.append("   ," + INFO_NM);
		sql.append("   ," + INFO_TABLE_AREA_ID);
		sql.append("   ," + ADDRESS);
		sql.append("   ," + POST_CODE);
		sql.append("   ," + INFO_IMG);
		sql.append("   ," + CR_DATE);
		sql.append("   ," + CR_MANA);
		sql.append(" ) ");
		sql.append(" VALUES ");
		sql.append(" ( ");
		sql.append("    " + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " now() ");
		sql.append("   ," + " ? ");
		sql.append(" ) ");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, Integer.parseInt(s_g_id));
			stmt.setString(2, info_nm);
			stmt.setInt(3, Integer.parseInt(area_id));
			stmt.setString(4, address);
			stmt.setString(5, post_code);
			stmt.setString(6, info_img);
			stmt.setInt(7, Integer.parseInt(cr_mana));
			stmt.executeUpdate();
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
	}
	
	//(グルメ)掲載情報テーブルへの新規登録
	public void InfoInsert(String s_g_id, String info_nm, String area_id, String address, String post_code, String info_img, String cr_mana, String[] cateList)
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
		sql.append("   ," + POST_CODE);
		sql.append("   ," + INFO_IMG);
		sql.append("   ," + CR_DATE);
		sql.append("   ," + CR_MANA);
		sql.append(" ) ");
		sql.append(" VALUES ");
		sql.append(" ( ");
		sql.append("    " + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " ? ");
		sql.append("   ," + " now() ");
		sql.append("   ," + " ? ");
		sql.append(" ) ");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, Integer.parseInt(s_g_id));
			stmt.setString(2, info_nm);
			stmt.setInt(3, Integer.parseInt(area_id));
			stmt.setString(4, address);
			stmt.setString(5, post_code);
			stmt.setString(6, info_img);
			stmt.setString(7, cr_mana);
			stmt.executeUpdate();
			
			//情報ID取得
			List<Info_id_DTO> list = new ArrayList<>();
			StringBuilder sql1 = new StringBuilder();
			sql1.append(" SELECT ");
			sql1.append("    " + " MAX(" + INFO_ID + ")");
			sql1.append("  " + "FROM ");
			sql1.append("    " + INFO_TBL_NAME);
			this.stmt = con.prepareStatement(sql1.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rowMappingInfoId(rs));
			}
			
			int max_id = 0;
			for (Info_id_DTO id : list) {
				max_id = Integer.parseInt(id.getInfo_id());
			}
			
			//店カテゴリーテーブルへの情報登録
			for(int i = 0; i < cateList.length; i++) {
				Integer cate = Integer.parseInt(cateList[i]);
				StringBuilder sql2 = new StringBuilder();
				sql2.append(" INSERT " + " INTO ");
				sql2.append("    " + GURUME_CATEGORY_TABLE_NAME);
				sql2.append(" ( ");
				sql2.append("    " + INFO_ID);
				sql2.append("   ," + CATEGORY_TABLE_CATEGORY_ID);
				sql2.append(" ) ");
				sql2.append(" VALUES ");
				sql2.append(" ( ");
				sql2.append("    " + "?");
				sql2.append("   ," + "?");
				sql2.append(" ) ");
				this.stmt = con.prepareStatement(sql2.toString());
				stmt.setInt(1, max_id);
				stmt.setInt(2, cate);
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
			stmt.setInt(1, Integer.parseInt(info_id));
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.add(rowMappingInfo(rs));
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtnList;
	}
	
	//料金IDを使って詳細情報を検索するメソッド
		public List<Menu_DTO> selectByPrice(String info_id) throws SQLException, ClassNotFoundException, NumberFormatException {
			List<Menu_DTO> rtnList = new ArrayList<>();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT ");
			sql.append("    " + "*");
			sql.append(" FROM ");
			sql.append("    " + PRICE_TBL_NAME);
			sql.append(" WHERE ");
			sql.append("    " + INFO_ID + " = " + "?");
			try {
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, Integer.parseInt(info_id));
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingPrice(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			return rtnList;
		}
	
	
	
	//グルメ条件検索
	public List<Info_id_img_DTO> GurumeSelect(String area_id, String[] checkedbox) throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_id_img_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		if (checkedbox.length == 1) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG + "," + S_G_ID + "," + INFO_TABLE_AREA_ID);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + " AND " + INFO_ID + " IN " + "(" + " SELECT " + INFO_ID + " FROM " +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, Integer.parseInt(area_id));
				stmt.setInt(2, category_id);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingInfoIdImg(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 2) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG + "," + S_G_ID + "," + INFO_TABLE_AREA_ID);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + " AND " + INFO_ID + " IN " + "(" + " SELECT " + INFO_ID + " FROM " +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id1 = Integer.parseInt(checkedbox[0]);
				int category_id2 = Integer.parseInt(checkedbox[1]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, Integer.parseInt(area_id));
				stmt.setInt(2, category_id1);
				stmt.setInt(3, category_id2);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingInfoIdImg(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 3) {
			
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG + "," + S_G_ID + "," + INFO_TABLE_AREA_ID);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + " AND " + INFO_ID + " IN " + "(" + " SELECT " + INFO_ID + " FROM " +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, Integer.parseInt(area_id));
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingInfoIdImg(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 4) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG + "," + S_G_ID + "," + INFO_TABLE_AREA_ID);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + " AND " + INFO_ID + " IN " + "(" + " SELECT " + INFO_ID + " FROM " +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				int category_id3 = Integer.parseInt(checkedbox[3]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, Integer.parseInt(area_id));
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				stmt.setInt(5, category_id3);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingInfoIdImg(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 5) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG + "," + S_G_ID + "," + INFO_TABLE_AREA_ID);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + " AND " + INFO_ID + " IN " + "(" + " SELECT " + INFO_ID + " FROM " +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				int category_id3 = Integer.parseInt(checkedbox[3]);
				int category_id4 = Integer.parseInt(checkedbox[4]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, Integer.parseInt(area_id));
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				stmt.setInt(5, category_id3);
				stmt.setInt(6, category_id4);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingInfoIdImg(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 6) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG + "," + S_G_ID + "," + INFO_TABLE_AREA_ID);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + " AND " + INFO_ID + " IN " + "(" + " SELECT " + INFO_ID + " FROM " +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				int category_id3 = Integer.parseInt(checkedbox[3]);
				int category_id4 = Integer.parseInt(checkedbox[4]);
				int category_id5 = Integer.parseInt(checkedbox[5]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, Integer.parseInt(area_id));
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				stmt.setInt(5, category_id3);
				stmt.setInt(6, category_id4);
				stmt.setInt(7, category_id5);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingInfoIdImg(rs));
				}
			} finally {
				DbUtil.closeStatement(this.stmt);
			}
			
		} else if (checkedbox.length == 7) {
			sql.append(" SELECT ");
			sql.append("    " + INFO_ID + "," + INFO_IMG + "," + S_G_ID + "," + INFO_TABLE_AREA_ID);
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE " + INFO_TABLE_AREA_ID + "=" + "?" + " AND " + INFO_ID + " IN " + "(" + " SELECT " + INFO_ID + " FROM " +GURUME_CATEGORY_TABLE_NAME);
			sql.append(" WHERE ");
			sql.append("    " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + " OR " + GURUME_CATEGORY_CATEGORY_ID + " = " + "?" + ")");
			try {
				int category_id = Integer.parseInt(checkedbox[0]);
				int category_id1 = Integer.parseInt(checkedbox[1]);
				int category_id2 = Integer.parseInt(checkedbox[2]);
				int category_id3 = Integer.parseInt(checkedbox[3]);
				int category_id4 = Integer.parseInt(checkedbox[4]);
				int category_id5 = Integer.parseInt(checkedbox[5]);
				int category_id6 = Integer.parseInt(checkedbox[6]);
				this.stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, Integer.parseInt(area_id));
				stmt.setInt(2, category_id);
				stmt.setInt(3, category_id1);
				stmt.setInt(4, category_id2);
				stmt.setInt(5, category_id3);
				stmt.setInt(6, category_id4);
				stmt.setInt(7, category_id5);
				stmt.setInt(8, category_id6);
				rs = stmt.executeQuery();
				while (rs.next()) {
					rtnList.add(rowMappingInfoIdImg(rs));
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
		sql.append("    " + INFO_TABLE_AREA_ID + " = " + "?" +  " AND " + S_G_ID + " = 1" );
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
	//スポット条件検索
		public List<Info_DTO> selectGulumeByArea(String area_id) throws SQLException, ClassNotFoundException, NumberFormatException {
			List<Info_DTO> rtnList = new ArrayList<>();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT ");
			sql.append("    " + "*");
			sql.append(" FROM ");
			sql.append("    " + INFO_TBL_NAME);
			sql.append(" WHERE ");
			sql.append("    " + INFO_TABLE_AREA_ID + " = " + "?" +  " AND " + S_G_ID + " = 2" );
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
		sql.append("    " + INFO_NM + " LIKE "  + "?" );
		sql.append(" OR ");
		sql.append("    " + ADDRESS + " LIKE " +  "?" );
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, "%"+huri_wa_do+"%");
			stmt.setString(2, "%"+huri_wa_do+"%");
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
		sql.append("    " + INFO_ID + " = " + " ? ");
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
	
	// 情報掲載テーブル情報削除
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
				StringBuilder sql2 = new StringBuilder();
				sql2.append(" DELETE " + " FROM ");
				sql2.append("    " + GURUME_CATEGORY_TABLE_NAME);
				sql2.append(" WHERE ");
				sql2.append("    " + INFO_ID + " = " + " ? ");
				this.stmt = con.prepareStatement(sql2.toString());
				stmt.setString(1, info_id);
				stmt.executeUpdate();
				StringBuilder sql3 = new StringBuilder();
				sql3.append(" DELETE " + " FROM ");
				sql3.append("    " + PRICE_TBL_NAME);
				sql3.append(" WHERE ");
				sql3.append("    " + INFO_ID + " = " + " ? ");
				this.stmt = con.prepareStatement(sql3.toString());
				stmt.setString(1, info_id);
				stmt.executeUpdate();
				StringBuilder sql1 = new StringBuilder();
				sql1.append(" DELETE " + " FROM ");
				sql1.append("    " + INFO_TBL_NAME);
				sql1.append(" WHERE ");
				sql1.append("    " + INFO_ID + " = " + " ? ");
				this.stmt = con.prepareStatement(sql1.toString());
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
	
	//管理者ログイン
	public List<Manager_DTO> loginInfo(String mail, String pass) throws SQLException {
		List<Manager_DTO> managerList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT * FROM " + MANAGER_TABLE_NAME);
		sql.append(" WHERE " + MANAGER_MAIL +" = "+ " ? " +" AND "+ MANAGER_PASS + " = " + " ? ");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		stmt.setString(1, mail);
		stmt.setString(2, pass);

		ResultSet rs = stmt.executeQuery();

		// 主キー検索のため、0件、または1件と想定
		rs = stmt.executeQuery();
		while (rs.next()) {
			managerList.add(rowMappingManager_m(rs));
		}
		DbUtil.closeStatement(this.stmt);
		return managerList;
	}
	public String searcharea_nm(String value) throws SQLException, ClassNotFoundException, NumberFormatException {
		StringBuilder sql = new StringBuilder();
		String area_nm ="";
		sql.append(" SELECT ");
		sql.append("    " + AREA_NM);
		sql.append(" FROM ");
		sql.append("    " + AREA_TABLE_NAME);
		sql.append(" WHERE ");
		sql.append("    " + AREA_TABLE_AREA_ID + " = " + "?");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, value);
			rs = stmt.executeQuery();
			while (rs.next()) {
				area_nm = rs.getString("area_nm");
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return area_nm;
	}
	//管理者フリーワード検索変更後
	/*public List<Info_DTO> manageFreeWord(String huri_wa_do) throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_DTO> rtnList = new ArrayList<>();
		List<Category_DTO> rtnList1 = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + CATEGORY_TABLE_NAME);
		sql.append(" WHERE ");
		sql.append("    " + CATEGORY_NM + " LIKE " + "'%" + "?" + "%'");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, huri_wa_do);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList1.add(rowMappingCategory(rs));
			}
		
			if (rtnList1 == null || rtnList1.size() == 0) {
				List<Area_DTO> rtnList2 = new ArrayList<>();
				StringBuilder sql1 = new StringBuilder();
				sql1.append(" SELECT ");
				sql1.append("    " + "*");
				sql1.append(" FROM ");
				sql1.append("    " + AREA_TABLE_NAME);
				sql1.append(" WHERE ");
				sql1.append("    " + AREA_NM + " LIKE " + "'%" + "?" + "%'");
				
					this.stmt = con.prepareStatement(sql1.toString());
					stmt.setString(1, huri_wa_do);
					rs = stmt.executeQuery();
					while (rs.next()) {
						rtnList2.add(rowMappingArea(rs));
					}
					
					if (rtnList2 == null || rtnList2.size() == 0) {
						StringBuilder sql2 = new StringBuilder();
						sql2.append(" SELECT ");
						sql2.append("    " + "*");
						sql2.append(" FROM ");
						sql2.append("    " + INFO_TBL_NAME);
						sql2.append(" WHERE ");
						sql2.append("    " + INFO_NM + " LIKE " + "'%" + "?" + "%'");
						sql2.append(" OR ");
						sql2.append("    " + ADDRESS + " LIKE " + "'%" + "?" + "%'");
							this.stmt = con.prepareStatement(sql2.toString());
							stmt.setString(1, huri_wa_do);
							stmt.setString(2, huri_wa_do);
							rs = stmt.executeQuery();
							while (rs.next()) {
								rtnList.add(rowMappingInfo(rs));
							}
							
							if (rtnList == null || rtnList.size() == 0) {
								//どこにもない場合
							} else {}
							
					} else {
						String area = ((Area_DTO) rtnList1).getArea_id();
						Okinawa_DAO dao = new Okinawa_DAO(this.con);
						List<Info_DTO> areaList = dao.selectByArea(area);
						rtnList = areaList;
					}
			} else {
				String category = ((Category_DTO) rtnList).getCategory_id();
				List<Gurume_Category_DTO> rtnList3 = new ArrayList<>();
				StringBuilder sql3 = new StringBuilder();
				sql3.append(" SELECT ");
				sql3.append("    " + "*");
				sql3.append(" FROM ");
				sql3.append("    " + GURUME_CATEGORY_TABLE_NAME);
				sql3.append(" WHERE ");
				sql3.append("    " + CATEGORY_TABLE_CATEGORY_ID + " = " + "?");
					this.stmt = con.prepareStatement(sql3.toString());
					stmt.setString(1, category);
					rs = stmt.executeQuery();
					while (rs.next()) {
						rtnList3.add(rowMappingGurumeCategory(rs));
					}
				String cateInfoId =  ((Gurume_Category_DTO) rtnList3).getInfo_id();
				Okinawa_DAO dao = new Okinawa_DAO(this.con);
				List<Info_DTO> cateList = dao.selectByInfoId(cateInfoId);
				rtnList = cateList;
			
			
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtnList;
	}*/
	
	//管理者フリーワード検索変更前
	/*public List<Info_DTO> managerFreeWord(String huri_wa_do) throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + INFO_TBL_NAME);
		sql.append(" WHERE ");
		sql.append("    " + INFO_NM + " LIKE " + "?" );
		sql.append(" OR ");
		sql.append("    " + ADDRESS + " LIKE " + "?" );
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, "%"+huri_wa_do+"%");
			stmt.setString(2, "%"+huri_wa_do+"%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.add(rowMappingInfo(rs));
			}
			
			if (rtnList == null || rtnList.size() == 0) {
				List<Area_DTO> rtnList1 = new ArrayList<>();
				StringBuilder sql1 = new StringBuilder();
				sql1.append(" SELECT ");
				sql1.append("    " + "*");
				sql1.append(" FROM ");
				sql1.append("    " + AREA_TABLE_NAME);
				sql1.append(" WHERE ");
				sql1.append("    " + AREA_NM + " LIKE " + "?" );
					this.stmt = con.prepareStatement(sql.toString());
					stmt.setString(1, "%"+huri_wa_do+"%");
					rs = stmt.executeQuery();
					while (rs.next()) {
						rtnList1.add(rowMappingArea(rs));
					}
					
					if (rtnList1 == null || rtnList1.size() == 0) {
						List<Category_DTO> rtnList2 = new ArrayList<>();
						StringBuilder sql2 = new StringBuilder();
						sql2.append(" SELECT ");
						sql2.append("    " + "*");
						sql2.append(" FROM ");
						sql2.append("    " + CATEGORY_TABLE_NAME);
						sql2.append(" WHERE ");
						sql2.append("    " + CATEGORY_NM + " LIKE " + "?" );
							this.stmt = con.prepareStatement(sql.toString());
							stmt.setString(1, "%"+huri_wa_do+"%");
							rs = stmt.executeQuery();
							while (rs.next()) {
								rtnList2.add(rowMappingCategory(rs));
							}
							
							if (rtnList2 == null || rtnList2.size() == 0) {
								//どこにもない場合
							} else {
								String category = ((Category_DTO) rtnList2).getCategory_id();
								List<Gurume_Category_DTO> rtnList3 = new ArrayList<>();
								StringBuilder sql3 = new StringBuilder();
								sql3.append(" SELECT ");
								sql3.append("    " + "*");
								sql3.append(" FROM ");
								sql3.append("    " + GURUME_CATEGORY_TABLE_NAME);
								sql3.append(" WHERE ");
								sql3.append("    " + CATEGORY_TABLE_CATEGORY_ID + " = " + "?");
									this.stmt = con.prepareStatement(sql.toString());
									stmt.setString(1, category);
									rs = stmt.executeQuery();
									while (rs.next()) {
										rtnList3.add(rowMappingGurumeCategory(rs));
									}
								String cateInfoId =  ((Gurume_Category_DTO) rtnList3).getInfo_id();
								Okinawa_DAO dao = new Okinawa_DAO(this.con);
								List<Info_DTO> cateList = dao.selectByInfoId(cateInfoId);
								rtnList = cateList;
							}
							
					} else {
						String area = ((Area_DTO) rtnList1).getArea_id();
						Okinawa_DAO dao = new Okinawa_DAO(this.con);
						List<Info_DTO> areaList = dao.selectByArea(area);
						rtnList = areaList;
					}
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtnList;
	}*/
	
	

}
