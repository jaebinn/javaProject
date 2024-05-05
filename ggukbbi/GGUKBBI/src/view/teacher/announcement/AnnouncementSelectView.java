package view.teacher.announcement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.AnnouncementController;
import controller.CommentController;
import model.dto.AnnouncementDTO;
import model.dto.CommentDTO;

public class AnnouncementSelectView {
	public AnnouncementSelectView() {
		AnnouncementController controller = new AnnouncementController();
		CommentController comcontroller = new CommentController();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("-1 입력 시 뒤로가기");
			System.out.println("자세히 보고싶은 공지사항 번호를 입력해주세요!");
			System.out.print("번호 입력: ");
			int choice = sc.nextInt();
			controller.announcementCounter(choice);
			if (choice == -1) {
				break;
			} else {
				if (controller.getDetail(choice) == null) {
					System.out.println("\n해당하는 공지사항 번호가 없습니다.\n");
				} else {
					System.out.println("\n========공지사항========\n");
					AnnouncementDTO amList = controller.getDetail(choice);
					ArrayList<CommentDTO> comList = comcontroller.findCommentByAnnounceNum(choice);
					System.out.printf("%d. %s (👀 %d)\n     %s\n \n등록시간: %s\n", amList.getAnnouncenum(),
							amList.getAm_title(), amList.getAm_view(), amList.getAm_detail(), amList.getRegdate());
					System.out.println("\n========댓글========\n");
					for (CommentDTO comm : comList) {
						System.out.println(comm.getStudentid() + " : " + comm.getComment_detail());
					}
					new AnnouncementManagerment2View(amList.getAnnouncenum());
				}
			}
		}
	}
}