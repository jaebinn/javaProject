package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.LectureDTO;

public class LectureDAO {
   Connection conn;
   PreparedStatement ps;
   ResultSet rs;

   public LectureDAO() {
      conn = DBConnection.getConnection();
   }

   /**
    * 강좌등록
    * @param lecture
    * @return
    */
   public boolean insertLecture(LectureDTO lecture) {
      String sql = "insert into lecture(lec_name, classroomid, lec_beginday, teacherid) values(?,?,?,?)";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, lecture.getLec_name());
         ps.setString(2, lecture.getClassroomid());
         ps.setString(3, lecture.getLec_beginday());
         ps.setString(4, lecture.getTeacherid());

         int result = ps.executeUpdate();
         return result == 1;
      } catch (SQLException e) {
      }
      return false;
   }

   /**
    * 강좌 수정
    * @param choice = 1 : lec_name, 2 : classroomid, 3 : lec_beginday, 4 : teacherid
    * @param lectureid
    * @param newData = 변경할 내용
    * @return
    */
   public boolean updateLecture(int choice, int lectureid, String newData) {
      String[] cols = { "", "lec_name", "classroomid", "lec_beginday", "teacherid" };
      String sql = "update lecture set " + cols[choice] + " = ? where lectureid = ?";

      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, newData);
         ps.setInt(2, lectureid);

         int result = ps.executeUpdate();

         return result == 1;
      } catch (SQLException e) {
      }
      return false;
   }

   /**
    * 렉처id로 강좌 내용 가져오기
    * @param lectureId
    * @return
    */
   public LectureDTO findLectureById(int lectureId) {
      String sql = "select * from lecture where lectureid = ?";
      try {
         ps = conn.prepareStatement(sql);
         ps.setInt(1, lectureId);

         rs = ps.executeQuery();
         if (rs.next()) {
            LectureDTO lecture = new LectureDTO();
            lecture.setLectureid(rs.getInt("lectureid"));
            lecture.setLec_name(rs.getString("lec_name"));
            lecture.setLec_beginday(rs.getString("lec_beginday"));
            lecture.setTeacherid(rs.getString("teacherid"));
            lecture.setClassroomid(rs.getString("classroomid"));

            return lecture;
         }
      } catch (SQLException e) {
      }
      return null;
   }

   /**
    * 모든 강좌목록 시작일 기준으로 내림차순으로 가져오기
    * @return
    */
   public ArrayList<LectureDTO> getList() {
      String sql = "select * from lecture order by lec_beginday desc";

      try {
         ps = conn.prepareStatement(sql);

         rs = ps.executeQuery();

         ArrayList<LectureDTO> list = new ArrayList<LectureDTO>();

         while (rs.next()) {
            LectureDTO lecture = new LectureDTO(rs.getInt("lectureid"), rs.getString("lec_name"),
                  rs.getString("classroomid"), rs.getString("lec_beginday"), rs.getString("teacherid"));
            list.add(lecture);
         }
         return list;
      } catch (SQLException e) {
      }
      return null;
   }
   
   public LectureDTO findLectureByTeacherid(String teacherid){
      String sql = "select * from lecture where teacherid = ?";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, teacherid);

         rs = ps.executeQuery();
         if (rs.next()) {
            LectureDTO lecture = new LectureDTO();
            lecture.setLectureid(rs.getInt("lectureid"));
            lecture.setLec_name(rs.getString("lec_name"));
            lecture.setLec_beginday(rs.getString("lec_beginday"));
            lecture.setTeacherid(rs.getString("teacherid"));
            lecture.setClassroomid(rs.getString("classroomid"));

            return lecture;
         }
      } catch (SQLException e) {
      }
      return null;
   }
   
   public LectureDTO findLectureByStudentid(String studentid) {
      String sql = "select l.lectureid, l.lec_name, l.lec_beginday, l.teacherid, l.classroomid "
            + "from course_list cl "
            + "join lecture l "
            + "on cl.lectureid = l.lectureid "
            + "where studentid = ?";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, studentid);

         rs = ps.executeQuery();
         if (rs.next()) {
            LectureDTO lecture = new LectureDTO();
            lecture.setLectureid(rs.getInt("lectureid"));
            lecture.setLec_name(rs.getString("lec_name"));
            lecture.setLec_beginday(rs.getString("lec_beginday"));
            lecture.setTeacherid(rs.getString("teacherid"));
            lecture.setClassroomid(rs.getString("classroomid"));

            return lecture;
         }
      } catch (SQLException e) {
      }
      return null;
   }
}