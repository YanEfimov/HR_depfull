package com.mycom.jdbc;

import com.mycom.dao.FeedBackDao;
import com.mycom.entity.FeedBack;
import com.mycom.entity.Interview;
import com.mycom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("FeedBackDao")
public class JdbcFeedBackDao implements FeedBackDao {
	
	private DataSource dataSource;
	
	@Autowired
	private JdbcInterviewDao jdbcinterviewdao;
	@Autowired
	private JdbcUserDao jdbcuserdao;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private FeedBack creater(ResultSet rs) throws SQLException {
		FeedBack feedback = new FeedBack();
		feedback.setId(rs.getLong(FeedBack.ID_COLUMN));
		feedback.setIdInterview(rs.getLong(FeedBack.IDINTERVIEW_COLUMN));
		feedback.setIdInterviewer(rs.getLong(FeedBack.IDINTERVIEWER_COLUMN));
		feedback.setFeedbackState(rs.getString(FeedBack.FEEDBACKSTATE_COLUMN));
		feedback.setReason(rs.getString(FeedBack.REASON_COLUMN));
		Interview interview = jdbcinterviewdao.FindById(feedback.getIdInterview());
		User user = jdbcuserdao.FindById(feedback.getIdInterviewer());
		feedback.setInterviewname(interview.getName());
		feedback.setInterviewername(user.getName()+" "+user.getSurname());
		return feedback;
	}
	
	@Override
	public List<FeedBack> findAll() {
		List<FeedBack> list = new ArrayList<FeedBack>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FINDALL);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(creater(rs));
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
	public List<FeedBack> findByInterviewer(long interviewer_id) {
		List<FeedBack> list = new ArrayList<FeedBack>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FINDBYINTERVIEWER);
			statement.setLong(1, interviewer_id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(creater(rs));
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
	public List<FeedBack> findByState(String feedbackState) {
		List<FeedBack> list = new ArrayList<FeedBack>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FINDBYSTATE);
			statement.setString(1, feedbackState);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(creater(rs));
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
	public void insert(FeedBack feedback) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
			statement.setLong(1, feedback.getIdInterview());
			statement.setLong(2, feedback.getIdInterviewer());
			statement.setString(3, feedback.getFeedbackState());
			statement.setString(4, feedback.getReason());
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
	public void update(FeedBack feedback) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
			statement.setLong(1, feedback.getIdInterview());
			statement.setLong(2, feedback.getIdInterviewer());
			statement.setString(3, feedback.getFeedbackState());
			statement.setString(4, feedback.getReason());
			statement.setLong(5, feedback.getId());
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
	public void delete(long feedback_id) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
			statement.setLong(1, feedback_id);
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
	public FeedBack findById(long id) {
		FeedBack feedback = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FINDBYID);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				feedback = creater(rs);
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
		return feedback;
	}
}
