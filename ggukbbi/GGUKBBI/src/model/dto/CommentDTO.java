package model.dto;

public class CommentDTO {
	private int commentnum;
	private int announcenum;
	private String studentid;
	private String comment_detail;
	private String studentname;

	public CommentDTO() {
	}

	public CommentDTO(int commentnum, int announcenum, String studentid, String comment_detail, String studentname) {
		super();
		this.commentnum = commentnum;
		this.announcenum = announcenum;
		this.studentid = studentid;
		this.comment_detail = comment_detail;
		this.studentname = studentname;
	}

	public CommentDTO(int commentnum, String comment_detail, String studentname, String studentid) {
		this.commentnum = commentnum;
		this.comment_detail = comment_detail;
		this.studentname = studentname;
		this.studentid = studentid;
	}

	public CommentDTO(int commentnum, int announcenum, String studentid, String comment_detail) {

		this.commentnum = commentnum;
		this.announcenum = announcenum;
		this.studentid = studentid;
		this.comment_detail = comment_detail;

	}

	public int getCommentnum() {
		return commentnum;
	}

	public void setCommentnum(int commentnum) {
		this.commentnum = commentnum;
	}

	public int getAnnouncenum() {
		return announcenum;
	}

	public void setAnnouncenum(int announcenum) {
		this.announcenum = announcenum;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getComment_detail() {
		return comment_detail;
	}

	public void setComment_detail(String comment_detail) {
		this.comment_detail = comment_detail;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

}
