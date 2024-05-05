package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.CourseListDAO;
import model.dao.LectureDAO;
import model.dao.MessengerDAO;
import model.dto.MessengerDTO;
import model.dto.StudentDTO;
import model.dto.TeacherDTO;

public class MessengerController {

	/**
	 * 메세지 보내기 
	 * 	학생이면 티처아이디로 cl_id 찾아와서 입력해주고
	 * 	티처면 학생아이디로 cl_id 찾아와서 넣어주기	
	 * @param message
	 * @return
	 */
	public boolean sendMessenger(MessengerDTO message) {
		CourseListDAO cdao = new CourseListDAO();
		MessengerDTO mdto = new MessengerDTO();
		MessengerDAO mdao = new MessengerDAO();

		if (Session.getData("loginTeacher") != null) {
			int cl_id = cdao.getCl_idByStudentid(message.getId()).getCl_id();
			mdto = new MessengerDTO(0, message.getMsg_title(), cl_id, null, message.getMsg_detail(), 1);
		} else {
			String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
			int cl_id = cdao.getCl_idByStudentid(studentid).getCl_id();
			mdto = new MessengerDTO(0, message.getMsg_title(), cl_id, null, message.getMsg_detail(), 0);
		}

		return mdao.sendMessenger(mdto);
	}

	/**
	 * 메세지 답장 
	 * @param message
	 * @return
	 */
	public boolean replyMessenger(MessengerDTO message) {
		MessengerDAO mdao = new MessengerDAO();
		return mdao.sendMessenger(message);
	}

	/**
	 * 메세지 내용 가져오기
	 * 	선생이면 cl_id값으로 학생아이디 찾아와서 MessengerDTO에 id로 세팅
	 * 	학생이면 cl_id값으로 렉처아이디 가져와서 렉처아이디로 티처아이디 가져와서  MessengerDTO에 id로 세팅
	 * @param messegenum = 메세지 번호
	 * @return
	 */
	public MessengerDTO getMsgDetail(int messegenum) {
		MessengerDAO mdao = new MessengerDAO();
		LectureDAO ldao = new LectureDAO();
		CourseListDAO cdao = new CourseListDAO();
		MessengerDTO msg = mdao.findMessengerNum(messegenum);

		String userid;
		if (Session.getData("loginTeacher") instanceof TeacherDTO) {
			userid = cdao.getList(msg.getCl_id()).getStudentid();
		} else {
			userid = ldao.findLectureById(cdao.getList(msg.getCl_id()).getLectureid()).getTeacherid();
		}

		return new MessengerDTO(msg.getMsg_num(), msg.getMsg_title(), userid, msg.getSendtime(), msg.getMsg_detail(),
				msg.getGNT());
	}

	/**
	 * 학생한명 메신저 전체가져오기
	 * @return
	 */
	public ArrayList<MessengerDTO> getMessengerListByClIdStudent() {
		CourseListDAO cdao = new CourseListDAO();
		MessengerDAO mdao = new MessengerDAO();
				
		String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
		int cl_id = cdao.getCl_idByStudentid(studentid).getCl_id();

		return mdao.getStuMessengerListByClId(cl_id);
	}

	/**
	 * 선생한명 메신저 전체가져오기
	 * @return
	 */
	public ArrayList<MessengerDTO> getMessengerListByClIdTeacher() {
		MessengerDAO mdao = new MessengerDAO();

		String teacherid = ((TeacherDTO) Session.getData("loginTeacher")).getTeacherid();

		return mdao.getTeaMessengerListByTeacherid(teacherid);
	}

}
