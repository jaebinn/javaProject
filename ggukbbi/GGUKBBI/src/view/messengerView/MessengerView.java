package view.messengerView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MessengerView {
	public MessengerView() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n============메신저============\n");
				System.out.println("1. 메신저 조회\n2. 메신저 보내기\n3. 뒤로가기");
				int choice = sc.nextInt();
				if (choice == 3) {
					break;
				}
				switch (choice) {
				case 1:
					new MessengerSelectView();
					break;
				case 2:
					new MessengerSendView();
					break;
				default:
					System.out.println("\n숫자를 정확히 입력해주세요.\n");
					break;
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}

	}
}