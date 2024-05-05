package view.student;

import java.util.InputMismatchException;


import java.util.Scanner;

import model.Session;
import model.dto.StudentDTO;
import view.crawling.CodeStudyView;
import view.messengerView.MessengerView;
import view.student.announcement.AnnouncementSelectView;
import view.student.info.StudentInfoView;
import view.student.quiz.StudentQuizTypeView;

public class StudentMainView {
	public StudentMainView() {
		StudentDTO loginStudent = (StudentDTO) Session.getData("loginStudent");
		while (true) {
			if (loginStudent == null) {
				System.out.println("\n로그인 후 이용하세요.\n");
				break;
			}

			int choice = 0;
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n★☆★☆★☆[" + loginStudent.getStu_name() + "님 안녕하세요!(*ˊᵕˋ*)ﾉ]★☆★☆★☆\n");
				System.out.println("1. 공지사항 보기\n2. 메신저\n3. 시험\n4. 코딩공부 \n5. 내 정보\n6. 로그아웃");

				choice = sc.nextInt();
				if (choice == 6) {
					System.out.println("\n"+loginStudent.getStu_name() + "님 안녕히 가세요!( ⸝⸝•ᴗ•⸝⸝ )੭⁾⁾\n");
					Session.setData("loginStudent", null);
					break;
				}
				switch (choice) {
				case 1:
					new AnnouncementSelectView();
					break;
				case 2:
					new MessengerView();
					break;
				case 3:
					new StudentQuizTypeView();
					break;
				case 4:
					new CodeStudyView();
					break;
				case 5:
					new StudentInfoView();
					loginStudent = (StudentDTO)Session.getData("loginStudent");
					break;
				default:
					System.out.println("\n잘못된 선택입니다. 다시 선택하세요.\n");

				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}

		}
	}
}
