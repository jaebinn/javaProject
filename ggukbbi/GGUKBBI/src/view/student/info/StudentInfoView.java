package view.student.info;

import java.util.InputMismatchException;

import java.util.Scanner;

import controller.StudentController;
import model.Session;
import model.dao.LectureDAO;
import model.dto.LectureDTO;
import model.dto.StudentDTO;
import view.LoginView;

public class StudentInfoView {
	public StudentInfoView() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				StudentController controller = new StudentController();
				String loginStudent = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
				StudentDTO student = controller.findStudentById(loginStudent);
				LectureDAO ldao = new LectureDAO();
				LectureDTO lec = ldao.findLectureByStudentid(loginStudent);

				System.out.println("\n=====" + student.getStu_name() + "님의 회원정보=====\n");
				System.out.printf("아이디 : %s\n핸드폰 번호 : %s\n주소 : %s\n", student.getStudentid(), student.getStu_phone(),
						student.getStu_addr());
				System.out.printf("강의 : %s\n반 : %s\n", lec.getLec_name(), lec.getClassroomid());
				System.out.println("\n========================\n");
				// (lec_name, cr_location) 두개 ..추가 필요해요

				System.out.println("1. 비밀번호 수정\n2. 핸드폰번호 수정\n3. 주소 수정\n4. 수정 취소\n5. 회원 탈퇴 ");
				int choice = sc.nextInt();
				if (choice == 4) {
					System.out.println("\n메인 돌아가요\n");
					break;
				} else if (choice == 5) {
					System.out.print("비밀번호 재입력 : ");
					String stu_pw = sc.next();

					if (student.getStu_pw().equals(stu_pw)) {
						if (controller.leaveId(student.getStudentid())) {
							System.out.println("\n이용해주셔서 감사해요\n");
							break;
						}
					} else {
						System.out.println("\n비밀번호가 틀렸습니다.\n");
					}
				} else {
					if (choice == 1) {
						System.out.print("현재 비밀번호 : ");
						String stu_pw = sc.next();

						if (!student.getStu_pw().equals(stu_pw)) {
							System.out.println("\n비밀번호가 틀렸습니다.\n");
							break;
						}
					}
					System.out.print("새로운 정보 : ");
					sc = new Scanner(System.in);
					String newData = sc.nextLine();

					if (controller.updateStudent(choice, student.getStudentid(), newData)) {
						System.out.println("\n정보 수정 완료\n");
					} else {
						System.out.println("\n정보 수정 실패\n");
					}
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요.\n");
			} catch (NullPointerException npe) {
				System.out.println("\n정보가 없습니다.\n");
				break;
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
