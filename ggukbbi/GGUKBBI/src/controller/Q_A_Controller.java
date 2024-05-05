package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.Session;
import model.dao.AnswerDAO;
import model.dao.GradingDAO;
import model.dao.LectureDAO;
import model.dao.QuizDAO;
import model.dao.StudentDAO;
import model.dto.AnswerDTO;
import model.dto.GradingDTO;
import model.dto.QuizDTO;
import model.dto.StudentDTO;
import model.dto.TeacherDTO;

public class Q_A_Controller {
//   quiz관련컨트롤러

	/**
	 * 퀴즈추가 (관리자만 사용가능)
	 * 
	 * @param quiz
	 * @return
	 */
	public boolean addQuiz(QuizDTO quiz) {
		QuizDAO qdao = new QuizDAO();
		return qdao.insertQuiz(quiz);
	}

	/**
	 * 퀴즈타입 번호에 따른 퀴즈리스트 가져오기
	 * 
	 * @param choice (1.자바 2.html 3.sql)
	 * @return
	 */
	public ArrayList<QuizDTO> getList(int choice) {
		QuizDAO qdao = new QuizDAO();

		return qdao.getList(choice);
	}

	/**
	 * 해당 퀴즈분류에 따른 제출한시험 리스트
	 * 
	 * @param choice (1.자바 2.html 3.sql)
	 * @return
	 */
	public ArrayList<QuizDTO> getSolveList(int choice) {
		QuizDAO qdao = new QuizDAO();
		String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();

		return qdao.getSolveList(studentid, choice);
	}

	/**
	 * 해당 퀴즈분류에 따른 미제출한시험 리스트
	 * 
	 * @param choice (1.자바 2.html 3.sql)
	 * @return
	 */
	public ArrayList<QuizDTO> getNotSolveList(int choice) {
		QuizDAO qdao = new QuizDAO();
		String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
		ArrayList<QuizDTO> qlist1 = qdao.getList(choice);
		ArrayList<QuizDTO> qlist2 = qdao.getSolveList(studentid, choice);

		// list1에서 list2와 동일한 값을 가진 객체 제거
		Iterator<QuizDTO> iterator = qlist1.iterator();
		while (iterator.hasNext()) {
			QuizDTO value = iterator.next();
			if (qlist2.contains(value)) {
				iterator.remove();
			}
		}
		return qlist1;
	}

	/**
	 * 퀴즈넘에 따른 퀴즈 내용
	 * 
	 * @param quiznum
	 * @return
	 */
	public QuizDTO getQuiz_DetailByQuiznum(int quiznum) {
		QuizDAO qdao = new QuizDAO();
		return qdao.findQuizNum(quiznum);
	}

	/**
	 * 퀴즈넘에 따른 문제푼 학생 리스트
	 * 
	 * @param quiznum
	 * @return
	 */
	public ArrayList<StudentDTO> getStudentByAnswer(int quiznum) {
		StudentDAO sdao = new StudentDAO();
		LectureDAO ldao = new LectureDAO();
		String teacherid = ((TeacherDTO) Session.getData("loginTeacher")).getTeacherid();
		int lectureid = ldao.findLectureByTeacherid(teacherid).getLectureid();

		return sdao.getStudentByQuiznum(lectureid, quiznum);
	}

//   answer관련컨트롤러
	/**
	 * 문제답변추가
	 * 
	 * @param
	 * @return
	 */
	public boolean addAnswer(AnswerDTO answer) {

		AnswerDAO adao = new AnswerDAO();
		return adao.insertAnswer(answer);
	}

	/**
	 * 성적입력(강사용)
	 * 
	 * @param score
	 * @return
	 */
	public boolean gradingByAnswer(GradingDTO score) {
		GradingDAO gdao = new GradingDAO();
		return gdao.insertGrade(score);
	}

	/**
	 * quiznum으로 학생 성적빼오기
	 * 
	 * @param quiznum
	 * @return
	 */
	public GradingDTO getMyGrade(int quiznum) {
		GradingDAO gdao = new GradingDAO();
		AnswerDAO adao = new AnswerDAO();
		String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
		int answerid = (adao.getAnswerByStudentid(studentid, quiznum)).getAnswerid();
		return gdao.findGradeByQuiznum(answerid);
		// grading, answer 컬럼quiznum 중복
	}

	/**
	 * 퀴즈넘으로 내 답변 가져오기
	 * 
	 * @param quiznum
	 * @return
	 */
	public AnswerDTO getMyAnswer(int quiznum) {
		AnswerDAO adao = new AnswerDAO();
		String studentid = ((StudentDTO) Session.getData("loginStudent")).getStudentid();
		return adao.getAnswerByStudentid(studentid, quiznum);
	}

	/**
	 * 학생 아이디로 답변가져오기
	 * 
	 * @param studentid
	 * @return
	 */
	public AnswerDTO getAnswerByStudentid(String studentid, int quiznum) {
		AnswerDAO adao = new AnswerDAO();
		return adao.getAnswerByStudentid(studentid, quiznum);
	}

}