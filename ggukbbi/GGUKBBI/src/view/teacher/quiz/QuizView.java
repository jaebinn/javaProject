package view.teacher.quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Q_A_Controller;
import model.dto.QuizDTO;
import model.dto.StudentDTO;

public class QuizView {
	public QuizView(int choice) {
		// 퀴즈 getList
		while (true) {
			Q_A_Controller qcontroller = new Q_A_Controller();
			Scanner sc = new Scanner(System.in);

			ArrayList<QuizDTO> QuizList = qcontroller.getList(choice);
			System.out.println("\n============퀴즈 리스트============\n");
			for (QuizDTO quiz : QuizList) {
				System.out.printf(quiz.getQuiznum() + ". " + quiz.getQuiz_title() + "\n");
			}
			// 채점할 시험번호 입력
			try {
				System.out.println("\n============채점============\n");
				System.out.println("-1 입력 시 뒤로가기");
				System.out.print("채점할 시험 번호를 입력해주세요. : ");
				int quiznum = sc.nextInt();
				if (quiznum == -1) {
					break;
				} else {
					QuizDTO quiz = qcontroller.getQuiz_DetailByQuiznum(quiznum);
					ArrayList<StudentDTO> ansstuList = qcontroller.getStudentByAnswer(quiznum);

					if (quiz != null) {
						// 채점할 시험 문제 내용
						System.out.println("\n============문제============\n");
						System.out.printf("제목 : %s,\n 퀴즈 : %s,\n 답안: %s\n", quiz.getQuiz_title(), quiz.getQuiz_detail(),
								quiz.getQuizans());
						// 채점할 시험의 푼 학생들
						System.out.println("\n=============문제 푼 학생 리스트=============\n");
						for (StudentDTO sdto : ansstuList) {
							System.out.printf(sdto.getStu_name() + " / " + sdto.getStudentid() + "\n");
						}
						System.out.println("\n=======================================\n");
						// 채점할 학생 선택뷰
						new QuizSolvedByStudentView(quiznum);
					} else {
						System.out.println("\n다시 입력해주세요\n");
					}
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (NullPointerException npe) {
				System.out.println("\n문제가 없습니다.\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
