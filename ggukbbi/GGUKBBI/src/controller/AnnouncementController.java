package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.AnnouncementDAO;
import model.dao.CommentDAO;
import model.dao.CourseListDAO;
import model.dao.LectureDAO;
import model.dto.AnnouncementDTO;
import model.dto.StudentDTO;
import model.dto.TeacherDTO;

public class AnnouncementController {
	/**
	 * 자기반 공지사항 전체리스트
	 * @return
	 */
	public ArrayList<AnnouncementDTO> getAnnouncementList() {
		AnnouncementDAO adao = new AnnouncementDAO();
		CourseListDAO cdao = new CourseListDAO();
		LectureDAO ldao = new LectureDAO();
		String teacherid ="";
		if(Session.getData("loginTeacher") != null) {
			teacherid = ((TeacherDTO)Session.getData("loginTeacher")).getTeacherid();
		}else {
			String studentid = ((StudentDTO)Session.getData("loginStudent")).getStudentid();
			int lectureId = (cdao.getCl_idByStudentid(studentid)).getLectureid();
			teacherid = (ldao.findLectureById(lectureId)).getTeacherid();
		}
		return adao.getAnnouncementList(teacherid);
	}

	/**
	 * 공지사항 번호로 내용 가져오기
	 * @param announcenum = 공지사항번호
	 * @return
	 */
	public AnnouncementDTO getDetail(int announcenum) {
		AnnouncementDAO adao = new AnnouncementDAO();
		return adao.findAnnounceNum(announcenum);
	}

	/** 
	 * 공지사항 번호에 따른 공지사항 수정 
	 * @param announcenum = 공지사항번호
	 * @param choice = 1:제목, 2:내용
	 * @param newData = 바꿀내용
	 * @return
	 */
	public boolean UpdateAnnouncement(int announcenum, int choice, String newData) {
		AnnouncementDAO adao = new AnnouncementDAO();

		return adao.updateAnnouncement(announcenum, choice, newData);
	}

	/**
	 * 공지사항 번호에 따른 공지사항 삭제
	 * @param announcenum = 공사항번호
	 * @return
	 */
	public boolean DeleteAnnouncement(int announcenum) {
		AnnouncementDAO adao = new AnnouncementDAO();
		CommentDAO cdao = new CommentDAO();
		// 공지사항 안에 댓글 삭제
		cdao.deleteByAnnouncenum(announcenum);

		return adao.deleteByAnnouncementNum(announcenum);
	}

	/**
	 * 공지사항 등록
	 * @param announcement
	 * @return
	 */
	public boolean WriteAnnouncement(AnnouncementDTO announcement) {
		AnnouncementDAO adao = new AnnouncementDAO();
		String teacherid = ((TeacherDTO) Session.getData("loginTeacher")).getTeacherid();
		announcement.setTeacherid(teacherid);
		return adao.insertAnnouncement(announcement);
	}

	/**
	 * 학생이 공지사항 보면 조회수증가
	 * @param choice = 공지사항번호
	 * @return
	 */
	public AnnouncementDTO announcementCounter(int choice) {
		AnnouncementDAO adao = new AnnouncementDAO();
		return adao.announcementCounter(choice);
	}
}
