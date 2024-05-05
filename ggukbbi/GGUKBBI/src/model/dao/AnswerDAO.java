package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.AnswerDTO;

public class AnswerDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public AnswerDAO() {
		conn = DBConnection.getConnection();
	}
	
	/**
	 * 답변 등록
	 * @param answer
	 * @return
	 */
	public boolean insertAnswer(AnswerDTO answer) {
		String sql = "insert into answer(cl_id,quiznum,stu_answer)" + " values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, answer.getCl_id());
			ps.setInt(2, answer.getQuiznum());
			ps.setString(3, answer.getStu_answer());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/**
	 * clid로 답변삭제
	 * @param cl_id
	 * @return
	 */
	public boolean deleteByCl_id(int cl_id) {
		String sql = "delete from answer where cl_id = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, cl_id);
			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;

	}



	/**
	 * cl_id로 답변목록 받기
	 * @param cl_id
	 * @return
	 */
	public ArrayList<AnswerDTO> getList(int cl_id) {
		String sql = "select * from answer where cl_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cl_id);
			rs = ps.executeQuery();

			ArrayList<AnswerDTO> list = new ArrayList<AnswerDTO>();

			while (rs.next()) {
				AnswerDTO answer = new AnswerDTO(rs.getInt("answerid"), rs.getInt("cl_id"), rs.getInt("quiznum"),
						rs.getString("stu_answer"), rs.getString("regdate"));

				list.add(answer);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * 학생 아이디로 본인이 쓴 답변 목록 받기
	 * @param studentid
	 * @return
	 */
	public AnswerDTO getAnswerByStudentid(String studentid) {

		String sql = "select a.answerid,a.cl_id,a.quiznum,a.stu_answer,a.regdate " + "from answer a "
				+ "inner join course_list on answer.cl_id = course_list.cl_id "
				+ "inner join student on course_list.studentid = student.studentid " + "where student.studentid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentid);

			rs = ps.executeQuery();
			if (rs.next()) {
				AnswerDTO answer = new AnswerDTO();
				answer.setAnswerid(rs.getInt("answerid"));
				answer.setCl_id(rs.getInt("cl_id"));
				answer.setQuiznum(rs.getInt("quiznum"));
				answer.setStu_answer(rs.getString("stu_answer"));
				answer.setRegdate(rs.getString("regdate"));

				return answer;
			}
		} catch (SQLException e) {
		}
		// 결과가 없다면 null 리턴
		return null;
	}

	/**
	 * 학생아이디로 선생이 목록을 보기 위해
	 * @param studentid
	 * @param quiznum
	 * @return
	 */
	public AnswerDTO getAnswerByStudentid(String studentid, int quiznum) {

		String sql = "select a.answerid,a.cl_id,a.quiznum,a.stu_answer,a.regdate from answer a inner join course_list on a.cl_id = course_list.cl_id inner join student on course_list.studentid = student.studentid where student.studentid = ? and a.quiznum =  ? ;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentid);
			ps.setInt(2, quiznum);

			rs = ps.executeQuery();
			if (rs.next()) {
				AnswerDTO answer = new AnswerDTO();
				answer.setAnswerid(rs.getInt("answerid"));
				answer.setCl_id(rs.getInt("cl_id"));
				answer.setQuiznum(rs.getInt("quiznum"));
				answer.setStu_answer(rs.getString("stu_answer"));
				answer.setRegdate(rs.getString("regdate"));

				return answer;
			}
		} catch (SQLException e) {
		}
		// 결과가 없다면 null 리턴
		return null;
	}
}
