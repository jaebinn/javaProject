package model.dto;

import java.util.Objects;

public class QuizDTO {
	private int quiznum;
	private String quiz_type;
	private String quiz_title;
	private String quiz_detail;
	private String quizans;

	public QuizDTO() {
	}

	public QuizDTO(int quiznum, String quiz_type, String quiz_title, String quiz_detail, String quizans) {

		this.quiznum = quiznum;
		this.quiz_type = quiz_type;
		this.quiz_title = quiz_title;
		this.quiz_detail = quiz_detail;
		this.quizans = quizans;

	}

	public int getQuiznum() {
		return quiznum;
	}

	public void setQuiznum(int quiznum) {
		this.quiznum = quiznum;
	}

	public String getQuiz_type() {
		return quiz_type;
	}

	public void setQuiz_type(String quiz_type) {
		this.quiz_type = quiz_type;
	}

	public String getQuiz_title() {
		return quiz_title;
	}

	public void setQuiz_title(String quiz_title) {
		this.quiz_title = quiz_title;
	}

	public String getQuiz_detail() {
		return quiz_detail;
	}

	public void setQuiz_detail(String quiz_detail) {
		this.quiz_detail = quiz_detail;
	}

	public String getQuizans() {
		return quizans;
	}

	public void setQuizans(String quizans) {
		this.quizans = quizans;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		QuizDTO quizDTO = (QuizDTO) obj;
		// 여기에서 필드들을 비교하여 동일한지 여부를 반환
		return quiznum == quizDTO.quiznum && Objects.equals(quiz_type, quizDTO.quiz_type)
				&& Objects.equals(quiz_title, quizDTO.quiz_title) && Objects.equals(quiz_detail, quizDTO.quiz_detail)
				&& Objects.equals(quizans, quizDTO.quizans);
	}

	@Override
	public int hashCode() {
		// hashCode 메서드도 오버라이드하여 equals와 일관성을 유지해야 함
		return Objects.hash(quiznum, quiz_type, quiz_title, quiz_detail, quizans);
	}
}
