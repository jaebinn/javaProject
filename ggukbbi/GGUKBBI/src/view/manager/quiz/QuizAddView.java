package view.manager.quiz;

import java.util.Scanner;

import controller.Q_A_Controller;
import model.dto.QuizDTO;

public class QuizAddView {
	public QuizAddView() {
		Q_A_Controller controller = new Q_A_Controller();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n============시험등록============\n");
			System.out.println("-1 입력 시 뒤로가기");
			System.out.println("시험 분류(java / html / dbms) : ");
			String quiz_type = sc.next();
			if (quiz_type.equals("-1")) {
				break;
			}
			if (!quiz_type.equals("java") && !quiz_type.equals("html") && !quiz_type.equals("dbms"))

				System.out.println("\njava,html,dbms 中 입력해주세요\n");
			else {
				sc = new Scanner(System.in);
				System.out.println("시험 제목 : ");
				String quiz_title = sc.nextLine();
				sc = new Scanner(System.in);
				System.out.println("시험 내용 : ");
				String quiz_detail = sc.nextLine();
				sc = new Scanner(System.in);
				System.out.println("시험 답안 : ");
				String quizans = sc.nextLine();

				QuizDTO qdto = new QuizDTO(0, quiz_type, quiz_title, quiz_detail, quizans);

				if (controller.addQuiz(qdto)) {
					System.out.println("\n🎉시험 추가 완료🎉\n");
					break;
				} else {
					System.out.println("\n시험 추가 실패 ∑(O_O;)\n");
				}

			}

		}
	}
}