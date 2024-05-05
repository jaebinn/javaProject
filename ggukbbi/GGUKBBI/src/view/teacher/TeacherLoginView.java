package view.teacher;

import java.util.Scanner;

import controller.TeacherController;

public class TeacherLoginView {
	public TeacherLoginView() {
		Scanner sc = new Scanner(System.in);
		TeacherController controller = new TeacherController();
		System.out.println("\n★☆★☆★☆[꾹삐 정보교육원 강사 로그인 페이지]★☆★☆★☆\n");

		System.out.print("아이디: ");
		String teacherid = sc.next();
		System.out.print("비밀번호: ");
		String tea_pw = sc.next();

		if (controller.login(teacherid, tea_pw)) {
			System.out.println("\n환영합니다!(๓° ˘ °๓)♡ \n");
			new TeacherMainView();
		} else {
			System.out.println("\n아이디 또는 비밀번호를 다시 확인해주세요.◝₍ᴑ̑ДO͝₎◞\n");
		}
	}
}
