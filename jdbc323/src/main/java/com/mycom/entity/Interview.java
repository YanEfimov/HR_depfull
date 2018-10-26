package com.mycom.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class Interview {
	public static final String TABLE_NAME = "interview";
	public static final String ID_COLUMN = "id";
	public static final String FACTDATE_COLUMN = "factDate";
	public static final String PLANDATE_COLUMN = "planDate";
	public static final String IDVACANCY_COLUMN = "idVacancy";
	public static final String IDCANDIDATE_COLUMN = "idCandidate";
	public static final String NAME_CLOUMN = "name";
	
	
	private Long id;
	@NotNull
	private Date factDate;
	@NotNull 
	private Date planDate;
	private long idVacancy;
	private long idCandidate;
	@Size(min=5)
	private String name;
	private String candidatename;
	private String vacancyname;
	
	
	public String getCandidatename() {
		return candidatename;
	}
	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}
	public String getVacancyname() {
		return vacancyname;
	}
	public void setVacancyname(String vacancyname) {
		this.vacancyname = vacancyname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getIdVacancy() {
		return idVacancy;
	}
	public void setIdVacancy(long idVacancy) {
		this.idVacancy = idVacancy;
	}
	public long getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(long idCandidate) {
		this.idCandidate = idCandidate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFactDate() {
		return factDate;
	}
	public void setFactDate(Date factDate) {
		this.factDate = factDate;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	
	
}
