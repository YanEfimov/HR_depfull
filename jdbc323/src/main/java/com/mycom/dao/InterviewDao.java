package com.mycom.dao;

import com.mycom.entity.Interview;

import java.util.List;

public interface InterviewDao {
	public static final String SQL_FINDALL = "select * from "+ Interview.TABLE_NAME;
	public static final String SQL_SORT_BY_DATEFACT = "select * from "+ Interview.TABLE_NAME+" order by "+ Interview.FACTDATE_COLUMN;
	public static final String SQL_SORT_BY_DATEPLAN = "select * from "+ Interview.TABLE_NAME+" order by "+ Interview.PLANDATE_COLUMN;
	public static final String SQL_FINDBYCANDIDATE = "select * from "+ Interview.TABLE_NAME+" where "+ Interview.IDCANDIDATE_COLUMN+"=?";
	public static final String SQL_FINDBYID = "select * from "+ Interview.TABLE_NAME+" where "+ Interview.ID_COLUMN+"=?";
	public static final String SQL_INSERT = "insert into "+ Interview.TABLE_NAME+"("+ Interview.PLANDATE_COLUMN+","+ Interview.FACTDATE_COLUMN+","
			+ ""+ Interview.IDCANDIDATE_COLUMN+","+ Interview.IDVACANCY_COLUMN+","+ Interview.NAME_CLOUMN+") values(?,?,?,?,?)";
	public static final String SQL_UPDATE = "update "+ Interview.TABLE_NAME+" set "+ Interview.PLANDATE_COLUMN+"=?, "+ Interview.FACTDATE_COLUMN+"=?,"
			+ " "+ Interview.IDCANDIDATE_COLUMN+"=?, "+ Interview.IDVACANCY_COLUMN+"=?, "+ Interview.NAME_CLOUMN+"=? where "+ Interview.ID_COLUMN+"=?";
	public static final String SQL_DELETE = "delete from "+ Interview.TABLE_NAME+" where "+ Interview.ID_COLUMN+"=?";
	
	public List<Interview> findAll();
	public List<Interview> SortByDateFact();
	public List<Interview> SortByDatePlan();
	public List<Interview> FindByCandidate(long candidate_id);
	public Interview FindById(long id);
	public void insert(Interview interview);
	public void update(Interview interview);
	public void delete(long interview_id);
	
}
