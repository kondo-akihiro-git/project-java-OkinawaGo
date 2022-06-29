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
import main.java.com.crrypst.example.util.DbUtil;

public class Manager_DAO {
	// infoテーブル
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
	// areaテーブル
	private static final String AREA_TABLE_NAME = "area_m";
	private static final String AREA_TABLE_AREA_ID = "area_id";
	private static final String AREA_NM = "area_nm";
	// Categoryテーブル
	private static final String CATEGORY_TABLE_NAME = "category_m";
	private static final String CATEGORY_TABLE_CATEGORY_ID = "category_id";
	private static final String CATEGORY_NM = "category_nm";
	// Commentテーブル
	private static final String COMMENT_TABLE_NAME = "comment_m";
	private static final String COMMENT_TABLE_COMMENT_ID = "comment_id";
	private static final String COMMENT_TABLE_INFO_ID = "info_id";
	private static final String COMMENT_TABLE_COMMENT_NM = "comment_nm";
	private static final String COMMENT_TABLE_COMMENT_TX = "comment_tx";
	private static final String COMMENT_TABLE_COMMENT_IMG = "comment_img";
	private static final String COMMENT_TABLE_CR_DATE = "cr_date";
	private static final String COMMENT_TABLE_CR_MANA_ID = "cr_mana_id";
	// Gurume_Categoryテーブル
	private static final String GURUME_CATEGORY_TABLE_NAME = "g_cat";
	private static final String GURUME_CATEGORY_INFO_ID = "info_id";
	private static final String GURUME_CATEGORY_CATEGORY_ID = "category_id";
	// Spot_Gurumeテーブル
	private static final String SPOT_GURUME_TABLE_NAME = "s_g_m";
	private static final String SPOT_GURUME_S_G_ID = "s_g_id";
	private static final String SPOT_GURUME_S_G_NM = "s_g_nm";
	// Managerテーブル
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
	public Manager_DAO(Connection con) {
		this.con = con;
	}

	// rowMappingメソッド
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
	 * @param rs 検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Info_DTO rowMappingInfo(ResultSet rs) throws SQLException {
		Info_DTO InfoD1 = new Info_DTO();
		InfoD1.setInfo_id(rs.getString(INFO_ID));
		InfoD1.setS_g_id(rs.getString(S_G_ID));
		InfoD1.setInfo_nm(rs.getString(INFO_NM));
		InfoD1.setArea_id(rs.getString(INFO_TABLE_AREA_ID));
		InfoD1.setPost_code(rs.getString(POST_CODE));
		InfoD1.setAddress(rs.getString(ADDRESS));
		InfoD1.setInfo_img(rs.getString(INFO_IMG));
		InfoD1.setCr_date(rs.getString(CR_DATE));
		InfoD1.setCr_mana(rs.getString(CR_MANA));
		InfoD1.setUp_date(rs.getString(UP_DATE));
		InfoD1.setUp_mana(rs.getString(UP_MANA));
		return InfoD1;
	}

	/**
	 * DBから取得した検索結果（info_id_img_DTO）をDTO型のインスタンスにセットし、リストに格納する + "," + S_G_ID + ","
	 * + S_G_ID + "," + S_G_ID + "," + S_G_ID
	 * 
	 * @param rs 検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Info_id_img_DTO rowMappingInfoIdImg(ResultSet rs) throws SQLException {
		Info_id_img_DTO InfoD2 = new Info_id_img_DTO();
		InfoD2.setInfo_id(rs.getString(INFO_ID));
		InfoD2.setInfo_img(rs.getString(INFO_IMG));
		InfoD2.setS_g_id(rs.getString(S_G_ID));
		InfoD2.setArea_id(rs.getString(AREA_TABLE_AREA_ID));
		return InfoD2;
	}

	/**
	 * DBから取得した検索結果（Area_DTO）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs 検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Area_DTO rowMappingArea(ResultSet rs) throws SQLException {
		Area_DTO InfoD3 = new Area_DTO();
		InfoD3.setArea_id(rs.getString(AREA_TABLE_AREA_ID));
		InfoD3.setArea_nm(rs.getString(AREA_NM));
		return InfoD3;
	}

	/**
	 * DBから取得した検索結果（Gurume_Category_DTO）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs 検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Gurume_Category_DTO rowMappingGurumeCategory(ResultSet rs) throws SQLException {
		Gurume_Category_DTO InfoD4 = new Gurume_Category_DTO();
		InfoD4.setInfo_id(rs.getString(INFO_ID));
		InfoD4.setCategory_id(rs.getString(CATEGORY_TABLE_CATEGORY_ID));
		return InfoD4;
	}

	/**
	 * DBから取得した検索結果（Category_DTO）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs 検索結果
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
	 * @param rs 検索結果
	 * @return リスト
	 * @throws SQLException
	 */
	public Info_id_DTO rowMappingInfoId(ResultSet rs) throws SQLException {
		Info_id_DTO InfoD5 = new Info_id_DTO();
		InfoD5.setInfo_id(rs.getString(MAX));
		return InfoD5;
	}

	/**
	 * DBから取得した検索結果（comment_mテーブル）をDTO型のインスタンスにセットし、リストに格納する
	 *
	 * @param rs 検索結果
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

	// 情報IDを使って詳細情報を検索するメソッド
	public Info_DTO selectByInfoId(String info_id) throws SQLException, ClassNotFoundException, NumberFormatException {
		Info_DTO rtn = new Info_DTO();
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
				rtn = rowMappingInfo(rs);
			}
		} finally {
			DbUtil.closeStatement(this.stmt);
		}
		return rtn;
	}

	// スポット条件検索
	public List<Info_DTO> selectByArea(String area_id)
			throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_DTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    " + "*");
		sql.append(" FROM ");
		sql.append("    " + INFO_TBL_NAME);
		sql.append(" WHERE ");
		sql.append("    " + INFO_TABLE_AREA_ID + " = " + "?" );
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

	public List<Info_DTO> managerFreeWord(String huri_wa_do)
			throws SQLException, ClassNotFoundException, NumberFormatException {
		List<Info_DTO> rtnList = new ArrayList<>();
		List<Area_DTO> rtnList1 = new ArrayList<>();
		List<Category_DTO> rtnList2 = new ArrayList<>();
		List<Gurume_Category_DTO> rtnList3 = new ArrayList<>();
		

		StringBuilder sql2 = new StringBuilder();
		sql2.append(" SELECT ");
		sql2.append("    " + "*");
		sql2.append(" FROM ");
		sql2.append("    " + CATEGORY_TABLE_NAME);
		sql2.append(" WHERE ");
		sql2.append("    " + CATEGORY_NM + " LIKE " + "?");
		try {
			this.stmt = con.prepareStatement(sql2.toString());
			stmt.setString(1, "%" + huri_wa_do + "%");
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList2.add(rowMappingCategory(rs));
				
			}

			if (rtnList2 == null || rtnList2.size() == 0) {
				// どこにもない場合
			} else {
				String category = rtnList2.get(0).getCategory_id();
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
				
				//System.out.println("cateInfoId"+InfoD4.getInfo_id());
				
				List<Info_DTO> cateList = new ArrayList<>();
				Manager_DAO dao = new Manager_DAO(this.con);
				for(int i= 0;i<rtnList3.size();i++) {
					String cateInfoId = rtnList3.get(i).getInfo_id();
				cateList.add(dao.selectByInfoId(cateInfoId));
				
				}
				rtnList = cateList;
				
			}
			if (rtnList3 == null || rtnList3.size() == 0) {
				List<Info_DTO> List5 = new ArrayList<>();
				StringBuilder sql1 = new StringBuilder();
				sql1.append(" SELECT ");
				sql1.append("    " + "*");
				sql1.append(" FROM ");
				sql1.append("    " + " info_m INNER JOIN area_m\n"
						+ "ON info_m.area_id = area_m.area_id ");
				sql1.append(" WHERE ");
				sql1.append("    " + AREA_NM + " LIKE " + "?" +" OR "+ " info_nm " + " LIKE " + "?"+" OR "+ " address " + " LIKE " + "?");
				this.stmt = con.prepareStatement(sql1.toString());
				stmt.setString(1, "%" + huri_wa_do + "%");
				stmt.setString(2, "%" + huri_wa_do + "%");
				stmt.setString(3, "%" + huri_wa_do + "%");
				rs = stmt.executeQuery();
				while (rs.next()) {
					List5.add(rowMappingInfo(rs));
					
				}
				
				rtnList = List5;
				
				
			}

			

		} finally {
			DbUtil.closeStatement(this.stmt);
		}

		return rtnList;

	}

	
}
