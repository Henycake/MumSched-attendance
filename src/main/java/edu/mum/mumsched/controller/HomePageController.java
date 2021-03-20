package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.domain.Role;
import edu.mum.mumsched.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import edu.mum.mumsched.domain.Account;

@Controller
public class HomePageController {

	         @Autowired
             AccountService accountService;


	@RequestMapping(value = {"/miu/adminPage"}, method = RequestMethod.GET)
	public String getAdminForm(@ModelAttribute("newEntry") Entry entry, Model model) {
		return "Admin/AdminPage";
	}

	  @GetMapping("/miu")
	    String login() {
	        return "Auth/miu-homeLogin";
	    }


	  

	  @RequestMapping(value = {"/miu/login"}, method = RequestMethod.POST)
	    public String loginn(@ModelAttribute("account") Account account,Model model) {
		Account ac  =accountService.getAccountByEmail(account.getEmail());

		if (ac!=null  && ac.getPassword().equals(account.getPassword())){
			if(ac.getRoleType().equals(Role.ADMIN.toString())  ) {
				model.addAttribute("acc",ac);
				return "Admin/AdminPage";
			}
			else if(ac.getRoleType().equals(Role.STUDENT.toString())   ) {
				model.addAttribute("acc",ac);
				return "Student/studentPage";
			}
			else if(ac.getRoleType().equals(Role.FACULTY.toString())   ) {
				model.addAttribute("acc",ac);
				return "Faculty/facultyPage";
			}
		}

        else

        	model.addAttribute("message","Sorry! Your email and password does not much! ");
			return"Auth/miu-homeLogin";




		 // return "redirect:/miu";
	    }





}
