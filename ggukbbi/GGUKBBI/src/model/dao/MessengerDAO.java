package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.MessengerDTO;

public class MessengerDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

	public MessengerDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * 메세지 번호로 메신저 내용 가져오기
	 * @param messengerNum = 메세지 번호
	 * @return
	 */
	public MessengerDTO findMessengerNum(int messengerNum) {
		String sql = "select * from messenger where msg_num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, messengerNum);

			rs = ps.executeQuery();
			if (rs.next()) {
				MessengerDTO messenger = new MessengerDTO();
				messenger.setMsg_num(rs.getInt("msg_num"));
				messenger.setMsg_title(rs.getString("msg_title"));
				messenger.setCl_id(rs.getInt("cl_id"));
				messenger.setSendtime(rs.getString("sendtime"));
				messenger.setMsg_detail(rs.getString("msg_detail"));
				messenger.setGNT(rs.getInt("GNT"));

				return messenger;
			}
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * cl_id값으로 메세지 리스트 가져오기
	 * @param cl_id
	 * @return
	 */
	public ArrayList<MessengerDTO> getList(int cl_id) {
		String sql = "select * from messenger where cl_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cl_id);
			rs = ps.executeQuery();

			ArrayList<MessengerDTO> list = new ArrayList<MessengerDTO>();

			while (rs.next()) {
				MessengerDTO messenger = new MessengerDTO(rs.getInt("msg_num"), rs.getString("msg_title"),
						rs.getInt("cl_id"), rs.getString("sendtime"), rs.getString("msg_detail"), rs.getInt("GNT"));

				list.add(messenger);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * cl_id로 학생한테온 리스트 가져오기
	 * 	MessengerDTO(msg_num, msg_title, teacherid, sendtime, msg_detail, GNT) 가 담겨옴
	 * @param cl_id
	 * @return
	 */
	public ArrayList<MessengerDTO> getStuMessengerListByClId(int cl_id) {
		String sql = "select m.msg_num, m.msg_title, l.teacherid, m.sendtime, m.msg_detail, m.GNT from messenger m inner join course_list c on m.cl_id = c.cl_id inner join lecture l on c.lectureid = l.lectureid where m.cl_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cl_id);
			rs = ps.executeQuery();

			ArrayList<MessengerDTO> list = new ArrayList<MessengerDTO>();

			while (rs.next()) {
				MessengerDTO messenger = new MessengerDTO(rs.getInt("msg_num"), rs.getString("msg_title"),
						rs.getString("teacherid"), rs.getString("sendtime"), rs.getString("msg_detail"),
						rs.getInt("GNT"));

				list.add(messenger);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * 메세지 보내기
	 * @param message
	 * @return
	 */
	public boolean sendMessenger(MessengerDTO message) {

		String sql = "insert into messenger (msg_num, msg_title, cl_id, sendtime, msg_detail, GNT)"
				+ " values(?,?,?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, message.getMsg_num());
			ps.setString(2, message.getMsg_title());
			ps.setInt(3, message.getCl_id());
			ps.setTimestamp(4, currentTimestamp);
			ps.setString(5, message.getMsg_detail());
			ps.setInt(6, message.getGNT());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * cl_id로 메세지 삭제
	 * @param cl_id
	 * @return
	 */
	public boolean deleteMessengerByCl_ID(int cl_id) {
		String sql = "delete from messenger where cl_id =?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, cl_id);
			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/**
	 * 티처 아이디로 메신저 가져오기
	 * 	MessengerDTO(msg_num, msg_title, studentid, sendtime, msg_detail, GNT)가 담겨옴
	 * @param teacherid
	 * @return
	 */
	public ArrayList<MessengerDTO> getTeaMessengerListByTeacherid(String teacherid) {
		String sql = "SELECT m.msg_num, m.msg_title, s.studentid, m.sendtime, m.msg_detail, m.GNT "
				+ "FROM messenger m " + "JOIN course_list c ON m.cl_id = c.cl_id "
				+ "JOIN student s ON c.studentid = s.studentid " + "JOIN lecture l ON c.lectureid = l.lectureid "
				+ "WHERE l.teacherid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacherid);
			rs = ps.executeQuery();

			ArrayList<MessengerDTO> list = new ArrayList<MessengerDTO>();

			while (rs.next()) {
				MessengerDTO messenger = new MessengerDTO(rs.getInt("msg_num"), rs.getString("msg_title"),
						rs.getString("studentid"), rs.getString("sendtime"), rs.getString("msg_detail"),
						rs.getInt("GNT"));

				list.add(messenger);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}
}
