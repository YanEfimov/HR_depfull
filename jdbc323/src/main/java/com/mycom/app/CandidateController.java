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

import com.mycom.entity.Candidate;
import com.mycom.entity.CandidateState;
import com.mycom.entity.Skill;
import com.mycom.jdbc.JdbcCandidateDao;
import com.mycom.jdbc.JdbcCandidateStateDao;
import com.mycom.jdbc.JdbcSkillDao;

@Controller
public class CandidateController {
	
	@Autowired
	private JdbcCandidateDao jdbccandidatedao;
	
	@Autowired
	private JdbcCandidateStateDao jdbccandidatestatedao;
	
	@Autowired
	private JdbcSkillDao jdbcskilldao;
	
	private List<Candidate> list;
	
	private String CreateViewForm(Model model) {
		model.addAttribute("list",list);
		return "CandidateView";
	}
	
	private String CreateCandidateForm(Model model, Candidate candidate) {
		Map<String,String> states = new HashMap<String,String>();
		for (CandidateState i:jdbccandidatestatedao.FindAll()) {
			states.put(i.getName(), i.getName());
		}
		Map<String,String> skills = new HashMap<String,String>();
		for (Skill i:jdbcskilldao.findAll()) {
			skills.put(i.getName(), i.getName());
		}
		model.addAttribute("skills",skills);
		model.addAttribute("candidate",candidate);
		model.addAttribute("candidatestate",states);
		return "CandidateForm";
	}
	
	@RequestMapping(value="/ViewCandidateForm", method = RequestMethod.GET)
	public String ViewCandidateForm(Model model) {
		list = jdbccandidatedao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value="/CandidateCreate",method = RequestMethod.GET)
	public String CreateCandidate(Model model) {
		return CreateCandidateForm(model,new Candidate());
	}
	
	@RequestMapping(value = "/SaveCandidate", method = RequestMethod.POST)
	public String SaveCandidate(@Valid Candidate candidate,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println(candidate.getBirthday());
			return CreateCandidateForm(model,candidate);
		}
		if (candidate.getId()!=null)
			jdbccandidatedao.update(candidate);
		else
			jdbccandidatedao.insert(candidate);
		list = jdbccandidatedao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "CandidateEdit", method = RequestMethod.GET)
	public String CandidateEdit(Model model, HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		return CreateCandidateForm(model,jdbccandidatedao.findById(id));
	}
	
	@RequestMapping(value = "CandidateDelete", method = RequestMethod.GET)
	public String CandidateDelete(Model model, HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		jdbccandidatedao.delete(id);
		list = jdbccandidatedao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/CandidateFilter", method = RequestMethod.GET)
	public String CandidateFilter(Model model, HttpServletRequest request) {
		String state = request.getParameter("type");
		list = jdbccandidatedao.findByState(state);
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/CandidateSortName", method = RequestMethod.GET)
	public String CandidateSortName(Model model) {
		list = jdbccandidatedao.sortNameCandidate();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/CandidateSortSalary", method = RequestMethod.GET)
	public String CandidateSortSalary(Model model) {
		list = jdbccandidatedao.sortSalaryCandidate();
		return CreateViewForm(model);
	}
	
	
}
