package view.manager;

import java.util.Scanner;

import controller.ManagerController;

public class ManagerLoginView {
	public ManagerLoginView() {
		Scanner sc = new Scanner(System.in);
		ManagerController controller = new ManagerController();
		System.out.println("★☆★☆★☆[꾹삐 정보교육원 관리자 로그인 페이지]★☆★☆★☆");
		System.out.print("아이디: ");
		String managerid = sc.next();
		System.out.print("비밀번호: ");
		String managerpw = sc.next();

		if (controller.login(managerid, managerpw)) {
			System.out.println("환영합니다!(๓° ˘ °๓)♡");
			//매니저 메인뷰
			new ManagerMainView();
		} else {
			System.out.println("아이디 또는 비밀번호를 다시 확인해주세요.◝₍ᴑ̑ДO͝₎◞");
		}
	}
}
