package com.newlecture.web.service;

import java.sql.*;
import java.util.*;

import com.newlecture.web.entity.*;

public class NoticeService {
	String dbID = "chun";
	String dbPwd = "1234";
	String dbURL = "jdbc:mysql://localhost:3306/dbpractice";

	public int removeNoticeAll(int[] ids) {
		return 0;
	}

	public int pubNoitceAll(int[] ids) {
		return 0;
	}

	public int insertNotice(Notice notice) {
		return 0;
	}

	public int deleteNotice(int id) {
		return 0;
	}

	public int updateNotice(Notice notice) {
		return 0;
	}

	public List<Notice> getNoticeNewestList() {
		return null;
	}

	public List<NoticeView> getNoticeViewList() {
		return getNoticeViewList("title", "", 1);
	}

	public List<NoticeView> getNoticeViewList(int page) {
		return getNoticeViewList("title", "", page);
	}

	public List<NoticeView> getNoticeViewList(String field, String query, int page) {
		List<NoticeView> list = new ArrayList<>();

		int startNum = (page - 1) * 10;
		int lastNum = 10;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbURL, dbID, dbPwd);

			String sql = "SELECT * FROM NOTICE_VIEW WHERE " + field + " LIKE ? ORDER BY REGDATE DESC LIMIT ?, ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, lastNum);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeView notice = new NoticeView();
				notice.setId(rs.getInt("ID"));
				notice.setWriterId(rs.getString("WRITER_ID"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setHit(rs.getInt("HIT"));
				notice.setCmtCount(rs.getInt("CMT_COUNT"));
				list.add(notice);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getNoticeCount() {
		return getNoticeCount("TITLE", "");
	}

	public int getNoticeCount(String field, String query) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbURL, dbID, dbPwd);
			String sql = "SELECT COUNT(ID) COUNT FROM NOTICE WHERE " + field + " LIKE ? ORDER BY REGDATE DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("COUNT");
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public Notice getNotice(int id) {

		Notice notice = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbURL, dbID, dbPwd);

			String sql = "SELECT * FROM NOTICE WHERE ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				notice = new Notice();
				notice.setId(rs.getInt("ID"));
				notice.setWriterId(rs.getString("WRITER_ID"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setHit(rs.getInt("HIT"));
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getNextNotice(int id) {
		Notice notice = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbURL, dbID, dbPwd);

			String sql = "SELECT ID FROM NOTICE WHERE ID > 3 ORDER BY REGDATE ASC LIMIT 1";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				notice = new Notice();
				notice.setId(rs.getInt("ID"));
				notice.setWriterId(rs.getString("WRITER_ID"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setHit(rs.getInt("HIT"));
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getPrevNotice(int id) {
		Notice notice = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dbURL, dbID, dbPwd);

			String sql = "SELECT ID FROM NOTICE WHERE ID < 3 ORDER BY REGDATE DESC LIMIT 1";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				notice = new Notice();
				notice.setId(rs.getInt("ID"));
				notice.setWriterId(rs.getString("WRITER_ID"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setHit(rs.getInt("HIT"));
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return notice;
	}
}
