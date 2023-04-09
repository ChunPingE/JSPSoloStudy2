package com.newlecture.web.service;

import java.util.*;

import com.newlecture.web.entity.*;

public class NoticeService {
	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);
	}

	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);
	}
  
	public List<Notice> getNoticeList(String field, String query, int page) {
		String sql = "SELECT * FROM NOTICE ORDER BY REGDATE DESC LIMIT ?, ?";
		return null;
	}

	public int getNoticeCount() {
		return getNoticeCount("", "");
	}

	public int getNoticeCount(String field, String query) {
		return 0;
	}

	public Notice getNotice(int id) {
		return null;
	}

	public Notice getNextNotice(int id) {
		return null;
	}

	public Notice getPrevNotice(int id) {
		return null;
	}
}
