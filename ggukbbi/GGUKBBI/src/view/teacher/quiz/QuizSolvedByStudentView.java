package view.teacher.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Q_A_Controller;
import model.dto.AnswerDTO;
import model.dto.GradingDTO;

public class QuizSolvedByStudentView {
	public QuizSolvedByStudentView(int quiznum) {
		Q_A_Controller controller = new Q_A_Controller();
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("-1 입력 시 뒤로가기");
			System.out.println("채점할 학생의 아이디 입력 : ");
			String studentid = sc.next();
			if (studentid.equals("-1")) {
				break;
			} else {
				while (true) {
					try {
						if (studentid.equals(studentid)) {
							// 채점할 학생의 답안 출력
							AnswerDTO stuAns = controller.getAnswerByStudentid(studentid, quiznum);
							if (stuAns != null) {
								System.out.println("\n============채점할 답안============\n");
								System.out.printf("답 : %s\n입력한 시간 : %s\n", stuAns.getStu_answer(), stuAns.getRegdate());
								int answerid = stuAns.getAnswerid();
								System.out.print("점수 : ");
								int score = sc.nextInt();
								GradingDTO gdto = new GradingDTO(answerid, score);
								if(controller.gradingByAnswer(gdto)) {
									System.out.println("\n입력되었습니다.\n");
								}
								else {
									System.out.println("\n입력 실패\n");
								}
								break;
							} else {
								System.err.println("\n다시 입력해주세요\n");
								break;
							}
						}
						break;
					} catch (InputMismatchException ime) {
						System.out.println("\n숫자를 입력해주세요\n");
					} catch (Exception e) {
						System.out.println("\n알 수 없는 오류 발생\n");
					}
				}
			}
		}
	}
}
