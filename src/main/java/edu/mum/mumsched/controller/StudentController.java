package edu.mum.mumsched.controller;



import edu.mum.mumsched.domain.*;

import edu.mum.mumsched.service.AccountService;
import edu.mum.mumsched.service.EntryService;
import edu.mum.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    EntryService entryService;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/admin/studentList", method = RequestMethod.GET)
    public String getStudentListForm(@ModelAttribute("newStudent") Student student, Model model){
        model.addAttribute("studentList", studentService.getAllStudent());
        return "Admin/studentList";
    }



    @RequestMapping(value = "/admin/showAddStudentForm", method = RequestMethod.GET)
    public String getAddStudentForm(Model model){
        model.addAttribute("entryList",entryService.getAllEntries());
        return "Admin/addStudent";
    }


    @RequestMapping(value = {"/admin/student/newStudent"}, method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("newStudent") @Validated Student student, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/addStudent";

        } else {


            student.setStudentType(StudentType.valueOf( student.getStType()));

            student.setEntry( entryService.findEntryByName(student.getStEntry()));
            List<Section> list=new ArrayList<Section>();
                 List<Block>  blockList =entryService.findEntryByName(student.getStEntry()).getBlocks();
           for(Block block:blockList){
               List<Section> list1    = block.getSections();

               for(Section sec:list1){
                   list.add(sec);
               }

           }
            System.out.println(list);

           for(Section sec:list){
               student.addSection(sec);
           }

            studentService.save(student);

            model.addAttribute(studentService.getAllStudent());
            return "Admin/studentList";
        }
    }

    @RequestMapping(value = {"/admin/deleteStudent/{id}"}, method = RequestMethod.GET)
    public String removeStudent(@PathVariable(value = "id") long id) {

        studentService.deleteStudentById(id);

          return "redirect:/admin/studentList";
    }

    @RequestMapping(value = {"/admin/updateStudent/{id}"}, method = RequestMethod.GET)
    public String getUpdateStudentForm(@PathVariable(value = "id") long id,Model model) {
        model.addAttribute("entryList",entryService.getAllEntries());
        return "Admin/updateStudent";
    }



    @RequestMapping(value = {"/admin/student/editStudent"}, method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("editStudent") @Validated Student student, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/updateStudent";

        } else {


            studentService.save(student);
            model.addAttribute(studentService.getAllStudent());


            return "Admin/studentList";
        }


    }

    @RequestMapping(value = {"/student/viewSchedule/{id}"}, method = RequestMethod.GET)
    public String getViewScheduleForm(@PathVariable(value = "id") long id,Model model) {
     Account account  = accountService.getAccountById(id);
       Student student  =studentService.getStudentByEmail(account.getEmail());
        System.out.println(student);
        List<Section> list=new ArrayList<>();
     List<Block> listBlock   =entryService.findEntryByName(student.getStEntry()).getBlocks();
     if (listBlock!=null) {
         for (Block block : listBlock) {
             List<Section> list1 = block.getSections();

             for (Section sec : list1) {
                 list.add(sec);
             }

         }
     }

        model.addAttribute("st", student );
        model.addAttribute("sectionList",list);
        return "Student/viewSchedule";
    }

}
