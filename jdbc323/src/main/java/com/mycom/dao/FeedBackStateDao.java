package com.mycom.dao;

import com.mycom.entity.FeedBackState;

import java.util.List;

public interface FeedBackStateDao {
	public static final String SQL_FINDALL = "select * from "+ FeedBackState.TABLE_NAME;
	
	public List<FeedBackState> FindAll();
}
