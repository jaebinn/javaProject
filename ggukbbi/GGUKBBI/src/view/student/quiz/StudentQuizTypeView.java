package view.student.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentQuizTypeView {
	public StudentQuizTypeView() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n=========시험문제 타입 선택=========\n");
				System.out.println("1. 자바 2. html 3. dbms 4. 뒤로가기");
				int choice = sc.nextInt();
				if (choice == 4) {
					break;
				} else if (choice == 1 || choice == 2 || choice == 3) {
					new Stu_QuizSelectView(choice);
				} else {
					System.out.println("\n번호를 잘못입력하셨습니다.\n");
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}

	}
}