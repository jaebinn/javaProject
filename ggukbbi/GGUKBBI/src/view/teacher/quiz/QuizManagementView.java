package view.teacher.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuizManagementView {
	public QuizManagementView() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("\n============시험 관리============\n");
				System.out.println("1. 시험 조회\n2. 뒤로가기");
				int choice = sc.nextInt();

				if (choice == 2) {
					break;
				} else if (choice == 1) {
					// 시험조회
					new QuizTypeView();
				} else {
					System.out.println("\n다시 입력해주세요.\n");
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
