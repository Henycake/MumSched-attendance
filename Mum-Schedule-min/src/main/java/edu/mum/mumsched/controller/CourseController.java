package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

@Autowired
    CourseService courseService;


    @GetMapping("/admin/course")
    public String getCourseForm(@ModelAttribute("newCourse") Course course, Model model) {
        model.addAttribute("courseList", courseService.getAllCourses());
        return "Admin/CourseList";
    }

    @RequestMapping(value = {"/admin/course/newCourse"}, method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("newCourse") @Validated Course course, BindingResult result, Model model) {

        if (result.hasErrors()) {
             System.out.println("error");
            return "Admin/AddCourse";

        } else {

           courseService.save(course);
            model.addAttribute("courseList", courseService.getAllCourses());

            return "Admin/CourseList";
        }

    }
    @RequestMapping(value = {"/CreateCourseList"}, method = RequestMethod.GET)
    public String createCourseForm(Model model) {
        //Block block = new Block();
        //model.addAttribute("block", block);
        model.addAttribute("courseList",courseService.getAllCourses());
        return "Admin/AddCourse";
    }

    @RequestMapping(value = {"/admin/deleteCourse/{id}"}, method = RequestMethod.GET)
    public String removeCourse(@PathVariable(value = "id") long id) {
        courseService.deleteCourseById(id);

        return "redirect:/admin/course";
    }


}
