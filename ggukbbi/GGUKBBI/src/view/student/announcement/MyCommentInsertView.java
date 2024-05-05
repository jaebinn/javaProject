package view.student.announcement;

import java.util.Scanner;

import controller.CommentController;
import model.dto.CommentDTO;

public class MyCommentInsertView {
	public MyCommentInsertView(int announcenum) {
		Scanner sc = new Scanner(System.in);
		CommentController controller = new CommentController();
		CommentDTO cdto = new CommentDTO();

		System.out.println("댓글 : ");
		String detail = sc.nextLine();

		cdto.setComment_detail(detail);
		cdto.setAnnouncenum(announcenum);

		controller.addComment(cdto);
	}
}
