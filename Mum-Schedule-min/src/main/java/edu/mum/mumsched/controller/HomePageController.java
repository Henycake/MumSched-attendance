package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Entry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import edu.mum.mumsched.domain.Account;

@Controller
public class HomePageController {
	
	  @GetMapping("/miu")
	    String login() {
	        return "Auth/miu-homeLogin";
	    }

	@RequestMapping(value = {"/miu/adminPage"}, method = RequestMethod.GET)
	public String getAdminForm(@ModelAttribute("newEntry") Entry entry, Model model) {
		return "Admin/AdminPage";
	}

	  
	  @PostMapping("/miu/login")
	    public String loginn(@ModelAttribute("account") Account account) {
		  
		    if(account.getEmail().equals("admin@gmail.com") && account.getPassword().equals("admin")  ) {
		    	return "Admin/AdminPage";
		    }
		    else if(account.getEmail().equals("student@gmail.com") && account.getPassword().equals("student")) {
		    	return "Student/StudentPage";
		    }
		    else 
		  	return "redirect:/miu";
	    }

}
