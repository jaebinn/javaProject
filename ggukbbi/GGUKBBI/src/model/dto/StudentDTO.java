package model.dto;

public class StudentDTO {
	private String studentid;
	private String stu_pw;
	private String stu_name;
	private int stu_age;
	private String stu_gender;
	private String stu_addr;
	private String stu_major;
	private String stu_phone;

	public StudentDTO() {
	}

	public StudentDTO(String studentid, String stu_pw, String stu_name, int stu_age, String stu_gender, String stu_addr,
			String stu_major, String stu_phone) {

		this.studentid = studentid;
		this.stu_pw = stu_pw;
		this.stu_name = stu_name;
		this.stu_age = stu_age;
		this.stu_gender = stu_gender;
		this.stu_addr = stu_addr;
		this.stu_major = stu_major;
		this.stu_phone = stu_phone;
	}

	public StudentDTO(String[] datas) {

		this.studentid = datas[0];
		this.stu_pw = datas[1];
		this.stu_name = datas[2];
		this.stu_age = Integer.parseInt(datas[0]);
		this.stu_gender = datas[4];
		this.stu_addr = datas[5];
		this.stu_major = datas[6];
		this.stu_phone = datas[7];
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStu_pw() {
		return stu_pw;
	}

	public void setStu_pw(String stu_pw) {
		this.stu_pw = stu_pw;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public int getStu_age() {
		return stu_age;
	}

	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}

	public String getStu_gender() {
		return stu_gender;
	}

	public void setStu_gender(String stu_gender) {
		this.stu_gender = stu_gender;
	}

	public String getStu_addr() {
		return stu_addr;
	}

	public void setStu_addr(String stu_addr) {
		this.stu_addr = stu_addr;
	}

	public String getStu_major() {
		return stu_major;
	}

	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

}
