package view.manager.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuizTypeView {
	public QuizTypeView() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n============시험 조회============\n");
				System.out.println("1. 자바\n2. HTML\n3. DBMS\n4. 뒤로가기");
				int choice = sc.nextInt();

				if (choice == 4) {
					break;
				} else if (choice < 1 && choice > 3) {
					System.out.println("\n다시 입력해주세요.\n");
					continue;
				} else {
					new QuizView(choice);
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