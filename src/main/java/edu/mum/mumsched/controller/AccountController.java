package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Account;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/miu/accountForm")
    String signUp() {
        return "Auth/miu-signUpForm";
    }






    @RequestMapping(value = {"/miu/newAccount"}, method = RequestMethod.POST)
    public String createAccount(@ModelAttribute("newAccount") @Validated Account account, BindingResult result, Model model) {
        for(Account ac:accountService.getAllAccount()){
            if(ac.getEmail().equals(account.getEmail())){
                model.addAttribute("message","Sorry! You have already registered with this email! Use other email! ");
                return"Auth/miu-signUpForm";
            }
        }
          if(account.getEmail()==null || account.getPassword()==null ||account.getEmail().length()==0||account.getPassword().length()==0){
              model.addAttribute("message","Sorry! Account email or password cannot be empty! Try again! ");
              return "Auth/miu-signUpForm";
          }


      else if  (result.hasErrors()) {
            model.addAttribute("message","Sorry! Account email or password cannot be empty! Try again! ");
            return "Auth/miu-signUpForm";

        } else {
                 /* if (account.getRoleType().equals(Role.ADMIN.toString())){
                      account.setRole(Role.ADMIN);
                  }
                  else if (account.getRoleType().equals(Role.FACULTY)){
                      account.setRole(Role.FACULTY);
                  }
                  else{
                      account.setRole(Role.STUDENT);
                  }*/

            accountService.save(account);
            System.out.println(account);
            //model.addAttribute("acc",accountService.getAccountByEmail(account.getEmail()));
            model.addAttribute("message","You have created Your Account successfully! Your account Id is:"+account.getId());

            return "Auth/miu-signUpForm";
        }
    }

}
