package view.teacher.info;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.TeacherController;
import model.Session;
import model.dao.LectureDAO;
import model.dto.LectureDTO;
import model.dto.TeacherDTO;

public class TeacherInfoView {
	public TeacherInfoView() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				String loginTeacher = ((TeacherDTO) Session.getData("loginTeacher")).getTeacherid();
				TeacherController controller = new TeacherController();
				TeacherDTO list = controller.findTeacherById(loginTeacher);
				LectureDAO ldao = new LectureDAO();
				LectureDTO lec = (LectureDTO)ldao.findLectureByTeacherid(loginTeacher); 
				
				// teacherid, tea_pw, tea_name, tea_age, tea_gender, tea_phone, lec_name,
				// cr_location
				System.out.printf("\n=====%s님의 회원정보=====\n\n아이디: %s\n나이: %d\n성별: %s\n전화번호: %s\n", list.getTea_name(),
						list.getTeacherid(), list.getTea_age(), list.getTea_gender(),
						list.getTea_phone());
				System.out.printf("담당 강의 : %s\n반 : %s\n",lec.getLec_name(),lec.getClassroomid());
				
				System.out.println("\n========================\n");
				System.out.println("1. 비밀번호 변경\n2. 전화번호 변경\n3. 뒤로가기");
				int choice = sc.nextInt();
				if (choice == 3) {
					break;
				}

				switch (choice) {
				case 1:
					new TeacherPwUpdateView(choice);
					break;
				case 2:
					new TeacherPhoneUpdateView(choice);
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