package view.teacher.announcement;

import java.util.Scanner;

import controller.AnnouncementController;
import model.dto.AnnouncementDTO;

public class AnnouncementInsertView {
	public AnnouncementInsertView() {
		Scanner sc = new Scanner(System.in);
		AnnouncementController controller = new AnnouncementController();
		System.out.println("\n========공지사항 등록========\n");
		System.out.println("공지사항 제목 : ");
		String am_title = sc.nextLine();
		sc = new Scanner(System.in);
		System.out.println("공지사항 내용 : ");
		String am_detail = sc.nextLine();

		AnnouncementDTO adto = new AnnouncementDTO(0, am_title, null, am_detail, 0, null);

		if (controller.WriteAnnouncement(adto)) {
			System.out.println("\n🎉공지사항 등록 완료🎉\n");
		} else {
			System.out.println("\n공지사항 등록 실패\n");
		}
	}
}