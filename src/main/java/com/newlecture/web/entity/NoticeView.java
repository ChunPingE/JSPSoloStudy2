package com.newlecture.web.entity;

import java.sql.*;

public class NoticeView extends Notice {
	private int cmtCount;

	public NoticeView() {
	}

	public NoticeView(int id, String title, Date regdate, String writerId, int hit, String files, String content,
			boolean pub, int cmtCount) {
		super(id, title, regdate, writerId, hit, files, "", pub);
		this.cmtCount = cmtCount;
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
}
