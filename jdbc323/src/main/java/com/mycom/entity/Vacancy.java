package com.mycom.entity;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Vacancy {
	public static final String TABLE_NAME = "vacancy";
	public static final String ID_COLUMN = "id";
	public static final String SALARYTO_COLUMN = "salaryto";
	public static final String SALARYFROM_COLUMN = "salaryfrom";
	public static final String EXPERIENCEYEARREQUIRE_COLUMN = "experienceYearRequire";
	public static final String POSITION_COLUMN = "position";
	public static final String IDDEVELOPER = "idDeveloper";
	
	private Long id;
	@DecimalMax("10000.0") @DecimalMin("200") 
	private double salaryto;
	@DecimalMax("10000.0") @DecimalMin("200") 
	private double salaryfrom;
	@DecimalMax("30.0") @DecimalMin("0.0") 
	private double experienceYearRequire;
	@Size(min=5)
	private String position;
	private long idDeveloper;
	@NotNull
	private List<String> skills;
	private String developername;
	
	
	
	public String getDevelopername() {
		return developername;
	}
	public void setDevelopername(String developername) {
		this.developername = developername;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public long getIdDeveloper() {
		return idDeveloper;
	}
	public void setIdDeveloper(long idDeveloper) {
		this.idDeveloper = idDeveloper;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getSalaryto() {
		return salaryto;
	}
	public void setSalaryto(double salaryto) {
		this.salaryto = salaryto;
	}
	public double getSalaryfrom() {
		return salaryfrom;
	}
	public void setSalaryfrom(double salaryfrom) {
		this.salaryfrom = salaryfrom;
	}
	public double getExperienceYearRequire() {
		return experienceYearRequire;
	}
	public void setExperienceYearRequire(double experienceYearRequire) {
		this.experienceYearRequire = experienceYearRequire;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
