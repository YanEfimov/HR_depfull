package com.mycom.jdbc;

import com.mycom.dao.InterviewDao;
import com.mycom.entity.Candidate;
import com.mycom.entity.Interview;
import com.mycom.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("InterviewDao")
public class JdbcInterviewDao implements InterviewDao {

	private DataSource dataSource;
	
	@Autowired
	private JdbcVacancyDao jdbcvacancydao;
	
	@Autowired
	private JdbcCandidateDao jdbccandidatedao;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private Interview creater(ResultSet rs) throws SQLException {
		Interview interview = new Interview();
		interview.setId(rs.getLong(Interview.ID_COLUMN));
		interview.setPlanDate(rs.getDate(Interview.PLANDATE_COLUMN));
		interview.setFactDate(rs.getDate(Interview.FACTDATE_COLUMN));
		interview.setIdCandidate(rs.getLong(Interview.IDCANDIDATE_COLUMN));
		interview.setIdVacancy(rs.getLong(Interview.IDVACANCY_COLUMN));
		interview.setName(rs.getString(Interview.NAME_CLOUMN));
		Candidate candidate = jdbccandidatedao.findById(interview.getIdCandidate());
		Vacancy vacancy = jdbcvacancydao.findById(interview.getIdVacancy());
		interview.setVacancyname(vacancy.getPosition());
		interview.setCandidatename(candidate.getName()+" "+candidate.getSurname());
		return interview;
	}
	
	private List<Interview> getList(String sqlQuery){
		List<Interview> list=new ArrayList<Interview>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
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
	public List<Interview> findAll() {
		return getList(SQL_FINDALL);
	}

	@Override
	public List<Interview> SortByDateFact() {
		return getList(SQL_SORT_BY_DATEFACT);
	}

	@Override
	public List<Interview> SortByDatePlan() {
		return getList(SQL_SORT_BY_DATEPLAN);
	}

	@Override
	public List<Interview> FindByCandidate(long candidate_id) {
		List<Interview> list=new ArrayList<Interview>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FINDBYCANDIDATE);
			statement.setLong(1, candidate_id);
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
	public void insert(Interview interview) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
			statement.setDate(1,new Date(interview.getPlanDate().getTime()));
			statement.setDate(2,new Date(interview.getFactDate().getTime()));
			statement.setLong(3, interview.getIdCandidate());
			statement.setLong(4, interview.getIdVacancy());
			statement.setString(5, interview.getName());
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
	public void update(Interview interview) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
			statement.setDate(1,new Date(interview.getPlanDate().getTime()));
			statement.setDate(2,new Date(interview.getFactDate().getTime()));
			statement.setLong(3, interview.getIdCandidate());
			statement.setLong(4, interview.getIdVacancy());
			statement.setString(5,interview.getName());
			statement.setLong(6, interview.getId());
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
	public void delete(long interview_id) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
			statement.setLong(1, interview_id);
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
	public Interview FindById(long id) {
		Interview interview = new Interview();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FINDBYID);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				interview = creater(rs);
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
		return interview;
	}

}
