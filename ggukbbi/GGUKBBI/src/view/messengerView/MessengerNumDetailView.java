package view.messengerView;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.MessengerController;
import controller.StudentController;
import controller.TeacherController;
import model.Session;
import model.dto.MessengerDTO;
import model.dto.TeacherDTO;

public class MessengerNumDetailView {
	public MessengerNumDetailView(int msgnum) {

		MessengerController msg_controller = new MessengerController();
		StudentController stu_controller = new StudentController();
		TeacherController tea_controller = new TeacherController();
		MessengerDTO msgDetail = msg_controller.getMsgDetail(msgnum);

		if (msgDetail == null) {
			System.out.println("\n해당 번호의 메신저가 없습니다.\n");
			return;
		}

		String userType = (TeacherDTO) Session.getData("loginTeacher") != null ? "teacher" : "student";
		String senderName = userType.equals("teacher") ? stu_controller.findStudentById(msgDetail.getId()).getStu_name()
				: tea_controller.findTeacherById(msgDetail.getId()).getTea_name();
		System.out.println("\n========================\n");
		System.out.printf("보낸사람: %s(%s)\n보낸시간: %s\n\n제목: %s\n%s\n", msgDetail.getId(), senderName,
				msgDetail.getSendtime(), msgDetail.getMsg_title(), msgDetail.getMsg_detail());
		System.out.println("\n========================\n");
		while (true) {
			try {
				System.out.println();
				System.out.println("1. 답장하기\n2. 뒤로가기 ");
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();

				if (choice == 1) {
					new MessengerReply(msgDetail.getId());
				} else if (choice == 2) {
					break;
				} else {
					System.out.println("\n잘못된 입력\n");
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