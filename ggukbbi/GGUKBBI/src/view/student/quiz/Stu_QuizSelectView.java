package view.student.quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Q_A_Controller;
import model.dto.QuizDTO;

public class Stu_QuizSelectView {
	public Stu_QuizSelectView(int choice) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			Q_A_Controller qaController = new Q_A_Controller();

			try {
				System.out.println("1. 푼 문제\n2. 안 푼 문제\n3. 뒤로가기");
				int solve = sc.nextInt();

				if (solve == 1) {
					ArrayList<QuizDTO> solveList = qaController.getSolveList(choice);
					if (solveList.size() == 0) {
						System.out.println("\n푼 문제가 없습니다...\n");
					} else {
						System.out.println("\n=========푼 문제 리스트=========\n");
						for (QuizDTO solveQuiz : solveList) {
							System.out.printf("%d. 퀴즈제목 : %s\n", solveQuiz.getQuiznum(),
									solveQuiz.getQuiz_title());
						}
						while (true) {
							sc = new Scanner(System.in);
							try {
								System.out.println("\n-1 입력 시 뒤로가기");
								System.out.println("상세히 볼 문제 번호를 입력해주세요");
								int quizNum = sc.nextInt();
								if (quizNum == -1) {
									break;
								}
								new SolveQuizDetailView(quizNum);
								break;
							} catch (InputMismatchException ime) {
								System.out.println("\n숫자를 입력해주세요\n");
							} catch (NullPointerException npe) {
								System.out.println("\n해당 번호의 문제가 없습니다.\n");
							} catch (Exception e) {
								System.out.println("\n알 수 없는 오류 발생\n");
							}
						}
						break;
					}
				} else if (solve == 2) {
					ArrayList<QuizDTO> notSolveList = qaController.getNotSolveList(choice);
					if (notSolveList.size() == 0) {
						System.out.println("\n안 푼 문제가 없습니다!\n");
					} else {
						System.out.println("\n=========안 푼 문제 리스트=========\n");
						for (QuizDTO notSolveQuiz : notSolveList) {
							System.out.printf("퀴즈번호 : %d -> 퀴즈제목 : %s\n", notSolveQuiz.getQuiznum(),
									notSolveQuiz.getQuiz_title());
						}
						while (true) {
							sc = new Scanner(System.in);
							try {
								System.out.println("\n-1 입력 시 뒤로가기");
								System.out.println("상세히 볼 문제 번호를 입력해주세요");
								int quizNum = sc.nextInt();
								if (quizNum == -1) {
									break;
								}
								new NotSolveQuizDetailView(quizNum);
								break;
							} catch (InputMismatchException ime) {
								System.out.println("\n숫자를 입력해주세요\n");
							} catch (NullPointerException npe) {
								System.out.println("\n해당 번호의 문제가 없습니다.\n");
							} catch (Exception e) {
								System.out.println("\n알 수 없는 오류 발생\n");
							}
						}
						break;
					}
				} else if (solve == 3) {
					break;
				} else {
					System.out.println("\n잘못된 번호입력 다시 입력\n");
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}