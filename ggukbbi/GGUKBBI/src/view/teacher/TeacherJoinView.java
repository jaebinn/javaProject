package view.teacher;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.TeacherController;
import model.dto.TeacherDTO;
import view.LoginView;

public class TeacherJoinView {
	public TeacherJoinView() {
		Scanner sc = new Scanner(System.in);
		TeacherController controller = new TeacherController();
		System.out.println("\n★☆★☆★☆[꾹삐 정보교육원 강사 회원가입 페이지]★☆★☆★☆\n");

		System.out.print("아이디 : ");
		String teacherid = sc.next();

		if (controller.checkId(teacherid)) {
			System.out.print("비밀번호 : ");
			String tea_pw = sc.next();
			System.out.print("비밀번호 확인 : ");
			String tea_pw_re = sc.next();
			if (tea_pw.equals(tea_pw_re)) {
				System.out.print("이름 : ");
				String tea_name = sc.next();
				System.out.print("나이 : ");

				while (true) {
					try {
						sc = new Scanner(System.in);
						int tea_age = sc.nextInt();
						System.out.print("성별: ");
						String tea_gender = sc.next();
						System.out.print("핸드폰 번호 : ");
						String tea_phone = sc.next();

						//TeacherDTO 포장
						TeacherDTO teacher = new TeacherDTO(teacherid, tea_pw, tea_name, tea_age, tea_gender,
								tea_phone);

						//TeacherDTO DB에 insert
						if (controller.join(teacher)) {
							System.out.println("\n회원가입 성공!ヽ(｡ゝω・｡)ﾉ\n");
							//LoginView로 연결
							new LoginView();
							break;
						} else {
							System.out.println("\n회원가입 실패༼;´༎ຶ ۝ ༎ຶ༽  / 다음에 다시 시도해 주세요~\n");
						}
					} catch (InputMismatchException ime) {
						System.out.println("\n숫자를 입력해주세요\n");
					} catch (Exception e) {
						System.out.println("\n알 수 없는 오류 발생\n");
					}
					break;
				}
			} else {
				System.out.println("\n비밀번호 확인을 다시 해주세요!\n");
			}
		} else {
			System.out.println("\n중복된 아이디가 있습니다!\n");
		}
	}
}