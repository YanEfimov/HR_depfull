package com.mycom.app;

import com.mycom.entity.FeedBack;
import com.mycom.entity.FeedBackState;
import com.mycom.entity.Interview;
import com.mycom.entity.User;
import com.mycom.jdbc.JdbcFeedBackDao;
import com.mycom.jdbc.JdbcFeedBackStateDao;
import com.mycom.jdbc.JdbcInterviewDao;
import com.mycom.jdbc.JdbcUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FeedbackController {

	@Autowired
	private JdbcFeedBackDao jdbcfeedbackdao;
	@Autowired
	private JdbcFeedBackStateDao jdbcfeedbackstatedao;
	@Autowired
	private JdbcInterviewDao jdbcinterviewdao;
	@Autowired
	private JdbcUserDao jdbcuserdao;

	private List<FeedBack> list;

	private String CreateViewForm(Model model) {
		model.addAttribute("list",list);
		return "FeedBackView";
	}

	private String CreateFeedBackForm(Model model, FeedBack feedback) {
		Map<String,String> feedbackstates = new HashMap<String,String>();
		for (FeedBackState i:jdbcfeedbackstatedao.FindAll()) {
			feedbackstates.put(i.getName(), i.getName());
		}
		Map<Long,String> interviews = new HashMap<Long,String>();
		for (Interview i:jdbcinterviewdao.findAll()) {
			interviews.put(i.getId(), i.getName());
		}
		Map<Long,String> developers = new HashMap<Long,String>();
		for (User i:jdbcuserdao.findByRole("developer")) {
			developers.put(i.getId(), i.getName()+" "+i.getSurname());
		}
		model.addAttribute("feedback",feedback);
		model.addAttribute("interviews",interviews);
		model.addAttribute("feedbackstates",feedbackstates);
		model.addAttribute("developers",developers);
		return "FeedBackForm";
	}

	@RequestMapping(value = "/ViewFeedbackForm", method = RequestMethod.GET)
	public String ViewFeedBackForm(Model model) {
		list = jdbcfeedbackdao.findAll();
		return CreateViewForm(model);
	}

	@RequestMapping(value="/FeedbackCreate", method = RequestMethod.GET)
	public String CreateFeedback(Model model) {
		return CreateFeedBackForm(model,new FeedBack());
	}

	@RequestMapping(value = "/SaveFeedback", method = RequestMethod.POST)
	public String SaveFeedBack(@Valid FeedBack feedback, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return CreateFeedBackForm(model,feedback);
		}
		if (feedback.getId()!=null)
			jdbcfeedbackdao.update(feedback);
		else
			jdbcfeedbackdao.insert(feedback);
		list = jdbcfeedbackdao.findAll();
		return CreateViewForm(model);
	}

	@RequestMapping(value = "/FeedBackEdit", method = RequestMethod.GET)
	public String InterviewEdit(Model model,HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		return CreateFeedBackForm(model,jdbcfeedbackdao.findById(id));
	}

	@RequestMapping(value = "/FeedBackDelete", method = RequestMethod.GET)
	public String InterviewDelete(Model model,HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		jdbcfeedbackdao.delete(id);
		list = jdbcfeedbackdao.findAll();
		return CreateViewForm(model);
	}
	
	@RequestMapping(value = "/FeedBackFilter", method = RequestMethod.GET)
	public String FilterFeedBack(Model model, HttpServletRequest request) {
		String type = request.getParameter("type");
		list = jdbcfeedbackdao.findByState(type);
		return CreateViewForm(model);
	}
}
