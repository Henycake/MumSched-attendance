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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/admin/courseList", method = RequestMethod.GET)
    public String getCourseListForm(@ModelAttribute("newCourse") Course course, Model model){
        model.addAttribute("courseList", courseService.getAllCourses());
        return "Admin/courseList";
    }

    @RequestMapping(value = "/admin/showAddCourseForm", method = RequestMethod.GET)
    public String getAddCourseForm(Model model){
        return "Admin/addCourse";
    }

    @RequestMapping(value = {"/admin/course/newCourse"}, method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("newCourse") @Validated Course course, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/addCourse";

        } else {

            courseService.save(course);
            model.addAttribute("courseList",courseService.getAllCourses());

            return "Admin/CourseList";
        }
    }

    @RequestMapping(value = {"/admin/deleteCourse/{id}"}, method = RequestMethod.GET)
    public String removeCourse(@PathVariable(value = "id") long id) {
        courseService.deleteCourseById(id);

        return "redirect:/admin/courseList";
    }

    @RequestMapping(value = {"/admin/updateCourse/{id}"}, method = RequestMethod.GET)
    public String getUpdateCourseForm(@PathVariable(value = "id") long id,Model model) {
       // model.addAttribute("entryList",entryService.getAllEntries());
        model.addAttribute("updateTheCourse",courseService.getCourseById(id));
            model.addAttribute("courseList",courseService.getAllCourses());
        return "Admin/updateCourse";
    }

    @RequestMapping(value = {"/admin/course/editCourse"}, method = RequestMethod.POST)
    public String updateCourse(@ModelAttribute("editCourse") @Validated Course course, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/updateCourse";

        } else {


            courseService.save(course);
            model.addAttribute(courseService.getAllCourses());


            return "Admin/CourseList";
        }
    }

}
