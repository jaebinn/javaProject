package view.crawling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CodeStudyView {
	public CodeStudyView() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			// 크롤링
			try {
				System.out.println("\n=====코딩공부=====\n");

				System.out.println("1. 영상강의\n2. 문제풀기\n3. 설치사이트\n4. 뒤로가기");
				choice = sc.nextInt();

				if (choice == 4) {
					break;
				} else {
					switch (choice) {
					case 1:
						// 영상강의 링크
						new VideoLectureView();
						break;
					case 2:
						// 문제풀기 링크 (프로그래머스)
						new ExamplestudyView();
						break;
					case 3:
						// 설치사이트
						new InstallSiteView();
						break;
					default:
						System.out.println("\n다시 입력해주세요.\n");
						break;
					}
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요.\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}

		}
	}
}
