package com.mycom.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.entity.Skill;
import com.mycom.entity.User;
import com.mycom.entity.Vacancy;
import com.mycom.jdbc.JdbcSkillDao;
import com.mycom.jdbc.JdbcUserDao;
import com.mycom.jdbc.JdbcVacancyDao;

@Controller
public class VacancyController {
	
	@Autowired
	private JdbcVacancyDao jdbcvacancydao;
	
	@Autowired
	private JdbcSkillDao jdbcskilldao;
	
	@Autowired
	private JdbcUserDao jdbcuserdao;
	
	private static List<Vacancy> list;
	
	private String CreateViewForm(Model model) {
		model.addAttribute("list", list);
		Map<Long,String> developers = new HashMap<Long, String>();
		for (User i:jdbcuserdao.findByRole("developer")) {
			developers.put(i.getId(), i.getName()+" "+i.getSurname());
		}
		model.addAttribute("developers",developers);
		return "VacancyView";
	}
	
	private String CreateVacancyForm(Model model, Vacancy vacancy) {
		Map<Long,String> developers = new HashMap<Long, String>();
		for (User i:jdbcuserdao.findByRole("developer")) {
			developers.put(i.getId(), i.getName()+" "+i.getSurname());
		}
		Map<String,String> skills = new HashMap<String,String>();
		for (Skill i:jdbcskilldao.findAll()) {
			skills.put(i.getName(), i.getName());
		}
		model.addAttribute("skills",skills);
		model.addAttribute("vacancy",vacancy);
		model.addAttribute("developers",developers);
		return "VacancyForm";
	}
	
	@RequestMapping(value="/ViewVacancyForm", method=RequestMethod.GET)
	public String ViewVacanctFrom(Model model) {
		list = jdbcvacancydao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value="/VacancyCreate", method=RequestMethod.GET)
	public String CreateVacancy(Model model) {
		return CreateVacancyForm(model,new Vacancy());
	}
	
	@RequestMapping(value = "/SaveVacancy", method = RequestMethod.POST)
	public String SaveVacancy(@Valid Vacancy vacancy,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return CreateVacancyForm(model,vacancy);
		}
		if (vacancy.getId()!=null)
			jdbcvacancydao.update(vacancy);
		else
			jdbcvacancydao.insert(vacancy);
		list = jdbcvacancydao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/VacancyEdit", method = RequestMethod.GET)
	public String VacancyEdit(Model model,HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		return CreateVacancyForm(model,jdbcvacancydao.findById(id));
	}
	
	@RequestMapping(value = "/VacancyDelete", method = RequestMethod.GET)
	public String VacancyDelete(Model model,HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		jdbcvacancydao.delete(id);
		list = jdbcvacancydao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/SortSalaryTo", method = RequestMethod.GET)
	public String SortSalaryTo(Model model) {
		list = jdbcvacancydao.sortForSalaryTo();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/SortSalaryFrom", method = RequestMethod.GET)
	public String SortSalaryFrom(Model model) {
		list = jdbcvacancydao.sortForSalaryFrom();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/SortExperience", method = RequestMethod.GET)
	public String SortExperience(Model model) {
		list = jdbcvacancydao.sortForExperience();
		return CreateViewForm(model);
	}
	
}
