package view.crawling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContinueChoiceView {
	private int continueChoice;

	public ContinueChoiceView() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("이어서 학습하시겠습니까? (1: 예, 0: 아니오)");
				continueChoice = sc.nextInt();

				if (continueChoice == 1) {
					break;
				} else if (continueChoice == 0) {
					System.out.println("학습을 종료합니다.");
					System.out.println();
					break;
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("숫자를 입력해주세요");
			} catch (Exception e) {
				System.out.println("알수없는 오류 발생 / 중간에 창을 닫지 마세요.");
			}
		}
	}

	public int getContinueChoice() {
		return continueChoice;
	}
}
