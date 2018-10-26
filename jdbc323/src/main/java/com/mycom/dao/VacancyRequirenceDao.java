package com.mycom.dao;

import com.mycom.entity.VacancyRequirence;

import java.util.List;

public interface VacancyRequirenceDao {
	public static final String SQL_FIND_BY_ID = "select "+ VacancyRequirence.SKILL_COLUMN+" from "+ VacancyRequirence.TABLE_NAME+" where "
			+ " "+ VacancyRequirence.IDVACANCY_COLUMN+"=?";
	public static final String SQL_INSERT = "insert into "+ VacancyRequirence.TABLE_NAME+"("+ VacancyRequirence.IDVACANCY_COLUMN+""
			+ ","+ VacancyRequirence.SKILL_COLUMN+") values(?,?)";
	public static final String SQL_DELETE = "delete from "+ VacancyRequirence.TABLE_NAME+" where "+ VacancyRequirence.IDVACANCY_COLUMN+"=?";
	
	public List<String> findById(long id);
	public void insert(VacancyRequirence vacancyrequirence);
	public void delete(long vacancy_id);
}
