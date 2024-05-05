package view.teacher.announcement;

import java.util.ArrayList;

import controller.AnnouncementController;
import model.dto.AnnouncementDTO;

public class AnnouncementView {
	public AnnouncementView() {
		// 공지사항 출력
		AnnouncementController Amcontroller = new AnnouncementController();
		ArrayList<AnnouncementDTO> amList = new ArrayList<AnnouncementDTO>();

		for (AnnouncementDTO am : amList) {
			System.out.println(am.getAnnouncenum() + ". " + am.getAm_title());

		}
	}
}
