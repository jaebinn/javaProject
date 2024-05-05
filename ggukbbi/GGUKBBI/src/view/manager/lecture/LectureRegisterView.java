package view.manager.lecture;

import java.util.Scanner;

import controller.LectureController;
import model.dto.LectureDTO;

public class LectureRegisterView {
	public LectureRegisterView() {
		Scanner sc = new Scanner(System.in);
		LectureController controller = new LectureController();

		// (이름: lec_name / 반: classroomid / 시작: lec_beginday / 강사: teacherid)
		System.out.print("강의 이름 : ");
		String lec_name = sc.nextLine();
		System.out.print("강의 반 : ");
		String classroomid = sc.next();
		System.out.print("강의 시작 날짜 : ");
		String lec_beginday = sc.next();
		System.out.print("강사 이름 : ");
		String teacherid = sc.next();

		LectureDTO lecture = new LectureDTO(0, lec_name, classroomid, lec_beginday, teacherid);

		// 포장된 객체 컨트롤러로 넘기기
		if (controller.insertLecture(lecture)) {
			System.out.println(lec_name + " 강의 추가 완료!");
		} else {
			System.out.println("강의 추가 실패 / 다시 시도해주세요.");
		}
	}
}
