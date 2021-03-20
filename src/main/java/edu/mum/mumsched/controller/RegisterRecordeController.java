package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Account;
import edu.mum.mumsched.domain.Section;
import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.service.AccountService;
import edu.mum.mumsched.service.SectionService;
import edu.mum.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterRecordeController {

    @Autowired
    AccountService accountService;

    @Autowired
    StudentService studentService;

    @Autowired
    SectionService sectionService;

    @RequestMapping(value = {"/student/registerCourse/{id}"}, method = RequestMethod.GET)
    public String getUpdateBlockForm(@PathVariable(value = "id") long id, Model model) {

        System.out.println(sectionService.getSectionById(id));

        model.addAttribute("message","You have registered succesfully!");

        return "Student/viewSchedule";
    }





}
