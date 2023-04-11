package com.newlecture.web.db;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.newlecture.web.entity.*;

public class NoticeDAO {
	/*
	 * String dbID = "chun"; String dbPwd = "1234"; String dbURL =
	 * "jdbc:mysql://localhost:3306/dbpractice"; // 접속url
	 * 
	 * public List<Notice> getAllList(){ List<Notice> list = null;
	 * 
	 * try { Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
	 * DriverManager.getConnection(dbURL, dbID, dbPwd);
	 * 
	 * String sql = "SELECT * FROM NOTICE"; Statement st = con.createStatement();
	 * ResultSet rs = st.executeQuery(sql);
	 * 
	 * list = new ArrayList<>(); while (rs.next()) { Notice notice = new Notice();
	 * notice.setId(rs.getInt("ID")); notice.setWriterId(rs.getString("WRITER_ID"));
	 * notice.setTitle(rs.getString("TITLE"));
	 * notice.setRegdate(rs.getDate("REGDATE")); notice.setHit(rs.getInt("HIT"));
	 * list.add(notice); }
	 * 
	 * rs.close(); st.close(); con.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return list; }
	 * 
	 * public Notice getNoticeDetail(int id) { Notice notice = null; try {
	 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
	 * DriverManager.getConnection(dbURL, dbID, dbPwd);
	 * 
	 * String hitdql = "UPDATE NOTICE SET HIT = HIT + 1 WHERE ID = ?";
	 * PreparedStatement pstmt = con.prepareStatement(hitdql); pstmt.setInt(1, id);
	 * pstmt.executeUpdate();
	 * 
	 * String sql = "SELECT * FROM NOTICE WHERE ID = ?"; pstmt =
	 * con.prepareStatement(sql); pstmt.setInt(1, id); ResultSet rs =
	 * pstmt.executeQuery();
	 * 
	 * rs.next(); String title = rs.getString("TITLE"); Date regdate =
	 * rs.getDate("REGDATE"); String writerId = rs.getString("WRITER_ID"); int hit =
	 * rs.getInt("HIT"); String files = rs.getString("FILES"); String content =
	 * rs.getString("CONTENT");
	 * 
	 * notice = new Notice( id, title, regdate, writerId, hit, files, content);
	 * 
	 * rs.close(); pstmt.close(); con.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return notice; }
	 */
}
