package controller;

import model.dao.CourseListDAO;
import model.dto.CourseListDTO;

public class CourseListController {
	/**
	 * 수강목록 등록
	 * @param courseList
	 * @return
	 */
	public boolean joinCourseList(CourseListDTO courseList) {
		CourseListDAO cdao = new CourseListDAO();

		return cdao.insertCourse(courseList);
	}
}