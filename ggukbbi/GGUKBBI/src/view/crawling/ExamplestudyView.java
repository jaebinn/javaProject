package view.crawling;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ExampleController;

public class ExamplestudyView {
	public ExamplestudyView() {
		// 코딩공부 - 문제풀기
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);

				System.out.println("\n=====문제풀기=====\n");

				System.out.println("1. 자바문제\n2. MYSQL문제\n3. 뒤로가기");
				int choice = sc.nextInt();

				if (choice == 3) {
					break;
				}
				switch (choice) {
				case 1:
					ExampleController.exampleJava();
					break;
				case 2:
					ExampleController.exampleMySQL();
					break;
				default:
					System.out.println("\n다시 입력해주세요.\n");
				}
				int continueChoice = 1;
				ContinueChoiceView continueChoiceView = new ContinueChoiceView();
				continueChoice = continueChoiceView.getContinueChoice();
				if (continueChoice == 0) {
					break;
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생 / 중간에 창을 닫지 마세요.\n");
			}
		}
	}
}
