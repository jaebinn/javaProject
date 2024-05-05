package view.crawling;

import controller.VideoController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VideoLectureView {
	private VideoController videoController;

	public VideoLectureView() {
		this.videoController = new VideoController();
		while (true) {
			System.out.println("\n=====영상강의=====\n");
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			try {
				System.out.println("1. 자바\n2. HTML\n3. MYSQL\n4. 뒤로가기");
				choice = sc.nextInt();
				if (choice == 4) {
					break;
				} else {
					switch (choice) {
					case 1:
						videoController.videoJavaController();
						break;
					case 2:
						videoController.videoHtmlController();
						break;
					case 3:
						videoController.videoSqlController();
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
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생 / 중간에 창을 닫지 마세요.\n");
			}
		}
	}
}
