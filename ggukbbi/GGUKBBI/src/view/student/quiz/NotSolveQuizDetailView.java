package view.student.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Q_A_Controller;
import model.Session;
import model.dao.CourseListDAO;
import model.dto.AnswerDTO;
import model.dto.QuizDTO;
import model.dto.StudentDTO;

public class NotSolveQuizDetailView {
	public NotSolveQuizDetailView(int quizNum) {

		Q_A_Controller qaController = new Q_A_Controller();
		QuizDTO quiz = qaController.getQuiz_DetailByQuiznum(quizNum);
		String loginStudent = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
		System.out.printf("\n=========%s번 문제=========\n",quiz.getQuiznum());
		System.out.printf("\n퀴즈 이름 : %s\n퀴즈 내용 : %s\n\n", quiz.getQuiz_title(), quiz.getQuiz_detail());

		while (true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("1. 답안입력\n2. 뒤로가기");
				int choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("답 입력란 : ");
					sc = new Scanner(System.in);
					String stu_answer = sc.nextLine();
					CourseListDAO cdao = new CourseListDAO();
					int cl_id = cdao.getCl_idByStudentid(loginStudent).getCl_id();
					AnswerDTO answer = new AnswerDTO(0, cl_id, quizNum, stu_answer, null);

					if (qaController.addAnswer(answer)) {
						System.out.println("\n답이 입력되었습니다!\n");
						break;
					} else {
						System.out.println("\n답이 입력되지 않았습니다...\n");
						break;
					}

				} else if (choice == 2) {
					break;
				} else {
					System.out.println("\n잘못된 번호입니다.\n");
				}
			} catch (InputMismatchException ime) {
				System.err.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.err.println("\n알 수 없는 오류 발생\n");
			}
		}
	}

}
