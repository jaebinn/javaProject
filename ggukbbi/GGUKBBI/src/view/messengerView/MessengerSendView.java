package view.messengerView;

import java.util.Scanner;

import controller.MessengerController;
import model.Session;
import model.dto.MessengerDTO;
import model.dto.TeacherDTO;

public class MessengerSendView {
	public MessengerSendView() {
		Scanner sc = new Scanner(System.in);
		MessengerController controller = new MessengerController();
		MessengerDTO mdto = new MessengerDTO();
		System.out.println("\n============메신저 보내기============\n");
		if ((TeacherDTO) Session.getData("loginTeacher") != null) {
			// 강사 > 수강생 (1)
			System.out.println("받는 사람 아이디를 입력해주세요 :");
			String id = sc.next();
			System.out.println("제목입력 :  ");
			String msg_tilte = sc.next();
			System.out.println("내용 : ");
			String msg_detail = sc.next();
			mdto = new MessengerDTO(0, msg_tilte, id, null, msg_detail, 1);
		} else {
			// 수강생 > 강사 (0)
			System.out.println("To. 강사");
			System.out.println("제목입력 :  ");
			String msg_tilte = sc.next();
			System.out.println("내용 : ");
			String msg_detail = sc.next();
			mdto = new MessengerDTO(0, msg_tilte, "", null, msg_detail, 0);
		}
		try {
			if (controller.sendMessenger(mdto)) {
				System.out.println("\n전송 완료\n");
			} else {
				System.out.println("\n전송 실패\n");
			}
		} catch (NullPointerException npe) {
			System.out.println("\n학생 아이디를 정확하게 입력해주세요.\n");
		} catch (Exception e) {
			System.out.println("\n알 수 없는 오류 발생\n");
		}
	}
}
