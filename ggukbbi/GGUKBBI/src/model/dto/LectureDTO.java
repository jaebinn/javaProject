package model.dto;

public class LectureDTO {
	private int lectureid;
	private String lec_name;
	private String classroomid;
	private String lec_beginday;
	private String teacherid;

	public LectureDTO() {
	}

	public LectureDTO(int lectureid, String lec_name, String classroomid, String lec_beginday, String teacherid) {
		this.lectureid = lectureid;
		this.lec_name = lec_name;
		this.classroomid = classroomid;
		this.lec_beginday = lec_beginday;
		this.teacherid = teacherid;
	}

//	public LectureDTO(String [] datas) {
//		this.lectureid = Integer.parseInt(datas[0]);
//		this.lec_name = datas[1];
//		this.classroomid = datas[2];
//		this.lec_beginday = datas[3];
//		this.teacherid = datas[4];
//	}

	public int getLectureid() {
		return lectureid;
	}

	public void setLectureid(int lectureid) {
		this.lectureid = lectureid;
	}

	public String getLec_name() {
		return lec_name;
	}

	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}

	public String getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}

	public String getLec_beginday() {
		return lec_beginday;
	}

	public void setLec_beginday(String lec_beginday) {
		this.lec_beginday = lec_beginday;
	}

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

}
