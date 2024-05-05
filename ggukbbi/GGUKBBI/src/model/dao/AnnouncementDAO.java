package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.AnnouncementDTO;

public class AnnouncementDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public AnnouncementDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * 공지사항 등록
	 * @param announcement
	 * @return
	 */
	public boolean insertAnnouncement(AnnouncementDTO announcement) {
		String sql = "insert into Announcement (am_title,teacherid,am_detail) " + "values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, announcement.getAm_title());
			ps.setString(2, announcement.getTeacherid());
			ps.setString(3, announcement.getAm_detail());

			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/**
	 * 공지사항 번호에 따른 공지사항 삭제
	 * @param announcenum = 공사항번호
	 * @return
	 */
	public boolean deleteByAnnouncementNum(int announcementNum) {
		String sql = "delete from announcement where announcenum = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, announcementNum);
			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	/** 
	 * 공지사항 번호에 따른 공지사항 수정 
	 * @param announcenum = 공지사항번호
	 * @param choice = 1:제목, 2:내용
	 * @param newData = 바꿀내용
	 * @return
	 */
	public boolean updateAnnouncement(int announcenum, int choice, String newData) {
		String[] cols = { "am_title", "am_detail" };
		String sql = "update announcement set " + cols[choice - 1] + " = ? where announcenum = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setInt(2, announcenum);

			int result = ps.executeUpdate();

			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}


	/**
	 * 공지사항 번호로 내용 가져오기
	 * @param announcenum = 공지사항번호
	 * @return
	 */
	public AnnouncementDTO findAnnounceNum(int announcenum) {
		String sql = "select * from announcement where announcenum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, announcenum);

			rs = ps.executeQuery();
			if (rs.next()) {
				AnnouncementDTO announcement = new AnnouncementDTO();
				announcement.setAnnouncenum(rs.getInt("announcenum"));
				announcement.setAm_title(rs.getString("am_title"));
				announcement.setTeacherid(rs.getString("teacherid"));
				announcement.setAm_detail(rs.getString("am_detail"));
				announcement.setAm_view(rs.getInt("am_view"));
				announcement.setRegdate(rs.getString("regdate"));

				return announcement;
			}
		} catch (SQLException e) {
		}
		// 결과가 없다면 null 리턴
		return null;
	}

	/**
	 * teacherid로 반 공지리스트 가져오기
	 * @param teacherid
	 * @return
	 */
	public ArrayList<AnnouncementDTO> getAnnouncementList(String teacherid) {
		String sql = "select * from announcement where teacherid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacherid);
			rs = ps.executeQuery();

			ArrayList<AnnouncementDTO> list = new ArrayList<AnnouncementDTO>();

			while (rs.next()) {
				AnnouncementDTO announcement = new AnnouncementDTO(rs.getInt("announcenum"), rs.getString("am_title"),
						rs.getString("teacherid"), rs.getString("am_detail"), rs.getInt("am_view"),
						rs.getString("regdate"));

				list.add(announcement);
			}
			return list;
		} catch (SQLException e) {
		}
		return null;
	}

	/**
	 * 공지사항 조회수 1증가
	 * @param announcenum = 공지사항 번호
	 * @return
	 */
	public AnnouncementDTO announcementCounter(int announcenum) {

		String sql = "UPDATE announcement SET am_view = am_view + 1 WHERE announcenum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, announcenum);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
