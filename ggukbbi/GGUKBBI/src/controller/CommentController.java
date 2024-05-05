package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.CommentDAO;
import model.dto.CommentDTO;
import model.dto.StudentDTO;

public class CommentController {
	/**
	 *  댓글작성
	 * @param comment
	 * @return
	 */
	public boolean addComment(CommentDTO comment) {
		String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
		CommentDAO cdao = new CommentDAO();
		return cdao.insertcomment(studentid, comment);
	}

	/**
	 * 댓글삭제
	 * @param commentnum
	 * @return
	 */
	public boolean deleteComment(int commentnum) {
		CommentDAO cdao = new CommentDAO();
		return cdao.deleteByCommentnum(commentnum);
	}




	/**
	 *  코멘트넘, 이름, 디테일
	 * @param announcenum
	 * @return
	 */
	public ArrayList<CommentDTO> findCommentByAnnounceNum(int announcenum) {
		CommentDAO cdao = new CommentDAO();

		return cdao.findStudentCommentByAnnounceNum(announcenum);
	}


	/**
	 *  내꺼만 보기
	 * @param announcenum
	 * @return
	 */
	public ArrayList<CommentDTO> divideMyCommentByStudentId(int announcenum) {
		CommentDAO cdao = new CommentDAO();
		String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
		return cdao.divideMyCommentByStudentId(announcenum, studentid);
	}

	/**
	 * 다른사람꺼 보기
	 * @param announcenum
	 * @return
	 */
	public ArrayList<CommentDTO> divideCommentAnotherId(int announcenum) {
		CommentDAO cdao = new CommentDAO();
		String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
		return cdao.divideCommentAnotherId(announcenum, studentid);
	}

}
