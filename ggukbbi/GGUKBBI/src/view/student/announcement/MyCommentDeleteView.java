package view.student.announcement;

import java.util.Scanner;

import controller.CommentController;

public class MyCommentDeleteView {
	public MyCommentDeleteView() {
		Scanner sc = new Scanner(System.in);

		CommentController comcontroller = new CommentController();
		System.out.print("삭제할 내 댓글 번호 입력:");
		int commentnum = sc.nextInt();

		if (comcontroller.deleteComment(commentnum)) {
			System.out.println("\n삭제완료!\n");
		} else {
			System.out.println("\n삭제실패...\n");
		}
	}
}
