package view.teacher.announcement;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.AnnouncementController;

public class AnnouncementModifyView {
	public AnnouncementModifyView(int announcenum) {
		AnnouncementController controller = new AnnouncementController();
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n========공지사항 수정========\n");
				System.out.print("1. 제목\n2. 내용\n3. 뒤로가기");
				int choice = sc.nextInt();
				String newData = "";
				if (choice == 3) {
					break;
				}
				switch (choice) {
				case 1:
					System.out.println("수정할 제목: ");
					sc = new Scanner(System.in);
					newData = sc.nextLine();
					controller.UpdateAnnouncement(announcenum, choice, newData);
					break;
				case 2:
					System.out.println("수정할 내용: ");
					sc = new Scanner(System.in);
					newData = sc.nextLine();
					controller.UpdateAnnouncement(announcenum, choice, newData);
					break;
				default:
					System.out.println("\n다시 입력하세요.\n");
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
