package com.mycom.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.entity.Skill;
import com.mycom.jdbc.JdbcSkillDao;

@Controller
public class SkillController {

	@Autowired
	private JdbcSkillDao jdbcskilldao;

	private List<Skill> list;

	private String CreateViewForm(Model model) {
		list = jdbcskilldao.findAll();
		model.addAttribute("list",list);
		return "SkillView";
	}

	private String CreateSkillForm(Model model,Skill skill) {
		model.addAttribute("skill",skill);
		return "SkillForm";
	}

	@RequestMapping(value="/ViewSkillForm", method = RequestMethod.GET)
	public String ViewSkillForm(Model model) {
		list = jdbcskilldao.findAll();
		return CreateViewForm(model);
	}

	@RequestMapping(value="/SkillCreate", method = RequestMethod.GET)
	public String CreateSkill(Model model) {
		return CreateSkillForm(model,new Skill());
	}

	@RequestMapping(value = "/SaveSkill", method = RequestMethod.POST)
	public String SaveSkill(@Valid Skill skill, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return CreateSkillForm(model,skill);
		}
		jdbcskilldao.insert(skill);
		return CreateViewForm(model);
	}

	@RequestMapping(value = "/SkillDelete", method = RequestMethod.GET)
	public String SkillDelete(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		jdbcskilldao.delete(name);
		list = jdbcskilldao.findAll();
		return CreateViewForm(model);
	}

	@RequestMapping(value = "/SkillSort", method = RequestMethod.GET)
	public String SkillSort(Model model) {
		list = jdbcskilldao.sortSkill();
		return CreateViewForm(model);
	}
}
