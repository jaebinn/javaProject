package view.student.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Q_A_Controller;
import model.dto.AnswerDTO;
import model.dto.GradingDTO;
import model.dto.QuizDTO;

public class SolveQuizDetailView {
	public SolveQuizDetailView(int quizNum) {
		Q_A_Controller qaController = new Q_A_Controller();
		QuizDTO quiz = qaController.getQuiz_DetailByQuiznum(quizNum);
		AnswerDTO answer = qaController.getMyAnswer(quizNum);
		GradingDTO grade = qaController.getMyGrade(quizNum);

		if (grade == null) {
			System.out.println("\n성적입력이 되지 않았습니다... 강사가 채점한 후에 확인해주세요.\n");
		} else {
			System.out.printf("\n=========%s번 퀴즈=========\n", quiz.getQuiznum());
			System.out.printf("\n퀴즈 제목 : %s\n퀴즈 내용 : %s\n퀴즈답 : %s\n내 답 : %s\n성적 : %s\n\n", quiz.getQuiz_title(),
					quiz.getQuiz_detail(), quiz.getQuizans(), answer.getStu_answer(), grade.getScore());
		}

		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("1. 뒤로가기");
				int choice = sc.nextInt();

				if (choice == 1) {
					break;
				} else {
					System.out.println("\n다시 입력해주세요.\n");
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
