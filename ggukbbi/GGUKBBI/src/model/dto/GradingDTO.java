package model.dto;

public class GradingDTO {
	int answerid;
	int score;

	public GradingDTO() {
	}

	public GradingDTO(int answerid, int score) {

		this.answerid = answerid;
		this.score = score;
	}

	public GradingDTO(String[] datas) {

		this.answerid = Integer.parseInt(datas[0]);
		this.score = Integer.parseInt(datas[1]);
	}

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
