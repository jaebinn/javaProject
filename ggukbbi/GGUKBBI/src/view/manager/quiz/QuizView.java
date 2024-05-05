package view.manager.quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Q_A_Controller;
import model.dto.QuizDTO;

public class QuizView {
	public QuizView(int quizType) {
		// 퀴즈 getList
		while (true) {
			try {
				Q_A_Controller qcontroller = new Q_A_Controller();
				Scanner sc = new Scanner(System.in);

				ArrayList<QuizDTO> QuizList = qcontroller.getList(quizType);
				System.out.println("\n============퀴즈 리스트============\n");
				for (QuizDTO quiz : QuizList) {
					System.out.printf(quiz.getQuiznum() + ". " + quiz.getQuiz_title());
					System.out.println();
				}
				System.out.println("\n================================\n");
				System.out.println("-1 입력 시 뒤로가기");
				System.out.print("자세히 보고 싶은 시험 번호를 입력해주세요. : ");
				int choice = sc.nextInt();

				if (choice == -1) {
					break;
				} else {
					QuizDTO quiz = qcontroller.getQuiz_DetailByQuiznum(choice);
					if (quiz != null) {
						System.out.println("\n============퀴즈============\n");
						System.out.printf("제목 : %s\n퀴즈 : %s\n답안 : %s\n", quiz.getQuiz_title(), quiz.getQuiz_detail(),
								quiz.getQuizans());
						System.out.println("\n===========================\n");
						while (true) {
							try {
								sc = new Scanner(System.in);
								System.out.println("1. 뒤로가기");
								int back = sc.nextInt();
								if (back == 1) {
									break;
								} else {
									System.out.println("\n다시 입력해주세요.\n");
								}
							} catch (InputMismatchException ime) {
								System.out.println("\n숫자를 입력해주세요.\n");
							} catch (Exception e) {
								System.out.println("\n알 수 없는 오류 발생\n");
							}
						}
					} else {
						System.out.println("\n다시 입력해주세요\n");
					}
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요.\n");
			} catch (NullPointerException npe) {
				System.out.println("\n문제가 없습니다.\n");
				break;
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}
