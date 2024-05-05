package view.manager.lecture;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LectureManagementView {
	public LectureManagementView() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n============강의관리============\n");
				System.out.println("1. 강의 조회\n2. 강의 개설\n3. 뒤로가기");
				System.out.print("입력: ");
				int choice = sc.nextInt();

				if (choice == 3) {
					//3. 뒤로가기
					break;
				}
				switch (choice) {
				case 1:
					//1. 강의 조회
					new LectureSelectView();
					break;
				case 2:
					//2. 강의 개설
					new LectureRegisterView();
					break;
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
