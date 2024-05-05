package view.manager.lecture;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.LectureController;
import model.dto.LectureDTO;

public class LectureSelectView {
	public LectureSelectView() {
		Scanner sc = new Scanner(System.in);
		LectureController controller = new LectureController();

		ArrayList<LectureDTO> list = controller.getList();
		if (list.size() == 0) {
			System.out.println("\n등록된 강의가 없습니다!\n");
		} else {
			System.out.println("\n============등록된 강의 목록============\n");
			for (LectureDTO lecture : list) {
				System.out.printf("강의 번호 : %s\n강의 이름 : %s\n반 이름 : %s\n시작날짜 : %s\n강사 : %s\n",
						lecture.getLectureid(), lecture.getLec_name(), lecture.getClassroomid(),
						lecture.getLec_beginday(), lecture.getTeacherid());
				System.out.println("\n===================================\n");
			}
		}
		while (true) {
			try {
				sc = new Scanner(System.in);
				System.out.println("1. 강의 수정\n2. 뒤로가기");
				System.out.print("입력: ");
				int choice = sc.nextInt();
				if (choice == 2) {
					break;
				}
				switch (choice) {
				case 1:
					new LectureUpdateView();
					break;
				default:
					System.out.println("\n다시 입력해주세요.\n");
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (NullPointerException npe) {
				System.out.println("\n문제가 없습니다.\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
