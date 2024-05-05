package view.crawling;

import controller.InstallController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InstallSiteView {
	// 코딩공부 - 설치사이트 크롤링
	private InstallController installController;

	public InstallSiteView() {
		while (true) {

			this.installController = new InstallController();

			try {
				Scanner sc = new Scanner(System.in);

				System.out.println("\n=====설치사이트=====\n");

				System.out.println("1. Eclipse 설치\n2. HTML 설치\n3. MySQL 설치\n4. 뒤로가기");
				int choice = sc.nextInt();

				if (choice == 4) {
					break;
				}
				switch (choice) {
				case 1:
					installController.installEclipse();
					break;
				case 2:
					installController.installHTML();
					break;
				case 3:
					installController.installMySQL();
					break;
				default:
					System.out.println("\n다시 입력해주세요.\n");
					break;
				}
			} catch (InputMismatchException ime) {
				System.err.println("\n숫자를 입력해주세요.\n");
			} catch (Exception e) {
				System.err.println("\n알 수 없는 오류 발생 / 중간에 창을 닫지 마세요.\n");
			}
		}
	}
}
