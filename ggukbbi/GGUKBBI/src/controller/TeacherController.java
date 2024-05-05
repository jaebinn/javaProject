package controller;

import model.Session;
import model.dao.TeacherDAO;
import model.dto.TeacherDTO;

public class TeacherController {

	/**
	 * 티처 아이디가 데이터 베이스에 있는지 확인
	 * 있으면 회원가입 불가능.
	 * @param teacherid
	 * @return
	 */
	public boolean checkId(String teacherid) {
		TeacherDAO tdao = new TeacherDAO();
		//티처 데이터가 없어야 리턴
		return tdao.findTeacherById(teacherid) == null;
	}

	/**
	 * 받은 티처 객체 데이터베이스로 삽입
	 * @param teacher
	 * @return
	 */
	public boolean join(TeacherDTO teacher) {
		// 전달받은 dto객체에 담긴 정보들을 데이터베이스에 삽입
		TeacherDAO tdao = new TeacherDAO();
		// 데이터 로직을 이용해서 데이터베이스 삽입
		return tdao.insertTeacher(teacher);
	}

	/**
	 * 티처id,pw 넘긴후 id 값이 같은 데이터 가져오기
	 * 그 이후에 객체로 담아서 객체가 있으면 객체안에 pw랑 입력받은 pw가 같은지
	 * 비교후 같으면 세션에 객체 담아서 세션에 키값으로"loginTeacher"
	 * teacher 객체 담아주기
	 * @param teacherid
	 * @param tea_pw
	 * @return
	 */
	public boolean login(String teacherid, String tea_pw) {
		// 넘겨받은 아이디로 강사를 찾아보고, 찾은 강사의 비밀번호가 넘겨받은 비밀번호와 같다면 로그인 성공
		TeacherDAO tdao = new TeacherDAO();
		// 넘겨받은 아이디로 유저찾기(데이터 로직) - 재사용
		TeacherDTO teacher = tdao.findTeacherById(teacherid);
		// 강사가 찾아졌다면
		if (teacher != null) {
			// 찾은 강사의 비밀번호도 비교(비즈니스 로직)
			if (teacher.getTea_pw().equals(tea_pw)) {
				// 로그인 성공했으면 세션에 세팅
				Session.setData("loginTeacher", teacher);
				return true;
			}
		}
		return false;
	}

	/**
	 * 티처아이디로 데이터 가져오기
	 * @param loginTeacher = 티처아이디
	 * @return
	 */
	public TeacherDTO findTeacherById(String loginTeacher) {
		TeacherDAO tdao = new TeacherDAO();
		return tdao.findTeacherById(loginTeacher);
	}

	/**
	 * 티처업데이트
	 * @param choice = 1.티처pw 2.티처phone
	 * @param loginTeacher
	 * @param newdata = 바꾸는 내용
	 * @return
	 */
	public boolean updateTeacher(int choice, String loginTeacher, String newdata) {
		TeacherDAO tdao = new TeacherDAO();
		return tdao.updateTeacher(choice, loginTeacher, newdata);
	}
}
