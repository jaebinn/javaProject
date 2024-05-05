package model.dto;

public class ClassroomDTO {
	private String classroomid;
	private String cr_location;
	private int cr_student;

	public ClassroomDTO() {
	}

	public ClassroomDTO(String classroomid, String cr_location, int cr_student) {

		this.classroomid = classroomid;
		this.cr_location = cr_location;
		this.cr_student = cr_student;
	}

	public ClassroomDTO(String[] datas) {

		this.classroomid = datas[0];
		this.cr_location = datas[1];
		this.cr_student = Integer.parseInt(datas[2]);
	}

	public String getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}

	public String getCr_location() {
		return cr_location;
	}

	public void setCr_location(String cr_location) {
		this.cr_location = cr_location;
	}

	public int getCr_student() {
		return cr_student;
	}

	public void setCr_student(int cr_student) {
		this.cr_student = cr_student;
	}

}
