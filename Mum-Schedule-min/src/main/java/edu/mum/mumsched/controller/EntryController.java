package edu.mum.mumsched.controller;

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

    @RequestMapping(value = {"/admin/entry"}, method = RequestMethod.GET)
    public String getEntryForm(@ModelAttribute("newEntry") Entry entry, Model model) {
        //public String getEntryForm( Model model) {
        //Entry entry1 = new Entry();
        //List<Entry> entries = new ArrayList<Entry>();
        //entries.addAll(entryService.getAllEntries());
        model.addAttribute("entryList", entryService.getAllEntries());
        //System.out.println(entries);
        //model.addAttribute("entries", entries);
        // model.addAttribute("newEntry", entry);
        // model.addAttribute("entry1",entry1);

        return "Admin/EntryList";
    }

    // @PostMapping Mapping("/admin/entry/newEntry")
    @RequestMapping(value = {"/admin/entry/newEntry"}, method = RequestMethod.POST)
    public String addEntry(@ModelAttribute("newEntry") @Validated Entry entry, BindingResult result, Model model) {
        if (result.hasErrors()) {
           System.out.println("error seriously");
            return "Admin/EntryList";
        } else {
              entry.setEntryName(entry.getEntryType().name()+entry.getStartDate().getYear());
            entryService.create(entry);
            model.addAttribute("entryList", entryService.getAllEntries());
          //  model.addAttribute(attributeName:"entryList",entryService.getAllEntries());
            return "Admin/EntryList";
        }
    }

    @RequestMapping(value = {"/CreateEntryList"}, method = RequestMethod.GET)
    public String createEntryForm(Model model) {
        Entry entry = new Entry();
        model.addAttribute("entry", entry);
        return "Admin/AddEntry";
    }

    @GetMapping("/deleteEntry/{id}")
    public String deletedId(@PathVariable(value = "id") long id, Model model) {

        entryService.deleteEntry(id);
        return "redirect:/admin/entry";
    }
}