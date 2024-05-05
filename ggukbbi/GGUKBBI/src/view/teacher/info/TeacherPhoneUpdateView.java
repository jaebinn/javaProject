package view.teacher.info;

import java.util.Scanner;

import controller.TeacherController;
import model.Session;
import model.dto.TeacherDTO;

public class TeacherPhoneUpdateView {
	public TeacherPhoneUpdateView(int choice) {
		Scanner sc = new Scanner(System.in);
		TeacherController controller = new TeacherController();

		String loginTeacher = ((TeacherDTO) Session.getData("loginTeacher")).getTeacherid();

		System.out.print("수정할 전화번호를 입력하세요 : ");
		String newPhone = sc.next();

		if (controller.updateTeacher(choice, loginTeacher, newPhone)) {
			System.out.println("\n"+loginTeacher + "님 전화번호 수정 완료!\n");
		} else {
			System.out.println("\n전화번호 수정 실패 / 다시 시도해주세요.\n");
		}
	}
}
