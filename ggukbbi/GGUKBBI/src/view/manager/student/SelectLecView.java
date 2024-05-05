package view.manager.student;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.LectureController;

public class SelectLecView {
	public SelectLecView() {
		Scanner sc = new Scanner(System.in);
		LectureController lecController = new LectureController();

		while (true) {
			try {
				System.out.println("-1을 입력 시 뒤로가기");
				System.out.print("정보가 필요한 수강생의 강의 번호를 입력해주세요. : ");
				int choice = sc.nextInt();

				if (choice == -1) {
					break;
				} else {
					if (lecController.findLectureByLectureid(choice) == null) {
						new SelectStudentView(choice);
					} else {
						System.out.println("강의가 없는 번호입니다. 다시입력해주세요");
					}
				}
			} catch (InputMismatchException ime) {
				System.out.println("숫자를 입력해주세요");
			} catch (NullPointerException npe) {
				System.out.println("문제가 없습니다.");
			} catch (Exception e) {
				System.out.println("알수 없는 오류 발생");
			}

		}

	}
}
