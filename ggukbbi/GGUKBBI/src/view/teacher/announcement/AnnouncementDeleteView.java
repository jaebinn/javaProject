package view.teacher.announcement;

import java.util.Scanner;

import controller.AnnouncementController;

public class AnnouncementDeleteView {
	public AnnouncementDeleteView() {
		Scanner sc = new Scanner(System.in);
		AnnouncementController acontroller = new AnnouncementController();
		System.out.print("삭제할 공지사항 번호를 고르세요:");
		int announcenum = sc.nextInt();

		if (acontroller.DeleteAnnouncement(announcenum)) {
			System.out.println("공지사항 삭제되었습니다");
		} else {
			System.out.println("공지사항 삭제 실패...");
		}
	}
}
