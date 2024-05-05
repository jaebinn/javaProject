package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import view.student.StudentJoinView;
import view.teacher.TeacherJoinView;

public class JoinView {
	public JoinView() {
		while (true) {
			try {
				System.out.println("\n★☆★☆★☆[회원가입 페이지입니다.]★☆★☆★☆\n");
				Scanner sc = new Scanner(System.in);
				System.out.println("1. 강사용\n2. 학생용\n3. 나가기");
				int choice = sc.nextInt();
				if (choice == 3) {
					System.out.println("꾹삐 정보교육원 홈페이지로 돌아갑니다...🏃‍♂️");
					break;
				}
				switch (choice) {
				case 1:
					//1. 강사용
					new TeacherJoinView();
					break;
				case 2:
					//2. 학생용
					new StudentJoinView();
					break;
				default:
					System.out.println("\n다시 입력해주세요.\n");
					break;
				}
			} catch (InputMismatchException ime) {
				System.out.println("숫자를 입력해주세요");
			} catch (Exception e) {
				System.out.println("알수없는 오류 발생");
			}
			break;
		}
	}
}
