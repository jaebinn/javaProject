package view.manager.student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.LectureController;
import model.dto.LectureDTO;

public class StudentManagementView {
	public StudentManagementView() {
		LectureController controller = new LectureController();
		while (true) {
			try {
				// 강의 리스트 출력
				ArrayList<LectureDTO> lecList = controller.getList();
				if (lecList.size() == 0) {
					System.out.println("\n등록된 강의가 없습니다!\n");
					break;
				} else {
					System.out.println("\n============강의 리스트============\n");
					for (LectureDTO lec : lecList) {
						System.out.printf(lec.getLectureid() + ". " + lec.getLec_name());
						System.out.println();
					}
					System.out.println("\n================================\n");

					// 강의 선택
					System.out.println("\n-1을 입력 시 뒤로가기");
					System.out.print("정보가 필요한 수강생의 강의 번호를 입력해주세요. : ");
					Scanner sc = new Scanner(System.in);
					int choice = sc.nextInt();

					if (choice == -1) {
						break;
					} else {
						if (lecList.size() == 0) {
							System.out.println("\n번호를 잘못 입력하셨습니다.\n");
						} else {
							// 수강생 선택 view
							new SelectStudentView(choice);
						}
					}
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (NullPointerException npe) {
				System.out.println("\n등록된 강의가 없습니다.\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
