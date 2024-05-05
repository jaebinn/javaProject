package model.dto;

public class AnnouncementDTO {
	private int announcenum;
	private String am_title;
	private String teacherid;
	private String am_detail;
	private int am_view;
	private String regdate;

	public AnnouncementDTO() {
	}

	public AnnouncementDTO(int announcenum, String am_title, String teacherid, String am_detail, int am_view,
			String regdate) {

		this.announcenum = announcenum;
		this.am_title = am_title;
		this.teacherid = teacherid;
		this.am_detail = am_detail;
		this.am_view = am_view;
		this.regdate = regdate;
	}

	public AnnouncementDTO(String[] datas) {

		this.announcenum = Integer.parseInt(datas[0]);
		this.am_title = datas[1];
		this.teacherid = datas[2];
		this.am_detail = datas[3];
		this.am_view = Integer.parseInt(datas[4]);
		this.regdate = datas[5];
	}

	public int getAnnouncenum() {
		return announcenum;
	}

	public void setAnnouncenum(int announcenum) {
		this.announcenum = announcenum;
	}

	public String getAm_title() {
		return am_title;
	}

	public void setAm_title(String am_title) {
		this.am_title = am_title;
	}

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getAm_detail() {
		return am_detail;
	}

	public void setAm_detail(String am_detail) {
		this.am_detail = am_detail;
	}

	public int getAm_view() {
		return am_view;
	}

	public void setAm_view(int am_view) {
		this.am_view = am_view;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}