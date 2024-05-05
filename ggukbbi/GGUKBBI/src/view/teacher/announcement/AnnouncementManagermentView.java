package view.teacher.announcement;

import java.util.InputMismatchException;

import java.util.Scanner;

public class AnnouncementManagermentView {
	public AnnouncementManagermentView() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n============공지사항 관리============\n");
				System.out.println("1. 공지사항 리스트보기\n2. 공지사항 등록하기\n3. 뒤로가기");
				int choice = sc.nextInt();

				if (choice == 3) {
					break;
				}
				switch (choice) {
				case 1:
					new AnnouncementListView();
					break;
				case 2:
					new AnnouncementInsertView();
					break;
				default:
					System.out.println("\n숫자를 정확히 입력해주세요.\n");
					break;
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
