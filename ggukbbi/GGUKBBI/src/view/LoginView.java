package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import view.manager.ManagerLoginView;
import view.student.StudentLoginView;
import view.teacher.TeacherLoginView;

public class LoginView {
	public LoginView() {
		while (true) {
			int choice = 0;
			try {
				System.out.println("\n★☆★☆★☆[로그인 페이지입니다.]★☆★☆★☆\n");
				Scanner sc = new Scanner(System.in);
				System.out.println("1. 관리자용\n2. 강사용\n3. 학생용\n4. 나가기");
				choice = sc.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
				continue;
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
				continue;
			}
			if (choice == 4) {
				System.out.println("\n꾹삐 정보교육원 홈페이지로 돌아갑니다...🏃‍♂️\n");
				break;
			}
			switch (choice) {
			case 1:
				//1. 관리자용
				new ManagerLoginView();
				break;
			case 2:
				//2. 강사용
				new TeacherLoginView();
				break;
			case 3:
				//3. 학생용
				new StudentLoginView();
				break;
			default:
				System.out.println("\n다시 입력해주세요.\n");
				break;
			}
			break;
		}
	}
}
