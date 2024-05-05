package model.dto;

public class TeacherDTO {
	private String teacherid;
	private String tea_pw;
	private String tea_name;
	private int tea_age;
	private String tea_gender;
	private String tea_phone;

	public TeacherDTO() {
	}

	public TeacherDTO(String teacherid, String tea_pw, String tea_name, int tea_age, String tea_gender,
			String tea_phone) {

		this.teacherid = teacherid;
		this.tea_pw = tea_pw;
		this.tea_name = tea_name;
		this.tea_age = tea_age;
		this.tea_gender = tea_gender;
		this.tea_phone = tea_phone;
	}

	public TeacherDTO(String[] datas) {

		this.teacherid = datas[0];
		this.tea_pw = datas[1];
		this.tea_name = datas[2];
		this.tea_age = Integer.parseInt(datas[3]);
		this.tea_gender = datas[4];
		this.tea_phone = datas[5];
	}

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getTea_pw() {
		return tea_pw;
	}

	public void setTea_pw(String tea_pw) {
		this.tea_pw = tea_pw;
	}

	public String getTea_name() {
		return tea_name;
	}

	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}

	public int getTea_age() {
		return tea_age;
	}

	public void setTea_age(int tea_age) {
		this.tea_age = tea_age;
	}

	public String getTea_gender() {
		return tea_gender;
	}

	public void setTea_gender(String tea_gender) {
		this.tea_gender = tea_gender;
	}

	public String getTea_phone() {
		return tea_phone;
	}

	public void setTea_phone(String tea_phone) {
		this.tea_phone = tea_phone;
	}

}
