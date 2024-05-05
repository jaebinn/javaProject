package controller;

import java.util.ArrayList;

import model.dao.LectureDAO;
import model.dto.LectureDTO;

public class LectureController {

	/**
	 * 모든 강좌목록 시작일 기준으로 내림차순으로 가져오기
	 * @return
	 */
	public ArrayList<LectureDTO> getList() {
		LectureDAO ldao = new LectureDAO();
		return ldao.getList();
	}

	/**
	 * 강좌 수정
	 * @param choice = 1 : lec_name, 2 : classroomid, 3 : lec_beginday, 4 : teacherid
	 * @param lectureid
	 * @param newData = 변경할 내용
	 * @return
	 */
	public boolean updateLecture(int choice, int lectureid, String newData) {
		LectureDAO ldao = new LectureDAO();
		return ldao.updateLecture(choice, lectureid, newData);
	}

	/**
	 * 강좌등록
	 * @param lecture
	 * @return
	 */
	public boolean insertLecture(LectureDTO lecture) {
		LectureDAO ldao = new LectureDAO();
		return ldao.insertLecture(lecture);
	}

	/**
	 * 렉처id로 강좌 내용 가져오기
	 * @param lectureId
	 * @return
	 */
	public LectureDTO findLectureByLectureid(int lectureId) {
		LectureDAO ldao = new LectureDAO();
		return ldao.findLectureById(lectureId);
	}
	
}
