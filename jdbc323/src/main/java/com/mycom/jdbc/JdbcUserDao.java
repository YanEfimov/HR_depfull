package com.mycom.jdbc;

import com.mycom.dao.UserDao;
import com.mycom.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("UserDao")
public class JdbcUserDao implements UserDao {

	private DataSource dataSource;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<User> findAll() {
		List<User> list=new ArrayList<User>();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_FINDALL);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				User user=new User();
				user.setId(rs.getLong(User.ID_COLUMN));
				user.setEmail(rs.getString(User.EMAIL_COLUMN));
				user.setName(rs.getString(User.NAME_COLUMN));
				user.setSurname(rs.getString(User.SURNAME_COLUMN));
				user.setPassword(rs.getString(User.PASSWORD_COLUMN));
				user.setRole(rs.getString(User.ROLE_COLUMN));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void insert(User user) {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_INSERT);
			statement.setString(1,user.getName());
			statement.setString(2,user.getSurname());
			statement.setString(3,user.getEmail());
			statement.setString(4,user.getPassword());
			statement.setString(5,user.getRole());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void update(User user) {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_UPDATE);
			statement.setString(1,user.getName());
			statement.setString(2,user.getSurname());
			statement.setString(3,user.getEmail());
			statement.setString(4,user.getPassword());
			statement.setString(5,user.getRole());
			statement.setLong(6,user.getId());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(long user_id) {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_DELETE);
			statement.setLong(1, user_id);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<User> findAllSortName() {
		List<User> list=new ArrayList<User>();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_FINDALLSORTNAME);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				User user=new User();
				user.setId(rs.getLong(User.ID_COLUMN));
				user.setEmail(rs.getString(User.EMAIL_COLUMN));
				user.setName(rs.getString(User.NAME_COLUMN));
				user.setSurname(rs.getString(User.SURNAME_COLUMN));
				user.setPassword(rs.getString(User.PASSWORD_COLUMN));
				user.setRole(rs.getString(User.ROLE_COLUMN));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<User> findByName(String name) {
		List<User> list=new ArrayList<User>();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_FINDBYNAME);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				User user=new User();
				user.setId(rs.getLong(User.ID_COLUMN));
				user.setEmail(rs.getString(User.EMAIL_COLUMN));
				user.setName(rs.getString(User.NAME_COLUMN));
				user.setSurname(rs.getString(User.SURNAME_COLUMN));
				user.setPassword(rs.getString(User.PASSWORD_COLUMN));
				user.setRole(rs.getString(User.ROLE_COLUMN));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<User> findByRole(String role) {
		List<User> list=new ArrayList<User>();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_FINDBYROLE);
			statement.setString(1, role);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				User user=new User();
				user.setId(rs.getLong(User.ID_COLUMN));
				user.setEmail(rs.getString(User.EMAIL_COLUMN));
				user.setName(rs.getString(User.NAME_COLUMN));
				user.setSurname(rs.getString(User.SURNAME_COLUMN));
				user.setPassword(rs.getString(User.PASSWORD_COLUMN));
				user.setRole(rs.getString(User.ROLE_COLUMN));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public User FindById(long id) {
		User user = new User();
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement statement=connection.prepareStatement(SQL_FINDBYID);
			statement.setLong(1, id);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				user.setId(rs.getLong(User.ID_COLUMN));
				user.setEmail(rs.getString(User.EMAIL_COLUMN));
				user.setName(rs.getString(User.NAME_COLUMN));
				user.setSurname(rs.getString(User.SURNAME_COLUMN));
				user.setPassword(rs.getString(User.PASSWORD_COLUMN));
				user.setRole(rs.getString(User.ROLE_COLUMN));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

}
