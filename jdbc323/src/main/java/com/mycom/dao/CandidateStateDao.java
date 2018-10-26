package com.mycom.dao;

import com.mycom.entity.CandidateState;

import java.util.List;

public interface CandidateStateDao {
	public static final String SQL_FINDALL = "select * from "+ CandidateState.TABLE_NAME;
	
	public List<CandidateState> FindAll();
}
