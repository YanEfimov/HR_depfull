package com.mycom.dao;

import com.mycom.entity.User;

import java.util.List;

public interface UserDao {
	public static final String SQL_FINDALL = "select * from "+ User.TABLE_NAME;
	public static final String SQL_FINDALLSORTNAME = "select * from "+ User.TABLE_NAME+" order by "+ User.NAME_COLUMN;
	public static final String SQL_FINDBYNAME = "select * from "+ User.TABLE_NAME+" where "+ User.NAME_COLUMN+"=?";
	public static final String SQL_FINDBYROLE = "select * from "+ User.TABLE_NAME+" where "+ User.ROLE_COLUMN+"=?";
	public static final String SQL_FINDBYID = "select * from "+ User.TABLE_NAME+" where "+ User.ID_COLUMN+"=?";
	public static final String SQL_INSERT = "insert into "+ User.TABLE_NAME+"("+ User.NAME_COLUMN+","+ User.SURNAME_COLUMN+","+ User.EMAIL_COLUMN+""
			+ ","+ User.PASSWORD_COLUMN+","+ User.ROLE_COLUMN+") values(?,?,?,?,?)";
	public static final String SQL_UPDATE = "update "+ User.TABLE_NAME+" set "+ User.NAME_COLUMN+"=?, "+ User.SURNAME_COLUMN+"=?, "+ User.EMAIL_COLUMN+""
			+ "=?, "+ User.PASSWORD_COLUMN+"=?, "+ User.ROLE_COLUMN+"=? where "+ User.ID_COLUMN+"=?";
	public static final String SQL_DELETE = "delete from "+ User.TABLE_NAME+" where "+ User.ID_COLUMN+"=?";
	
	public List<User> findAll();
	public List<User> findAllSortName();
	public List<User> findByName(String name);
	public List<User> findByRole(String role);
	public User FindById(long id);
	public void insert(User user);
	public void update(User user);
	public void delete(long user_id);
	
}
