package view.student.announcement;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.AnnouncementController;
import controller.CommentController;
import model.dto.AnnouncementDTO;
import model.dto.CommentDTO;

public class AnnouncementSelectView {
	public AnnouncementSelectView() {

		AnnouncementController controller = new AnnouncementController();
		ArrayList<CommentDTO> comList = new ArrayList<CommentDTO>();
		CommentController comcontroller = new CommentController();

		while (true) {
			ArrayList<AnnouncementDTO> amList = controller.getAnnouncementList();
			System.out.println("\n=================공지사항 리스트=================\n");
			for (AnnouncementDTO am : amList) {
				System.out.println(am.getAnnouncenum() + ". " + am.getAm_title());
			}
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("-1 입력시 뒤로가기");
				System.out.println("자세히 보고싶은 공지사항 번호를 입력해주세요!");
				int choice = sc.nextInt();
				controller.announcementCounter(choice);
				if (choice == -1) {
					break;
				} else {
					if (controller.getDetail(choice) == null) {
						System.out.println("\n해당하는 공지사항 번호가 없습니다.\n");
					} else {
						while (true) {
							System.out.println("\n===================공지사항====================\n");
							AnnouncementDTO am = controller.getDetail(choice);
							comList = comcontroller.findCommentByAnnounceNum(choice);
							System.out.printf("%d. %s (👀 %d)\n     %s\n \n등록시간: %s\n", am.getAnnouncenum(),
									am.getAm_title(), am.getAm_view(), am.getAm_detail(), am.getRegdate());
							ArrayList<CommentDTO> mycomment = comcontroller
									.divideMyCommentByStudentId(am.getAnnouncenum());
							ArrayList<CommentDTO> anothercomment = comcontroller
									.divideCommentAnotherId(am.getAnnouncenum());

							if (anothercomment == null) {
								System.out.println("\n다른 사람의 댓글이 없습니다.\n");
							} else {
								System.out.println();
								System.out.println("\n===================댓글리스트===================\n");
								for (CommentDTO comm : anothercomment) {
									System.out.println(comm.getCommentnum() + ". " + comm.getComment_detail() + " ("
											+ comm.getStudentname() + ")");
								}
							}
							System.out.println();
							if (mycomment == null) {
								System.out.println("\n내 댓글이 없습니다.\n");
							} else {
								System.out.println("\n==================내 댓글리스트==================\n");
								;
								for (CommentDTO comm : mycomment) {
									System.out.println(comm.getCommentnum() + ". " + comm.getComment_detail() + " ("
											+ comm.getStudentname() + ")");
								}
								System.out.println("\n=============================================\n");
							}
							int choiceNum = 0;
							while (true) {
								try {
									System.out.println("내 댓글 1. 삭제하기 2. 추가하기 3. 뒤로가기");
									sc = new Scanner(System.in);
									choiceNum = sc.nextInt();

									if (choiceNum == 3) {
										break;
									} else {
										switch (choiceNum) {
										case 1:
											new MyCommentDeleteView();
											break;
										case 2:
											new MyCommentInsertView(choice);
											break;
										default:
											System.out.println("\n다시 입력해주세요...\n");
											break;
										}
									}
								} catch (InputMismatchException ime) {
									System.out.println("\n숫자를 입력해주세요\n");
								} catch (Exception e) {
									System.out.println("\n알 수 없는 오류 발생\n");
								}
								break;
							}
							if (choiceNum == 3) {
								break;
							}
						}
					}
				}
			} catch (InputMismatchException ime) {
				System.out.println("\n숫자를 입력해주세요\n");
			} catch (Exception e) {
				System.out.println("\n알 수 없는 오류 발생\n");
			}
		}
	}
}