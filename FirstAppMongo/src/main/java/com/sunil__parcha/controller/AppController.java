package com.sunil__parcha.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunil__parcha.modal.User;
import com.sunil__parcha.service.UserService;


@Controller
@RequestMapping("/user")
public class AppController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView getHome(HttpServletRequest req,@RequestParam(required=false) String name, @RequestParam(required=false) String option) {	
		ModelAndView userModel=new ModelAndView("index");
		if(option==null || option.equals("normal")) {
			if(name==null) {
				List<User> userList=userService.getUserList();
				userModel.addObject("userList",userList);
			}else {
				List<User> userList= (List<User>) userService.findLikeUserName(name);
				userModel.addObject("userList",userList);
			}
		}else {
				List<User> userList=userService.AseAndDec(option);
				userModel.addObject("userList",userList);
			
		}
		
		return userModel;
		
		
		
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {	
		ModelAndView userModel=new ModelAndView("form");
		userModel.addObject("userForm", new User());
		return userModel;
		
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") String id) {
		ModelAndView userModel=new ModelAndView("form");
		userModel.addObject("userForm",userService.findByUserId(id));
		return userModel;
		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("userForm") User user) {
		if(user.getId().equals("")) {
			System.out.println("adding...");
			userService.add(user);
			
		}
		else {
			
			System.out.println("updating...");
			userService.update(user);

		}
		return "redirect:/user/home";
		
	}
	

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deletedata(@PathVariable("id") String id) {
		User user = userService.findByUserId(id);
		userService.delete(user);
		return "redirect:/user/home";
	}
	
	 
	
	
}
