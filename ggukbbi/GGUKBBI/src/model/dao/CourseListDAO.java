package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.DBConnection;
import model.dto.CourseListDTO;

public class CourseListDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public CourseListDAO() {
		conn = DBConnection.getConnection();
	}
	
	/**
	 * 수강 아이디 
	 * @param courseList
	 * @return
	 */
	public boolean insertCourse(CourseListDTO courseList) {
		String sql = "insert into course_list (cl_id, lectureid, studentid)" + "values(?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseList.getCl_id());
			ps.setInt(2, courseList.getLectureid());
			ps.setString(3, courseList.getStudentid());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		
		}

		return false;
	}

	
	/**
	 * 수강목록 
	 * @param cl_id
	 * @return
	 */
	public CourseListDTO getList(int cl_id) {
		String sql = "select * from course_list where cl_id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cl_id);
			rs = ps.executeQuery();

			if (rs.next()) {
				CourseListDTO course = new CourseListDTO();
				course.setCl_id(rs.getInt("cl_id"));
				course.setLectureid(rs.getInt("lectureid"));
				course.setStudentid(rs.getString("studentid"));

				return course;
			}
		} catch (SQLException e) {
		}
		return null;
	}


	/**
	 * 수강목록 삭제
	 * @param cl_id
	 * @return
	 */
	public boolean deleteCourseList(int cl_id) {
		String sql = "delete from course_list where cl_id = ?";
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
	 * 학생아이디로 cl_id 획득
	 * @param studentid
	 * @return
	 */
	public CourseListDTO getCl_idByStudentid(String studentid) {
		String sql = "select * from course_list where studentid = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentid);

			rs = ps.executeQuery();

			if (rs.next()) {
				CourseListDTO course = new CourseListDTO();
				course.setCl_id(rs.getInt("cl_id"));
				course.setLectureid(rs.getInt("lectureid"));
				course.setStudentid(rs.getString("studentid"));

				return course;
			}
		} catch (SQLException e) {
		}
		return null;
	}
}