package model.dto;

public class AnswerDTO {
	int answerid;
	int cl_id;
	int quiznum;
	String stu_answer;
	String regdate;

	public AnswerDTO() {
	}

	public AnswerDTO(int answerid, int cl_id, int quiznum, String stu_answer, String regdate) {

		this.answerid = answerid;
		this.cl_id = cl_id;
		this.quiznum = quiznum;
		this.stu_answer = stu_answer;
		this.regdate = regdate;
	}

	public AnswerDTO(String[] datas) {

		this.answerid = Integer.parseInt(datas[0]);
		this.cl_id = Integer.parseInt(datas[1]);
		this.quiznum = Integer.parseInt(datas[2]);
		this.stu_answer = datas[3];
		this.regdate = datas[4];
	}

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public int getCl_id() {
		return cl_id;
	}

	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}

	public int getQuiznum() {
		return quiznum;
	}

	public void setQuiznum(int quiznum) {
		this.quiznum = quiznum;
	}

	public String getStu_answer() {
		return stu_answer;
	}

	public void setStu_answer(String stu_answer) {
		this.stu_answer = stu_answer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
