package view.student;

import java.util.Scanner;

import controller.StudentController;

public class StudentLoginView {
	public StudentLoginView() {
		Scanner sc = new Scanner(System.in);
		StudentController controller = new StudentController();

		System.out.print("아이디: ");
		String studentid = sc.next();
		System.out.print("비밀번호: ");
		String stu_pw = sc.next();

		if (controller.login(studentid, stu_pw)) {
			System.out.println("\n환영합니다!(๓° ˘ °๓)♡ \n");
			new StudentMainView();
		} else {
			System.out.println("\n아이디 또는 비밀번호를 다시 확인해주세요.◝₍ᴑ̑ДO͝₎◞\n");
		}
	}
}
