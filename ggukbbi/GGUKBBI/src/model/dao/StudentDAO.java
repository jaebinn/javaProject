package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.StudentDTO;

public class StudentDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public StudentDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * 학생 정보 삽입
	 * 
	 * @param student
	 * @return
	 */
	public boolean insertStudent(StudentDTO student) {
		String sql = "insert into student (studentid, stu_pw, stu_name, stu_age, stu_gender, stu_addr, stu_major, stu_phone)"
				+ "values(?,?,?,?,?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStudentid());
			ps.setString(2, student.getStu_pw());
			ps.setString(3, student.getStu_name());
			ps.setInt(4, student.getStu_age());
			ps.setString(5, student.getStu_gender());
			ps.setString(6, student.getStu_addr());
			ps.setString(7, student.getStu_major());
			ps.setString(8, student.getStu_phone());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 학생아디로 학생 정보 조회
	 * 
	 * @param studentid
	 * @return
	 */
	public StudentDTO findStudentById(String studentid) {
		// 데이터 로직은 순수하게 데이터에 관련된 로직만 구성되어 있다.
		// API 이용해서 데이터베이스에 접근 후 객체로 리턴

		// 검색
		String sql = "select * from student where studentid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentid);

			rs = ps.executeQuery();

			if (rs.next()) {
				StudentDTO student = new StudentDTO();
				student.setStudentid(rs.getString("studentid"));
				student.setStu_pw(rs.getString("stu_pw"));
				student.setStu_name(rs.getString("stu_name"));
				student.setStu_age(rs.getInt("stu_age"));
				student.setStu_gender(rs.getString("stu_gender"));
				student.setStu_addr(rs.getString("stu_addr"));
				student.setStu_major(rs.getString("stu_major"));
				student.setStu_phone(rs.getString("stu_phone"));

				return student;
			}
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * 학생 정보 업데이트
	 * 
	 * @param choice    : 1(비밀번호 수정 - 1열), 2(핸드폰번호 수정 - 4열), 3(주소 수정 - 5열)
	 * @param studentid
	 * @param newData
	 * @return
	 */
	public boolean updateStudent(int choice, String studentid, String newData) {
		String[] cols = { "", "stu_pw", "stu_phone", "stu_addr" };
		String sql = "update student set " + cols[choice] + " = ? where studentid = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, studentid);

			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}

		return false;
	}

	/**
	 * 학생 정보 삭제
	 * 
	 * @param studentid
	 * @return
	 */
	public boolean deleteStudent(String studentid) {
		String sql = "delete from student where studentid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentid);

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/**
	 * 강사아이디로 강의에 속한 학생 목록 조회
	 * 
	 * @param teacherid
	 * @return
	 */
	public ArrayList<StudentDTO> getStudentListByTeacherId(String teacherid) {
		String sql = "select s.studentid,s.stu_pw,s.stu_name,s.stu_age,s.stu_gender,s.stu_addr, "
				+ "s.stu_major,s.stu_phone from student s "
				+ "inner join course_list on s.studentid = course_list.studentid "
				+ "inner join lecture on course_list.lectureid = lecture.lectureid "
				+ "inner join teacher on lecture.teacherid = teacher.teacherid where teacher.teacherid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacherid);

			rs = ps.executeQuery();

			ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();

			while (rs.next()) {
				StudentDTO student = new StudentDTO(rs.getString("studentid"), rs.getString("stu_pw"),
						rs.getString("stu_name"), rs.getInt("stu_age"), rs.getString("stu_gender"),
						rs.getString("stu_addr"), rs.getString("stu_major"), rs.getString("stu_phone"));

				list.add(student);
			}
			return list;

		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 퀴즈번호로 답한 학생목록 조회
	 * 
	 * @param quiznum
	 * @return
	 */
	public ArrayList<StudentDTO> getStudentByQuiznum(int lectureid, int quiznum) {
		String sql = "select s.studentid,s.stu_pw,s.stu_name,s.stu_age,s.stu_gender,s.stu_addr,s.stu_major,s.stu_phone "
				+ "from student s inner join course_list on s.studentid = course_list.studentid "
				+ "inner join answer on course_list.cl_id = answer.cl_id "
				+ "inner join quiz on answer.quiznum = quiz.quiznum "
				+ "inner join lecture l on course_list.lectureid = l.lectureid where l.lectureid = ? and quiz.quiznum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lectureid);
			ps.setInt(2, quiznum);

			rs = ps.executeQuery();

			ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();

			while (rs.next()) {
				StudentDTO student = new StudentDTO(rs.getString("studentid"), rs.getString("stu_pw"),
						rs.getString("stu_name"), rs.getInt("stu_age"), rs.getString("stu_gender"),
						rs.getString("stu_addr"), rs.getString("stu_major"), rs.getString("stu_phone"));

				list.add(student);
			}
			return list;

		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 특정 강의에 속한 학생 목록조회
	 * 
	 * @param lectureId
	 * @return
	 */
	public ArrayList<StudentDTO> getStundentListByLectureid(int lectureId) {
		String sql = "select s.studentid,s.stu_pw,s.stu_name,s.stu_age,s.stu_gender,s.stu_addr,s.stu_major,s.stu_phone "
				+ "from course_list c " + "inner join student s on c.studentid = s.studentid " + "where c.lectureid = ?"
				+ ";";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lectureId);

			rs = ps.executeQuery();

			ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();

			while (rs.next()) {
				StudentDTO student = new StudentDTO(rs.getString("studentid"), rs.getString("stu_pw"),
						rs.getString("stu_name"), rs.getInt("stu_age"), rs.getString("stu_gender"),
						rs.getString("stu_addr"), rs.getString("stu_major"), rs.getString("stu_phone"));

				list.add(student);
			}
			return list;

		} catch (Exception e) {
		}
		return null;
	}

}