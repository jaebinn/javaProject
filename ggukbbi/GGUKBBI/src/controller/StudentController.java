package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.AnswerDAO;
import model.dao.CommentDAO;
import model.dao.CourseListDAO;
import model.dao.GradingDAO;
import model.dao.MessengerDAO;
import model.dao.StudentDAO;
import model.dto.AnswerDTO;
import model.dto.CommentDTO;
import model.dto.CourseListDTO;
import model.dto.GradingDTO;
import model.dto.MessengerDTO;
import model.dto.StudentDTO;
import model.dto.TeacherDTO;

public class StudentController {
	/**
	 * 학생 아이디 중복체크
	 * @param studentid  
	 * @return 
	 */
	public boolean checkId(String studentid) {
		StudentDAO sdao = new StudentDAO();
		return sdao.findStudentById(studentid) == null;
	}
	/**
	 * 학생 회원가입
	 * @param student
	 * @return
	 */
	public boolean join(StudentDTO student) {
		StudentDAO sdao = new StudentDAO();
		return sdao.insertStudent(student);
	}
	/**
	 * 학생 로그인
	 * @param studentid
	 * @param stu_pw
	 * @return
	 */
	public boolean login(String studentid, String stu_pw) {
		// 넘겨받은 아이디로 학생을 찾아보고, 찾은 학생의 비밀번호가 넘겨받은 비밀번호와 같다면 로그인 성공
		StudentDAO sdao = new StudentDAO();
		// 넘겨받은 아이디로 유저찾기(데이터 로직) - 재사용
		StudentDTO student = sdao.findStudentById(studentid);
		// 강사가 찾아졌다면
		if (student != null) {
			// 찾은 강사의 비밀번호도 비교(비즈니스 로직)
			if (student.getStu_pw().equals(stu_pw)) {
				// 로그인 성공했으면 세션에 세팅
				Session.setData("loginStudent", student);
				return true;
			}
		}
		return false;
	}
	/**
	 * 학생 회원탈퇴
	 * @param studentid
	 * @return
	 */
	public boolean leaveId(String studentid) {
		// 탈퇴 시 그 사람이 올렸던 모든 것들을 삭제해주어야 함
		CourseListDAO cdao = new CourseListDAO();
		CommentDAO cmdao = new CommentDAO();
		MessengerDAO mdao = new MessengerDAO();
		StudentDAO sdao = new StudentDAO();
		AnswerDAO adao = new AnswerDAO();
		GradingDAO gdao = new GradingDAO();

		// 현재 탈퇴하려는 사람의 모든 목록 불러와서
		int cl_id = ((CourseListDTO) cdao.getCl_idByStudentid(studentid)).getCl_id();
		ArrayList<CommentDTO> list2 = cmdao.getList(studentid);
		ArrayList<MessengerDTO> list3 = mdao.getList(cl_id);
		ArrayList<AnswerDTO> list4 = adao.getList(cl_id);
		ArrayList<GradingDTO> list5 = gdao.getListByCl_id(cl_id);

		if (list5 != null) {
			for (GradingDTO grading : list5) {
				gdao.deleteGradingByAnswerid(grading.getAnswerid());
			}
		}

		if (list4 != null) {
			adao.deleteByCl_id(cl_id);
		}

		if (list3 != null) {
			mdao.deleteMessengerByCl_ID(cl_id);
		}

		if (list2 != null) {
			for (CommentDTO comment : list2) {
				cmdao.deleteByCommentnum(comment.getCommentnum());
			}
		}

		cdao.deleteCourseList(cl_id);

		// 학생 정보에서 이 사람의 정보를 삭제
		sdao.deleteStudent(studentid);

		// 학생정보가 삭제되었기 때문에 세션 정보도 더이상 유지해서는 안된다.
		Session.setData("loginStudent", null);
		return true;
	}

	/**
	 * 강사에 속한 학생목록가져오기
	 * @return
	 */
	public ArrayList<StudentDTO> getStudentListByTeacherId() {
		StudentDAO sdao = new StudentDAO();
		String teacherid = ((TeacherDTO) Session.getData("loginTeacher")).getTeacherid();

		return sdao.getStudentListByTeacherId(teacherid);
	}

	/**
	 * 학생 정보 업데이트
	 * @param choice : 1(비밀번호 수정 - 1열), 2(핸드폰번호 수정 - 4열), 3(주소 수정 - 5열)
	 * @param loginStudent
	 * @param newdata
	 * @return
	 */
	public boolean updateStudent(int choice, String loginStudent, String newdata) {
		StudentDAO sdao = new StudentDAO();
		return sdao.updateStudent(choice, loginStudent, newdata);
	}
	/**
	 * 학생아이디로 학생아이디 찾기
	 * @param loginStudent
	 * @return
	 */
	public StudentDTO findStudentById(String loginStudent) {
		StudentDAO sdao = new StudentDAO();
		return sdao.findStudentById(loginStudent);
	}
	/**
	 * 강의 아이디로 속한 학생목록 가져오기 
	 * @param lectureId
	 * @return
	 */
	public ArrayList<StudentDTO> getStudentListByLectureid(int lectureId) {
		StudentDAO sdao = new StudentDAO();
		return sdao.getStundentListByLectureid(lectureId);
	}
	/**
	 * 학생아이디로 학생 데이터 삭제
	 * @param studentid
	 * @return
	 */
	public boolean deleteId(String studentid) {
		StudentDAO sdao = new StudentDAO();

		return sdao.deleteStudent(studentid);
	}
}