package com.mycom.dao;

import com.mycom.entity.Candidate;

import java.util.List;

public interface CandidateDao {
	public static final String SQL_FINDALL = "select * from "+ Candidate.TABLE_NAME;
	public static final String SQL_SORT_SALARY = "select * from "+ Candidate.TABLE_NAME+" order by "+ Candidate.SALARY_COLUMN;
	public static final String SQL_FINDBYSTATE = "select * from "+ Candidate.TABLE_NAME+" where "+ Candidate.CANDIDATESTATE_COLUMN+"=?";
	public static final String SQL_SORTNAME = "select * from "+ Candidate.TABLE_NAME+" order by "+ Candidate.NAME_COLUMN;
	public static final String SQL_FINDBYID = "select * from "+ Candidate.TABLE_NAME+" where "+ Candidate.ID_COLUMN+"=?";
	public static final String SQL_INSERT = "insert into "+ Candidate.TABLE_NAME+"("+ Candidate.NAME_COLUMN+","+ Candidate.SURNAME_COLUMN+","
			+ ""+ Candidate.SALARY_COLUMN+","+ Candidate.BIRTHDAY_COLUMN+","+ Candidate.CANDIDATESTATE_COLUMN+") values(?,?,?,?,?)";
	public static final String SQL_UPDATE = "update "+ Candidate.TABLE_NAME+" set "+ Candidate.NAME_COLUMN+"=?,"+ Candidate.SURNAME_COLUMN+"=?,"
			+ ""+ Candidate.SALARY_COLUMN+"=?,"+ Candidate.BIRTHDAY_COLUMN+"=?,"+ Candidate.CANDIDATESTATE_COLUMN+"=?"
					+ " where "+ Candidate.ID_COLUMN+"=?";
	public static final String SQL_DELETE = "delete from "+ Candidate.TABLE_NAME+" where "+ Candidate.ID_COLUMN+"=?";
	
	public List<Candidate> findAll();
	public List<Candidate> sortSalaryCandidate();
	public List<Candidate> findByState(String state);
	public Candidate findById(long id);
	public List<Candidate> sortNameCandidate();
	public void insert(Candidate candidate);
	public void update(Candidate candidate);
	public void delete(long candidate_id);
}
