package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.domain.Section;
import edu.mum.mumsched.service.BlockService;
import edu.mum.mumsched.service.CourseService;
import edu.mum.mumsched.service.SectionService;
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
public class SectionController {

    @Autowired
    SectionService sectionService;

    @Autowired
    CourseService courseService;

    @Autowired
    BlockService blockService;

    @RequestMapping(value = "/admin/sectionList", method = RequestMethod.GET)
    public String getSectionListForm(@ModelAttribute("newSection") Section section, Model model){
        model.addAttribute("sectionList",sectionService.getAllSection());
        return "Admin/sectionList";
    }

    @RequestMapping(value = "/admin/showAddSectionForm", method = RequestMethod.GET)
    public String getAddSectionForm(Model model){
       // model.addAttribute("entryList",entryService.getAllEntries());
        //  List<String> blocks = new ArrayList<>();
        //for(Block block:blockService.getAllBlocks()){
        //    blocks.add(block.getBlockName().toString());
        //}
        //model.addAttribute("blockList", blocks);
         model.addAttribute("sectionList",sectionService.getAllSection());
         model.addAttribute("courseList",courseService.getAllCourses());
         model.addAttribute("blockList",blockService.getAllBlocks());

        return "Admin/addSection";
    }

    @RequestMapping(value = {"/admin/section/newSection"}, method = RequestMethod.POST)
    public String addSection(@ModelAttribute("newSection") @Validated Section section, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/addSection";

        } else {
            
            Course course  = courseService.getCourseByCourseCode(section.getSectionName());
            section.setCourse(course);
            Block block =  blockService.getBlockByblockName(section.getSecBlockName());
            section.setBlock(block);
            sectionService.save(section);
            block.addSection(sectionService.getSectionBySectionName(section.getSectionName()));

            model.addAttribute("sectionList",sectionService.getAllSection());



            return "Admin/SectionList";
        }
    }

    @RequestMapping(value = {"/admin/deleteSection/{id}"}, method = RequestMethod.GET)
    public String removeSection(@PathVariable(value = "id") long id) {
        sectionService.deleteSectionById(id);

        return "redirect:/admin/sectionList";
    }
}
