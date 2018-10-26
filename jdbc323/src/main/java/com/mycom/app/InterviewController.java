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

import com.mycom.jdbc.JdbcCandidateDao;
import com.mycom.jdbc.JdbcInterviewDao;
import com.mycom.jdbc.JdbcVacancyDao;
import com.mycom.entity.Candidate;
import com.mycom.entity.Interview;
import com.mycom.entity.Vacancy;

@Controller
public class InterviewController {

    @Autowired
    private JdbcInterviewDao jdbcinterviewdao;

    @Autowired
    private JdbcCandidateDao jdbccandidatedao;

    @Autowired
    private JdbcVacancyDao jdbcvacancydao;

    private List<Interview> list;

    private String CreateViewForm(Model model) {
        model.addAttribute("list",list);
        return "InterviewView";
    }

    private String CreateInterviewForm(Model model, Interview interview) {
        Map<Long,String> candidates = new HashMap<Long,String>();
        for (Candidate i:jdbccandidatedao.findAll()) {
            candidates.put(i.getId(), i.getName()+" "+i.getSurname());
        }
        Map<Long,String> vacancys = new HashMap<Long,String>();
        for (Vacancy i:jdbcvacancydao.findAll()) {
            vacancys.put(i.getId(), i.getPosition());
        }
        model.addAttribute("candidates",candidates);
        model.addAttribute("vacancys",vacancys);
        model.addAttribute("interview",interview);
        return "InterviewForm";
    }

    @RequestMapping(value="/InterviewView", method = RequestMethod.GET)
    public String InterviewView(Model model) {
        list = jdbcinterviewdao.findAll();
        return CreateViewForm(model);
    }

    @RequestMapping(value="/InterviewCreate",method = RequestMethod.GET)
    public String CreateInterview(Model model) {
        return CreateInterviewForm(model,new Interview());
    }

    @RequestMapping(value = "/SaveInterview", method = RequestMethod.POST)
    public String SaveInterview(@Valid Interview interview, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return CreateInterviewForm(model,interview);
        }
        if (interview.getId()!=null)
            jdbcinterviewdao.update(interview);
        else
            jdbcinterviewdao.insert(interview);
        list = jdbcinterviewdao.findAll();
        return CreateViewForm(model);
    }

    @RequestMapping(value = "/InterviewEdit", method = RequestMethod.GET)
    public String InterviewEdit(Model model,HttpServletRequest request) {
        long id = Integer.parseInt(request.getParameter("id"));
        return CreateInterviewForm(model,jdbcinterviewdao.FindById(id));
    }

    @RequestMapping(value = "/InterviewDelete", method = RequestMethod.GET)
    public String InterviewDelete(Model model,HttpServletRequest request) {
        long id = Integer.parseInt(request.getParameter("id"));
        jdbcinterviewdao.delete(id);
        list = jdbcinterviewdao.findAll();
        return CreateViewForm(model);
    }

    @RequestMapping(value ="/SortPlanDate", method = RequestMethod.GET)
    public String SortPlanDate(Model model) {
        list = jdbcinterviewdao.SortByDatePlan();
        return CreateViewForm(model);
    }

    @RequestMapping(value ="/SortFactDate", method = RequestMethod.GET)
    public String SortFactDate(Model model) {
        list = jdbcinterviewdao.SortByDateFact();
        return CreateViewForm(model);
    }

}
