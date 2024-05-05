package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.QuizDTO;

public class QuizDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public QuizDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * 퀴즈등록
	 * @param quiz
	 * @return
	 */
	public boolean insertQuiz(QuizDTO quiz) {
		String sql = "insert into quiz (quiz_title,quiz_type,quiz_detail,quizans)" + "values(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, quiz.getQuiz_title());
			ps.setString(2, quiz.getQuiz_type());
			ps.setString(3, quiz.getQuiz_detail());
			ps.setString(4, quiz.getQuizans());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/**
	 * 퀴즈삭제
	 * @param quiznum
	 * @return
	 */
	public boolean deleteByQuizNum(int quiznum) {
		String sql = "delete from quiz where quiznum = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, quiznum);
			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	
	/**
	 * 퀴즈번호로 퀴즈 가져오기
	 * @param quiznum = 퀴즈번호
	 * @return
	 */
	public QuizDTO findQuizNum(int quiznum) {
		String sql = "select * from quiz where quiznum = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, quiznum);

			rs = ps.executeQuery();
			if (rs.next()) {
				QuizDTO quiz = new QuizDTO();
				quiz.setQuiznum(rs.getInt("quiznum"));
				quiz.setQuiz_type(rs.getString("quiz_type"));
				quiz.setQuiz_title(rs.getString("quiz_title"));
				quiz.setQuiz_detail(rs.getString("quiz_detail"));
				quiz.setQuizans(rs.getString("quizans"));

				return quiz;
			}
		} catch (SQLException e) {
		}
		// 결과가 없다면 null 리턴
		return null;
	}

	/**
	 * 퀴즈타입 별 리스트 가져오기
	 * @param choice = 1.java 2.html 3.dbms
	 * @return
	 */
	public ArrayList<QuizDTO> getList(int choice) {
		String cols[] = { "", "java", "html", "dbms" };
		String sql = "select * from quiz where quiz_type = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cols[choice]);
			rs = ps.executeQuery();

			ArrayList<QuizDTO> list = new ArrayList<QuizDTO>();

			while (rs.next()) {
				QuizDTO quiz = new QuizDTO(rs.getInt("quiznum"), rs.getString("quiz_type"), rs.getString("quiz_title"),
						rs.getString("quiz_detail"), rs.getString("quizans"));

				list.add(quiz);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * 학생이 타입별로 푼 퀴즈 리스트 가져오기
	 * @param studentid = 학생 아이디
	 * @param choice = 1.java 2.html 3.dbms
	 * @return
	 */
	public ArrayList<QuizDTO> getSolveList(String studentid, int choice) {
		String[] cols = { "", "java", "html", "dbms" };
		String sql = "select q.quiznum,q.quiz_type,q.quiz_title,q.quiz_detail,q.quizans "
				+ "from quiz q inner join answer on q.quiznum = answer.quiznum inner join "
				+ "course_list on answer.cl_id = course_list.cl_id inner join student on "
				+ "course_list.studentid = student.studentid where q.quiz_type = ? " + "and student.studentid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cols[choice]);
			ps.setString(2, studentid);
			rs = ps.executeQuery();

			ArrayList<QuizDTO> list = new ArrayList<QuizDTO>();

			while (rs.next()) {
				QuizDTO quiz = new QuizDTO(rs.getInt("quiznum"), rs.getString("quiz_type"), rs.getString("quiz_title"),
						rs.getString("quiz_detail"), rs.getString("quizans"));

				list.add(quiz);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}
}
