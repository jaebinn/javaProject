package view.messengerView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.MessengerController;
import model.Session;
import model.dto.MessengerDTO;
import model.dto.TeacherDTO;

public class MessengerSelectView {
	public MessengerSelectView() {
		MessengerController mcontroller = new MessengerController();

		ArrayList<MessengerDTO> list;
		TeacherDTO loggedInTeacher = (TeacherDTO) Session.getData("loginTeacher");

		if (loggedInTeacher != null) {
			list = mcontroller.getMessengerListByClIdTeacher();
			if (list.size() == 0) {
				System.out.println("\n메세지 함이 비었습니다.\n");
			} else {
				System.out.println("\n============내가 보낸 메세지 목록============\n");
				for (MessengerDTO messenger : list) {
					if (messenger.getGNT() == 1) {
						messenger.getCl_id();
						System.out.printf("%d. 제목: %s\n    To %s (%s)\n", messenger.getMsg_num(),
								messenger.getMsg_title(), messenger.getId(), messenger.getSendtime());
					}
				}
				System.out.println("\n============내가 받은 메세지 목록============\n");
				for (MessengerDTO messenger : list) {
					if (messenger.getGNT() == 0) {
						messenger.getCl_id();
						System.out.printf("%d. 제목: %s\n    From %s (%s)\n", messenger.getMsg_num(),
								messenger.getMsg_title(), messenger.getId(), messenger.getSendtime());
					}
				}

				System.out.println();
				System.out.println("\n=======================================\n");
			}
		} else {
			try {
				list = mcontroller.getMessengerListByClIdStudent();
				if (list.size() == 0) {
					System.out.println("\n메세지 함이 비었습니다.\n");
				} else {
					System.out.println("\n============내가 보낸 메세지 목록============\n");
					for (MessengerDTO messenger : list) {
						if (messenger.getGNT() == 0) {
							messenger.getCl_id();
							System.out.printf("%d. 제목: %s\n    To %s (%s)\n", messenger.getMsg_num(),
									messenger.getMsg_title(), messenger.getId(), messenger.getSendtime());
						}
					}
					System.out.println("\n============내가 받은 메세지 목록============\n");
					for (MessengerDTO messenger : list) {
						if (messenger.getGNT() == 1) {
							messenger.getCl_id();
							System.out.printf("%d. 제목: %s\n    From %s (%s)\n", messenger.getMsg_num(),
									messenger.getMsg_title(), messenger.getId(), messenger.getSendtime());
						}
					}
					System.out.println("\n=======================================\n");
				}
			} catch (NullPointerException npe) {
				System.out.println("\n메세지 함이 비었습니다.\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}

		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("-1입력 시 뒤로가기");
				System.out.println("자세히 볼 메신저 번호선택\n");
				int choice = sc.nextInt();
				if (choice == -1) {
					break;
				} else {
					new MessengerNumDetailView(choice);
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