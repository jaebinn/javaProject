package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		while (true) {
			int choice = 0;
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("★☆★☆★☆[꾹삐 정보교육원 홈페이지]★☆★☆★☆\n");
				System.out.println();

				//KH정보교육원 크롤링메소드
//				new CommonView();

				System.out.println("\n1. 회원가입\n2. 로그인\n3. 나가기\n");
				choice = sc.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}

			if (choice == 3) {
				//3. 나가기
				System.out.println("\n당신의 앞날을 응원합니다!👍\n");
				break;
			}
			switch (choice) {
			case 1:
				//1. 회원가입
				new JoinView();
				break;
			case 2:
				//2. 로그인
				new LoginView();
				break;
			default:
				System.out.println("\n다시 입력해주세요.\n");
				break;
			}
		}
	}
}