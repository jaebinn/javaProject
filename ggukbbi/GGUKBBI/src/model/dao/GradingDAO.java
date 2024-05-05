package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.GradingDTO;

public class GradingDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public GradingDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * 학생 성적 기입
	 * @param score
	 * @return
	 */
	public boolean insertGrade(GradingDTO score) {
		String sql = "insert into grading (answerid, score)" + "values(?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, score.getAnswerid());
			ps.setInt(2, score.getScore());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 답변아이디로 성적가져오기
	 * @param answerid
	 * @return
	 */
	public GradingDTO findGradeByQuiznum(int answerid) {
		String sql = "select * from grading where answerid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, answerid);

			rs = ps.executeQuery();

			if (rs.next()) {
				GradingDTO student = new GradingDTO();
				student.setAnswerid(rs.getInt("answerid"));
				student.setScore(rs.getInt("score"));
				return student;
			}
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * cl_id로 성적가져오기
	 * @param cl_id
	 * @return
	 */
	public ArrayList<GradingDTO> getListByCl_id(int cl_id) {
		String sql = "select g.answerid, g.score from answer a join grading g on "
				+ "a.answerid = g.answerid where a.cl_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cl_id);

			rs = ps.executeQuery();

			ArrayList<GradingDTO> list = new ArrayList<GradingDTO>();

			while (rs.next()) {
				GradingDTO grade = new GradingDTO(rs.getInt("answerid"), rs.getInt("score")

				);

				list.add(grade);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * 답변아이디로 성적 삭제
	 * @param answerid
	 * @return
	 */
	public boolean deleteGradingByAnswerid(int answerid) {
		String sql = "delete from grading where answerid = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, answerid);
			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}
}
