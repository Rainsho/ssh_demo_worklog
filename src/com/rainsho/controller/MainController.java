package com.rainsho.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rainsho.entity.LogWithBLOBs;
import com.rainsho.entity.User;
import com.rainsho.service.MainService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private MainService service;

	public MainService getService() {
		return service;
	}

	public void setService(MainService service) {
		this.service = service;
	}

	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute User user, HttpServletRequest req) {
		ModelAndView view = new ModelAndView();
		if (service.checkUser(user)) {
			user = service.findUser(user);
			req.getSession().setAttribute("LOGIN_USER", user);
			List<LogWithBLOBs> logs = service.findByAdmin(user);
			req.setAttribute("logs", logs);
			view.setViewName("/logs.jsp");
			return view;
		} else {
			req.setAttribute("errormsg", "账号或密码错误");
			view.setViewName("/index.jsp");
			return view;
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute("LOGIN_USER");
		return "redirect:index.jsp";
	}

	public void findLogs(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("LOGIN_USER");
		List<LogWithBLOBs> logs = service.findByAdmin(user);
		req.setAttribute("logs", logs);
	}

	@RequestMapping("/addlog")
	public String addLog(@ModelAttribute LogWithBLOBs log,
			HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("LOGIN_USER");
		log.setUser(user);
		log.setCreatetime(new Date());
		log.setLid(null);
		service.addLog(log);
		findLogs(req);
		return "/logs.jsp";
	}

	@RequestMapping("/findlog")
	public String findLogById(@RequestParam("id") int id, HttpServletRequest req) {
		LogWithBLOBs log = service.findById(id);
		req.setAttribute("log_show", log);
		findLogs(req);
		return "/logs.jsp";
	}

	@RequestMapping("/updatelog")
	public String updateLog(@ModelAttribute LogWithBLOBs log,
			HttpServletRequest req) {
		LogWithBLOBs newlog = service.findById(log.getLid());
		newlog.setTxt1(log.getTxt1());
		newlog.setTxt2(log.getTxt2());
		newlog.setTxt3(log.getTxt3());
		service.updateLog(newlog);
		findLogs(req);
		return "/logs.jsp";
	}

	@RequestMapping("/json")
	public @ResponseBody
	List<LogWithBLOBs> jsonTest(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("LOGIN_USER");
		return service.findByAdmin(user);
	}

}