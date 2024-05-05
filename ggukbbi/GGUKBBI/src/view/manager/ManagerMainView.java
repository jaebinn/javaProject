package view.manager;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Session;
import model.dto.ManagerDTO;
import view.manager.lecture.LectureManagementView;
import view.manager.quiz.QuizManagementView;
import view.manager.student.StudentManagementView;

public class ManagerMainView {
	public ManagerMainView() {
		ManagerDTO loginManager = (ManagerDTO) Session.getData("loginManager");
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				if (loginManager == null) {
					System.out.println("\n로그인 후 이용하세요.\n");
					break;
				}
				System.out.println("\n★☆★☆★☆[관리자님 안녕하세요!(*ˊᵕˋ*)ﾉ]★☆★☆★☆\n");
				System.out.println("1. 강의관리\n2. 수강생 관리\n3. 시험 관리\n4. 나가기");
				int choice = sc.nextInt();

				if (choice == 4) {
					System.out.println("\n관리자님 안녕히 가세요!( ⸝⸝•ᴗ•⸝⸝ )੭⁾⁾\n");
					break;
				}
				switch (choice) {
				case 1:
					// 1. 강의관리
					new LectureManagementView();
					break;
				case 2:
					// 2. 수강생관리
					new StudentManagementView();
					break;
				case 3:
					// 3. 시험관리
					new QuizManagementView();
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
