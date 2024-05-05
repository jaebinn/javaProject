package view.student;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.CourseListController;
import controller.LectureController;
import controller.StudentController;
import model.dto.CourseListDTO;
import model.dto.LectureDTO;
import model.dto.StudentDTO;
import view.LoginView;

public class StudentJoinView {
	public StudentJoinView() {
		Scanner sc = new Scanner(System.in);
		StudentController scontroller = new StudentController();
		LectureController lcontroller = new LectureController();
		CourseListController ccountroller = new CourseListController();

		System.out.println("★☆★☆★☆[꾹삐 정보교육원 학생 회원가입 페이지]★☆★☆★☆");

		System.out.print("아이디 : ");
		String studentid = sc.next();

		if (scontroller.checkId(studentid)) {
			System.out.print("비밀번호 : ");
			String stu_pw = sc.next();
			System.out.print("비밀번호 확인 : ");
			String stu_pw_re = sc.next();
			if (stu_pw.equals(stu_pw_re)) {
				System.out.print("이름 : ");
				String stu_name = sc.next();
				System.out.print("나이 : ");
				while (true) {
					try {
						sc = new Scanner(System.in);
						int stu_age = sc.nextInt();
						System.out.print("성별: ");
						String stu_gender = sc.next();
						System.out.print("주소 : ");
						sc = new Scanner(System.in);
						String stu_addr = sc.nextLine();
						System.out.print("전공 여부 (미입력 시 '미입력'을 입력하고 넘겨주세요.) :");
						String stu_major = sc.next();
						System.out.print("핸드폰 번호 : ");
						String stu_phone = sc.next();

						StudentDTO student = new StudentDTO(studentid, stu_pw, stu_name, stu_age, stu_gender, stu_addr,
								stu_major, stu_phone);

						if (scontroller.join(student)) {
							ArrayList<LectureDTO> list = lcontroller.getList();
							System.out.println("============등록된 강의 목록============");
							if (list.size() == 0) {
								System.out.println("등록된 강의가 없습니다!");
							} else {
								for (LectureDTO lecture : list) {
									System.out.println("강의 번호: " + lecture.getLectureid());
									System.out.println("강의 이름: " + lecture.getLec_name());
									System.out.println("강의 반: " + lecture.getClassroomid());
									System.out.println("강의 시작일: " + lecture.getLec_beginday());
									System.out.println("강사: " + lecture.getTeacherid());
									System.out.println("===================================");
								}
							}
							while (true) {
								try {
									sc = new Scanner(System.in);
									System.out.println("강의 번호 선택 : ");
									int choice = sc.nextInt();
									CourseListDTO courseList = new CourseListDTO(choice, studentid, 0);

									if (ccountroller.joinCourseList(courseList)) {
										System.out.println("회원가입 성공!");
										new LoginView();
										break;
									} else {
										scontroller.deleteId(studentid);
										System.out.println("회원가입 실패 / 다음에 다시 시도해 주세요~");
										break;
									}
								} catch (InputMismatchException ime) {
									System.err.println("숫자를 입력해주세요");
								} catch (NullPointerException npe) {
									System.out.println("강의가 없습니다.");
									break;
								} catch (Exception e) {
									System.err.println("알수없는 오류 발생");
								}
							}
							break;
						} else {
							System.out.println("회원가입 실패 / 다음에 다시 시도해 주세요~");
						}
					} catch (InputMismatchException ime) {
						System.err.println("숫자를 입력해주세요");
					} catch (Exception e) {
						System.err.println("알수없는 오류 발생");
					}
					break;
				}
			} else {
				System.out.println("비밀번호 확인을 다시 해주세요!");
			}
		} else {
			System.out.println("중복된 아이디가 있습니다!");
		}
	}
}