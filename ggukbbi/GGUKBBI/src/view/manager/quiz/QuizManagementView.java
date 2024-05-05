package view.manager.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuizManagementView {
	public QuizManagementView() {

		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n============시험관리============\n");
				System.out.println("1. 시험 조회\n2. 시험 등록\n3. 뒤로가기");
				int choice = sc.nextInt();

				if (choice == 3) {
					break;
				} else {
					switch (choice) {
					case 1: // 시험조회
						new QuizTypeView();
						break;
					case 2: // 시험등록
						new QuizAddView();
						break;
					default:
						System.out.println("\n다시 입력해주세요.\n");
					}
				}

			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}