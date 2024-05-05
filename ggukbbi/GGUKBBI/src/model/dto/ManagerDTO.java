package model.dto;

public class ManagerDTO {
	private String managerid;
	private String managerpw;

	public ManagerDTO() {
	}

	public ManagerDTO(String managerid, String managerpw) {
		this.managerid = managerid;
		this.managerpw = managerpw;
	}

	public ManagerDTO(String[] datas) {
		this.managerid = datas[0];
		this.managerpw = datas[1];
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getManagerpw() {
		return managerpw;
	}

	public void setManagerpw(String managerpw) {
		this.managerpw = managerpw;
	}

}
