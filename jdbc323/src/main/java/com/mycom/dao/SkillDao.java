package com.mycom.dao;

import com.mycom.entity.Skill;

import java.util.List;

public interface SkillDao {
	public static final String SQL_FINDALL = "select * from "+ Skill.TABLE_NAME;
	public static final String SQL_SORTSKILL = "select * from "+ Skill.TABLE_NAME+" order by "+ Skill.NAME_COLUMN;
	public static final String SQL_INSERT = "insert into "+ Skill.TABLE_NAME+"("+ Skill.NAME_COLUMN+") values(?)";
	public static final String SQL_DELETE = "delete from "+ Skill.TABLE_NAME+" where "+ Skill.NAME_COLUMN+"=?";
	
	public List<Skill> findAll();
	public List<Skill> sortSkill();
	public void insert(Skill skill);
	public void delete(String name);
}
