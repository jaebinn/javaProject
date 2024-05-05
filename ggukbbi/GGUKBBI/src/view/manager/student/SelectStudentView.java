package view.manager.student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.StudentController;
import model.dao.StudentDAO;
import model.dto.StudentDTO;

public class SelectStudentView {
	public SelectStudentView(int choice) {
		while (true) {
			StudentController stucontroller = new StudentController();
			StudentDAO sdao = new StudentDAO();

			// 수강생 간편보기 리스트
			ArrayList<StudentDTO> stuList = stucontroller.getStudentListByLectureid(choice);
			if (stuList.size() == 0) {
				System.err.println("\n등록된 수강생이 없습니다! 다른 강의를 선택해주세요.\n");
				break;
			} else {
				System.out.println("\n============수강생 리스트============\n");
				for (StudentDTO stu : stuList) {
					System.out.println("아이디 : " + stu.getStudentid() + " / 이름 : " + stu.getStu_name());
				}
				try {
					Scanner sc = new Scanner(System.in);
					System.out.println("\n-1 입력 시 뒤로가기");
					System.out.print("상세히 보고 싶은 수강생의 아이디를 입력하세요. : ");
					String studentid = sc.next();

					if (studentid.equals("-1")) {
						break;
					} else {
						if (studentid.equals((sdao.findStudentById(studentid)).getStudentid())) {
							StudentDTO stu = sdao.findStudentById(studentid);
							System.out.println("\n============수강생 정보============\n");
							System.out.printf("아이디 : %s\n이름 : %s\n나이 : %d\n성별 : %s\n주소 : %s\n전공 : %s\n휴대전화 : %s\n",
									stu.getStudentid(), stu.getStu_name(), stu.getStu_age(), stu.getStu_gender(),
									stu.getStu_addr(), stu.getStu_major(), stu.getStu_phone());
							System.out.println("\n================================\n");
							System.out.println("1. 뒤로가기\n2. 삭제하기");
							int select = sc.nextInt();
							if (select == 1) {
								continue;
							} else if (select == 2) {
								if (stucontroller.leaveId(studentid)) {
									System.out.println("\n삭제되었습니다.\n");
								} else {
									System.out.println("\n삭제 실패...\n");
								}
							} else {
								System.out.println("\n다시 입력해주세요.\n");
							}
						} else {
							System.out.println("\n아이디를 다시 입력해주세요.\n");
						}
					}

				} catch (InputMismatchException ime) {
					System.out.println("\n숫자를 입력해주세요\n");

				} catch (Exception e) {
					System.out.println("\n알 수 없는 오류 발생\n");
				}
			}
		}
	}
}