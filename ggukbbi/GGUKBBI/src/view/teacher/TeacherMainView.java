package view.teacher;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Session;
import model.dto.TeacherDTO;
import view.messengerView.MessengerView;
import view.teacher.announcement.AnnouncementManagermentView;
import view.teacher.info.TeacherInfoView;
import view.teacher.quiz.QuizManagementView;
import view.teacher.student.StudentListView;

public class TeacherMainView {
	public TeacherMainView() {
		Scanner sc = new Scanner(System.in);
		TeacherDTO loginTeacher = (TeacherDTO) Session.getData("loginTeacher");

		while (true) {
			if (loginTeacher == null) {
				System.out.println("\n로그인 후 이용하세요.\n");
				break;
			}
			try {
				System.out.println("\n★☆★☆★☆[" + loginTeacher.getTea_name() + "강사님 안녕하세요!(*ˊᵕˋ*)ﾉ]★☆★☆★☆\n");
				System.out.println("1. 학생보기\n2. 공지사항\n3. 시험관리\n4. 메신저\n5. 내 정보\n6. 로그아웃");
				int choice = sc.nextInt();

				if (choice == 6) {
					//6. 로그아웃
					System.out.println("\n"+loginTeacher.getTea_name() + "님 안녕히 가세요!( ⸝⸝•ᴗ•⸝⸝ )੭⁾⁾\n");
					Session.setData("loginTeacher", null);
					break;
				}
				switch (choice) {
				case 1:
					//1. 학생보기
					new StudentListView();
					break;
				case 2:
					//2. 공지사항
					new AnnouncementManagermentView();
					break;
				case 3:
					//3. 시험관리
					new QuizManagementView();
					break;
				case 4:
					//4. 메신저
					new MessengerView();
					break;
				case 5:
					//5. 내 정보
					new TeacherInfoView();
					break;
				default:
					System.out.println("\n다시 입력해주세요.\n");
					break;	
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
