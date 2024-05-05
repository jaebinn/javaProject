package model.dto;

public class MessengerDTO {
	private int msg_num;
	private String msg_title;
	private int cl_id;
	private String sendtime;
	private String msg_detail;
	private String id;
	private int GNT;

	public MessengerDTO() {
	}

	public MessengerDTO(int msg_num, String msg_title, int cl_id, String sendtime, String msg_detail) {

		this.msg_num = msg_num;
		this.msg_title = msg_title;
		this.cl_id = cl_id;
		this.sendtime = sendtime;
		this.msg_detail = msg_detail;
	}

	public MessengerDTO(int msg_num, String msg_title, String studentid, String sendtime, String msg_detail) {
		this.msg_num = msg_num;
		this.msg_title = msg_title;
		this.id = studentid;
		this.sendtime = sendtime;
		this.msg_detail = msg_detail;
	}

	public MessengerDTO(int msg_num, String msg_title, int cl_id, String sendtime, String msg_detail, int GNT) {

		this.msg_num = msg_num;
		this.msg_title = msg_title;
		this.cl_id = cl_id;
		this.sendtime = sendtime;
		this.msg_detail = msg_detail;
		this.GNT = GNT;
	}

	public MessengerDTO(int msg_num, String msg_title, String studentid, String sendtime, String msg_detail, int GNT) {
		this.msg_num = msg_num;
		this.msg_title = msg_title;
		this.id = studentid;
		this.sendtime = sendtime;
		this.msg_detail = msg_detail;
		this.GNT = GNT;
	}

	public int getGNT() {
		return GNT;
	}

	public void setGNT(int gNT) {
		GNT = gNT;
	}

	public String getId() {
		return id;
	}

	public void setId(String studentid) {
		this.id = studentid;
	}

	public int getMsg_num() {
		return msg_num;
	}

	public void setMsg_num(int msg_num) {
		this.msg_num = msg_num;
	}

	public String getMsg_title() {
		return msg_title;
	}

	public void setMsg_title(String msg_title) {
		this.msg_title = msg_title;
	}

	public int getCl_id() {
		return cl_id;
	}

	public void setCl_id(int string) {
		this.cl_id = string;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getMsg_detail() {
		return msg_detail;
	}

	public void setMsg_detail(String msg_detail) {
		this.msg_detail = msg_detail;
	}
}
