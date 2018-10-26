package com.mycom.dao;

import com.mycom.entity.Vacancy;

import java.util.List;

public interface VacancyDao {
	public static final String SQL_FINDALL = "select * from "+ Vacancy.TABLE_NAME;
	public static final String SQL_SORTFORSALARYTO = "select * from "+ Vacancy.TABLE_NAME+" order by "+ Vacancy.SALARYTO_COLUMN;
	public static final String SQL_SORTFORSALARYFROM = "select * from "+ Vacancy.TABLE_NAME+" order by "+ Vacancy.SALARYFROM_COLUMN;
	public static final String SQL_SORTFOREXPERIENCE = "select * from "+ Vacancy.TABLE_NAME+" order by "+ Vacancy.EXPERIENCEYEARREQUIRE_COLUMN;
	public static final String SQL_FINDFORCREATE = "select * from "+ Vacancy.TABLE_NAME+" where "+ Vacancy.IDDEVELOPER+"=?";
	public static final String SQL_FINDBYID = "select * from "+ Vacancy.TABLE_NAME+" where "+ Vacancy.ID_COLUMN+"=?";
	public static final String SQL_INSERT = "insert into "+ Vacancy.TABLE_NAME+"("+ Vacancy.POSITION_COLUMN+", "+ Vacancy.SALARYTO_COLUMN+""
			+ ", "+ Vacancy.SALARYFROM_COLUMN+","+ Vacancy.EXPERIENCEYEARREQUIRE_COLUMN+","+ Vacancy.IDDEVELOPER+")"
					+ " values(?,?,?,?,?)";
	public static final String SQL_UPDATE = "update "+ Vacancy.TABLE_NAME+" set "+ Vacancy.POSITION_COLUMN+"=?, "+ Vacancy.SALARYTO_COLUMN+"=?, "
			+ ""+ Vacancy.SALARYFROM_COLUMN+"=?, "+ Vacancy.EXPERIENCEYEARREQUIRE_COLUMN+"=?, "+ Vacancy.IDDEVELOPER+"=? "
					+ "where "+ Vacancy.ID_COLUMN+"=?";
	public static final String SQL_DELETE = "delete from "+ Vacancy.TABLE_NAME+" where "+ Vacancy.ID_COLUMN+"=?";
	
	public List<Vacancy> findAll();
	public List<Vacancy> sortForSalaryTo();
	public List<Vacancy> sortForSalaryFrom();
	public List<Vacancy> sortForExperience();
	public List<Vacancy> findByCreate(long idDeveloper);
	public Vacancy findById(long id);
	public void insert(Vacancy vacancy);
	public void update(Vacancy vacancy);
	public void delete(long vacancy_id);
	
}
