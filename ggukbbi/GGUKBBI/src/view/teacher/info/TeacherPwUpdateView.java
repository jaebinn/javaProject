package view.teacher.info;

import java.util.Scanner;

import controller.TeacherController;
import model.Session;
import model.dto.TeacherDTO;

public class TeacherPwUpdateView {
	public TeacherPwUpdateView(int choice) {
		Scanner sc = new Scanner(System.in);
		TeacherController controller = new TeacherController();
		String tea_pw = ((TeacherDTO) Session.getData("loginTeacher")).getTea_pw();
		String loginTeacher = ((TeacherDTO) Session.getData("loginTeacher")).getTeacherid();

		System.out.println("현재 비밀번호를 입력하세요: ");
		String current_pw = sc.next();
		if (tea_pw.equals(current_pw)) {
			System.out.print("수정할 비밀번호를 입력하세요: ");
			String newPw = sc.next();

			if (controller.updateTeacher(choice, loginTeacher, newPw)) {
				System.out.println("\n"+loginTeacher + "님 비밀번호 수정 완료!\n");
			} else {
				System.out.println("\n비밀번호 수정 실패 / 다시 시도해주세요.\n");
			}
		} else {
			System.out.println("\n현재 비밀번호가 다릅니다... / 다시 시도해주세요.\n");
		}
	}
}
