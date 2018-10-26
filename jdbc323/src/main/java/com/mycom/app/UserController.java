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

import com.mycom.entity.User;
import com.mycom.jdbc.JdbcUserDao;

@Controller
public class UserController {
	
	@Autowired
	private JdbcUserDao jdbcuserdao;
	
	private static List<User> list;
	
	private String CreateViewForm(Model model) {
		//List<User> list = jdbcuserdao.findAll();
		model.addAttribute("list",list);
		return "UserView";
	}
	
	private String CreateUserForm(Model model, User user) {
		Map< String, String > role = new HashMap<String, String>();
		role.put("manager", "manager");
		role.put("developer", "developer");
		model.addAttribute("user",user);
		model.addAttribute("map",role);
		
		return "UserForm";
	}
	
	@RequestMapping(value="/ViewUserForm",method = RequestMethod.GET)
	public String ViewUserForm(Model model) {
		list = jdbcuserdao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/UserCreate",method = RequestMethod.GET)
	public String CreateUser(Model model) {
		return CreateUserForm(model, new User());
	}
	
	@RequestMapping(value = "/SaveUser", method = RequestMethod.POST)
	public String SaveUser(@Valid User user,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return CreateUserForm(model,user);
		}
		if (user.getId()!=null)
			jdbcuserdao.update(user);
		else 
			jdbcuserdao.insert(user);
		list = jdbcuserdao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/UserEdit", method = RequestMethod.GET)
	public String UserEdit(Model model, HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		return CreateUserForm(model,jdbcuserdao.FindById(id));
	}
	
	@RequestMapping(value = "/UserDelete", method = RequestMethod.GET)
	public String UserDelete(Model model, HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		jdbcuserdao.delete(id);
		list = jdbcuserdao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/UserFilter", method = RequestMethod.GET)
	public String FilterUser(Model model, HttpServletRequest request) {
		String type = request.getParameter("type");
		list = jdbcuserdao.findByRole(type);
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/UserSortName", method = RequestMethod.GET)
	public String UserSortName(Model model, HttpServletRequest request) {
		list = jdbcuserdao.findAllSortName();
		return CreateViewForm(model);
	}
	
}
