package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.domain.Schedule;
import edu.mum.mumsched.domain.ScheduleStatus;
import edu.mum.mumsched.service.BlockService;
import edu.mum.mumsched.service.EntryService;
import edu.mum.mumsched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    EntryService entryService;

    @Autowired
    BlockService blockService;

    @RequestMapping(value = "/admin/scheduleList", method = RequestMethod.GET)
    public String getBlockListForm(@ModelAttribute("newSchedule") Schedule schedule, Model model){
        model.addAttribute("scheduleList",scheduleService.getAllSchedules());
        return "Admin/scheduleList";
    }

    @RequestMapping(value = "/admin/ShowAddScheduleForm", method = RequestMethod.GET)
    public String getAddScheduleForm(Model model){
        model.addAttribute("entryList",entryService.getAllEntries() );
        model.addAttribute("blockList",blockService.getAllBlocks() );
        //  List<String> blocks = new ArrayList<>();
        //for(Block block:blockService.getAllBlocks()){
        //    blocks.add(block.getBlockName().toString());
        //}
        //model.addAttribute("blockList", blocks);


        return "Admin/addSchedule";
    }

    @RequestMapping(value = {"/admin/schedule/newSchedule"}, method = RequestMethod.POST)
    public String addSchedule(@ModelAttribute("newSchedule") @Validated Schedule sch, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/addSchedule";

        } else {

         ///   Entry entry= entryService.findEntryByName(block.getEntryName());
           // block.setEntry(entry);
           // blockService.save(block);

          String st  =sch.getStatus();
          sch.setScheduleStatus(ScheduleStatus.valueOf(st));


           // Entry entry = entryService.findEntryByName(sch.getEntryName());
                Block block   = blockService.getBlockByblockName(sch.getBlockName());

                 sch.addBlock(block);

                  scheduleService.save(sch);

            model.addAttribute("scheduleList",scheduleService.getAllSchedules());

            return "Admin/scheduleList";
        }
    }


    @RequestMapping(value = {"/admin/deleteSchedule/{id}"}, method = RequestMethod.GET)
    public String removeSchedule(@PathVariable(value = "id") long id) {
        scheduleService.deleteScheduleById(id);

        return "redirect:/admin/scheduleList";
    }


}
