package model.dto;

public class CourseListDTO {
	public int lectureid;
	public String studentid;
	public int cl_id;

	public CourseListDTO() {
	}

	public CourseListDTO(int lectureid, String studentid, int cl_id) {
		super();
		this.lectureid = lectureid;
		this.studentid = studentid;
		this.cl_id = cl_id;
	}

	public int getLectureid() {
		return lectureid;
	}

	public void setLectureid(int lectureid) {
		this.lectureid = lectureid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public int getCl_id() {
		return cl_id;
	}

	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
}