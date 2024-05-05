package view.messengerView;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.MessengerController;
import model.Session;
import model.dao.CourseListDAO;
import model.dto.MessengerDTO;
import model.dto.StudentDTO;
import model.dto.TeacherDTO;

public class MessengerReply {
	public MessengerReply(String id) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				MessengerController msgController = new MessengerController();
				CourseListDAO cdao = new CourseListDAO();
				System.out.println("1. 제목 :  ");
				String msg_title = sc.next();
				System.out.println("2. 내용 :");
				String msg_detail = sc.next();
				MessengerDTO message;
				int cl_id;
				if ((TeacherDTO) Session.getData("loginTeacher") != null) {
					cl_id = (cdao.getCl_idByStudentid(id)).getCl_id();
					message = new MessengerDTO(0, msg_title, cl_id, null, msg_detail, 1);
				} else {
					String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
					cl_id = (cdao.getCl_idByStudentid(studentid)).getCl_id();
					message = new MessengerDTO(0, msg_title, cl_id, null, msg_detail, 0);
				}
				if (msgController.replyMessenger(message)) {
					System.out.println("\n답장전송 완료\n");
					break;
				} else {
					System.out.println("\n전송 실패\n");
					break;
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (NullPointerException npe) {
				System.out.println("\n해당 번호의 메신저가 없습니다.\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}