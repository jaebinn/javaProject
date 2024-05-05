package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dto.TeacherDTO;

public class TeacherDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public TeacherDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * 티처등록
	 * @param teacher
	 * @return
	 */
	public boolean insertTeacher(TeacherDTO teacher) {
		String sql = "insert into teacher (teacherid,tea_pw,tea_name,tea_age,tea_gender,tea_phone)"
				+ "values(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacher.getTeacherid());
			ps.setString(2, teacher.getTea_pw());
			ps.setString(3, teacher.getTea_name());
			ps.setInt(4, teacher.getTea_age());
			ps.setString(5, teacher.getTea_gender());
			ps.setString(6, teacher.getTea_phone());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/**
	 * 티처id로 티처 데이터 삭제
	 * @param teacherid
	 * @return
	 */
	public boolean deleteByTeacherId(String teacherid) {
		String sql = "delete from teacher where teacherid= ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, teacherid);
			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	/**
	 * 티처 정보 수정
	 * @param choice 1.티처pw 2.티처폰
	 * @param teacherid
	 * @param newData = 바꾸는 내용
	 * @return
	 */
	public boolean updateTeacher(int choice, String teacherid, String newData) {
		String[] cols = { "", "tea_pw", "tea_phone" };
		String sql = "update teacher set " + cols[choice] + "= ? where teacherid = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, teacherid);

			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	
	/**
	 * 티처id로 티처 데이터가져오기
	 * @param teacherid
	 * @return
	 */
	public TeacherDTO findTeacherById(String teacherid) {
		String sql = "select * from teacher where teacherid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacherid);

			rs = ps.executeQuery();
			if (rs.next()) {
				TeacherDTO teacher = new TeacherDTO();
				teacher.setTeacherid(rs.getString("teacherid"));
				teacher.setTea_pw(rs.getString("tea_pw"));
				teacher.setTea_name(rs.getString("tea_name"));
				teacher.setTea_age(rs.getInt("tea_age"));
				teacher.setTea_gender(rs.getString("tea_gender"));
				teacher.setTea_phone(rs.getString("tea_phone"));

				return teacher;
			}
		} catch (SQLException e) {
		}
		// 결과가 없다면 null 리턴
		return null;
	}

}
