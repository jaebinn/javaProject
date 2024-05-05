package view.manager.lecture;

import java.util.ArrayList;
import java.util.Scanner;

import controller.LectureController;
import model.dto.LectureDTO;

public class LectureUpdateView {
	public LectureUpdateView() {
		Scanner sc = new Scanner(System.in);
		LectureController controller = new LectureController();

		ArrayList<LectureDTO> lectureList = controller.getList();

		if (lectureList == null) {
			System.out.println("\n강의가 없습니다...\n");
		} else {
			System.out.println("\n============강의 수정============\n");
			System.out.print("수정할 강의 번호를 입력하세요: ");
			int lectureid = sc.nextInt();
			System.out.println("\n1. 강의이름\n2. 강의 반\n3. 시작날짜\n4. 강사이름");
			System.out.print("입력: ");
			int choice = sc.nextInt();
			System.out.print("수정할 정보 : ");
			String newData = sc.next();

			// 위에서 입력받은 세개의 정보를 컨트롤러에 넘겨주며 수정 요청
			if (controller.updateLecture(choice, lectureid, newData)) {
				System.out.println("\n" + lectureid + "번 강의 수정 완료!\n");
			} else {
				System.out.println("\n강의 수정 실패 / 다시 시도해주세요.\n");
			}
		}

	}
}
