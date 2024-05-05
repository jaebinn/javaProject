package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dto.ManagerDTO;

public class ManagerDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public ManagerDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * 매니저id로 매니저 id,pw 가져오기
	 * @param managerid
	 * @return
	 */
	public ManagerDTO findManagerById(String managerid) {
		String sql = "select * from Manager where managerid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, managerid);

			rs = ps.executeQuery();
			if (rs.next()) {
				ManagerDTO manager = new ManagerDTO();
				manager.setManagerid(rs.getString("managerid"));
				manager.setManagerpw(rs.getString("managerpw"));

				return manager;
			}
		} catch (SQLException e) {
		}
		// 결과가 없다면 null 리턴
		return null;
	}

}
