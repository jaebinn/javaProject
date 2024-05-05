package view.teacher.announcement;

import java.util.ArrayList;

import controller.AnnouncementController;
import model.dto.AnnouncementDTO;

public class AnnouncementListView {
	public AnnouncementListView() {
		AnnouncementController controller = new AnnouncementController();

		while (true) {
			ArrayList<AnnouncementDTO> amList = controller.getAnnouncementList();
			if (amList.size() == 0) {
				System.out.println("\n등록된 공지사항이 없습니다...\n");
				break;
			} else {
				System.out.println("\n========공지사항 리스트========\n");
				for (AnnouncementDTO am : amList) {
					System.out.println(am.getAnnouncenum() + ". " + am.getAm_title());
				}
				System.out.println("\n===========================\n");
				new AnnouncementSelectView();
				break;
			}
		}
	}
}