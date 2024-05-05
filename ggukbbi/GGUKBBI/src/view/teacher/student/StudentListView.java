package view.teacher.student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.StudentController;
import model.dto.StudentDTO;

public class StudentListView {
	public StudentListView() {
		StudentController stucontroller = new StudentController();

		ArrayList<StudentDTO> stuList = stucontroller.getStudentListByTeacherId();
		if(stuList.size() ==0) {
			System.out.println("\n등록된 학생 리스트가 없습니다.🙅‍\n");
		}
		System.out.println("\n============등록된 학생 리스트============\n");
		for (StudentDTO stu : stuList) {
			System.out.printf("아이디: %s | 이름: %s | 나이: %d | 성별: %s | 전공여부: %s | 주소: %s | 연락처: %s\n", stu.getStudentid(),
					stu.getStu_name(), stu.getStu_age(), stu.getStu_gender(), stu.getStu_major(), stu.getStu_addr(),
					stu.getStu_phone());
		}
		System.out.println("\n=====================================\n");

		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("1. 뒤로가기");
				int choice = sc.nextInt();
				if (choice == 1) {
					break;
				} else {
					System.out.println("\n잘못된 번호를 입력하셨습니다.\n");
				}
			} catch (InputMismatchException ime) {
				System.err.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.err.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}