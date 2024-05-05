package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DBConnection;
import model.dto.CommentDTO;

public class CommentDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public CommentDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * 댓글 등록
	 * @param studentid
	 * @param comment
	 * @return 성공 실패 여부
	 */
	public boolean insertcomment(String studentid, CommentDTO comment) {
		String sql = "insert into comment " + "values(0,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getAnnouncenum());
			ps.setString(2, studentid);
			ps.setString(3, comment.getComment_detail());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/**
	 * 댓글 번호를 이용한 삭제
	 * @param commentnum
	 * @return 성공 실패 여부
	 */
	public boolean deleteByCommentnum(int commentnum) {
		String sql = "delete from comment where commentnum = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, commentnum);
			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/**
	 * 공지번호로 댓글 삭제
	 * @param announcenum
	 * @return 성공실패여부
	 */
	public boolean deleteByAnnouncenum(int announcenum) {
		String sql = "delete from comment where announcenum = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, announcenum);
			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}


	
	/**
	 * 댓글 리스트
	 * @param studentid
	 * @return
	 */
	public ArrayList<CommentDTO> getList(String studentid) {
		String sql = "select * from comment where studentid =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentid);
			rs = ps.executeQuery();

			ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();

			while (rs.next()) {
				CommentDTO comment = new CommentDTO(rs.getInt("commentnum"), rs.getInt("announcenum"),
						rs.getString("studentid"), rs.getString("comment_detail"));

				list.add(comment);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * 공지번호로 댓글보기
	 * @param announcenum
	 * @return
	 */
	public ArrayList<CommentDTO> findStudentCommentByAnnounceNum(int announcenum) {
		String sql = "select c.commentnum, s.stu_name, c.studentid, c.comment_detail from comment c "
				+ "join announcement a on a.announcenum = c.announcenum "
				+ "join student s on c.studentid = s.studentid " + "where a.announcenum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, announcenum);

			rs = ps.executeQuery();
			ArrayList<CommentDTO> list = new ArrayList<CommentDTO>(); // 리스트를 먼저 초기화

			while (rs.next()) {
				CommentDTO comment = new CommentDTO(rs.getInt("commentnum"), rs.getString("comment_detail"),
						rs.getString("stu_name"), rs.getString("studentid"));

				list.add(comment);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 결과가 없다면 null 리턴
		return null;
	}

	/**
	 * 내 댓글보기 
	 * @param announcenum
	 * @param studentid
	 * @return
	 */
	public ArrayList<CommentDTO> divideMyCommentByStudentId(int announcenum, String studentid) {
		String sql = "SELECT c.commentnum, c.announcenum, c.studentid, s.stu_name, c.comment_detail "
				+ "FROM comment c " + "JOIN announcement a ON a.announcenum = c.announcenum "
				+ "JOIN student s ON c.studentid = s.studentid " + "WHERE a.announcenum = ? " + "AND s.studentid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, announcenum);
			ps.setString(2, studentid);

			rs = ps.executeQuery();

			ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();

			while (rs.next()) {
				CommentDTO comment = new CommentDTO(rs.getInt("commentnum"), rs.getInt("announcenum"),
						rs.getString("studentid"), rs.getString("comment_detail"), rs.getString("stu_name")

				);

				list.add(comment);
			}

			return list;
		} catch (SQLException e) {
		}
		// 결과가 없다면 null 리턴
		return null;
	}

	/**
	 * 남의 댓글 보기
	 * @param announcenum
	 * @param studentid
	 * @return
	 */
	public ArrayList<CommentDTO> divideCommentAnotherId(int announcenum, String studentid) {
		String sql = "SELECT c.commentnum, c.announcenum, c.studentid, s.stu_name, c.comment_detail "
				+ "FROM comment c " + "JOIN announcement a ON a.announcenum = c.announcenum "
				+ "JOIN student s ON c.studentid = s.studentid " + "WHERE a.announcenum = ? " + "AND s.studentid != ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, announcenum);
			ps.setString(2, studentid);

			rs = ps.executeQuery();

			ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();

			while (rs.next()) {
				CommentDTO comment = new CommentDTO(rs.getInt("commentnum"), rs.getInt("announcenum"),
						rs.getString("studentid"), rs.getString("comment_detail"), rs.getString("stu_name"));

				list.add(comment);
			}

			return list;

		} catch (SQLException e) {
		}
		// 결과가 없다면 null 리턴
		return null;
	}

}