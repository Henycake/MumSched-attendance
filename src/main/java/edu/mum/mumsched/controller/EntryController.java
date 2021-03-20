package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EntryController {
    @Autowired
    EntryService entryService;

    @RequestMapping(value = {"/admin/entryList"}, method = RequestMethod.GET)
    public String getEntryListForm(@ModelAttribute("newEntry") Entry entry, Model model) {
        model.addAttribute(entryService.getAllEntries());
        return "Admin/entryList";
    }
    @RequestMapping(value = {"/admin/ShowAddEntryForm"}, method = RequestMethod.GET)
    public String getAddEntryForm(@ModelAttribute("newEntry") Entry entry, Model model) {

        return "Admin/addEntry";
    }


    @RequestMapping(value = {"/admin/entry/newEntry"}, method = RequestMethod.POST)
    public String addEntry(@ModelAttribute("newEntry") @Validated Entry entry, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "Admin/addEntry";

        } else {
            entry.setEntryName(entry.getEntryType().name()+entry.getStartDate().getYear());
            entryService.CreateEntry(entry);
            model.addAttribute("entryList",entryService.getAllEntries());
           return "Admin/entryList";
        }
    }

    @RequestMapping(value = {"/admin/deleteEntry/{id}"}, method = RequestMethod.GET)
    public String removeEntry(@PathVariable (value = "id") long id) {
                entryService.deleteEntry(id);
        return "redirect:/admin/entryList";
    }

    @RequestMapping(value = {"/admin/updateEntry/{id}"}, method = RequestMethod.GET)
    public String getUpdateCourseForm(@PathVariable(value = "id") long id,Model model) {
        // model.addAttribute("entryList",entryService.getAllEntries());
       // model.addAttribute("updateTheCourse",courseService.getCourseById(id));
      //  model.addAttribute("courseList",courseService.getAllCourses());
        return "Admin/updateEntry";
    }

    @RequestMapping(value = {"/admin/entry/editEntry"}, method = RequestMethod.POST)
    public String updateEntry(@ModelAttribute("editEntry") @Validated Entry entry, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/updateCourse";

        } else {

            entryService.CreateEntry(entry);
           model.addAttribute(entryService.getAllEntries());



            return "Admin/entryList";
        }
    }



}
