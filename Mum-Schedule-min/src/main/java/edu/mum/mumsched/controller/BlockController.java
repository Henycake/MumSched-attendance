package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.service.BlockService;
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
public class BlockController {
    @Autowired
    BlockService blockService;
    @Autowired
    EntryService entryService;



  @GetMapping("/admin/block")
    public String getBlockForm(@ModelAttribute("newBlock") Block block, Model model) {
      model.addAttribute("blocks", blockService.getAllBlocks());
      return "Admin/BlockList";
    }

    @RequestMapping(value = {"/admin/block/newBlock"}, method = RequestMethod.POST)
    public String addBlock(@ModelAttribute("newBlock") @Validated Block block, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/AddBlock";

        } else {

            Entry entry = entryService.findEntryByName(block.getEntryName());
            block.setEntry(entry);
            blockService.save(block);

            model.addAttribute("blocks", blockService.getAllBlocks());

            return "Admin/BlockList";
        }

    }
    @RequestMapping(value = {"/CreateBlockList"}, method = RequestMethod.GET)
    public String createBlockForm(Model model) {
       //Block block = new Block();
        //model.addAttribute("block", block);
        model.addAttribute("entryList",entryService.getAllEntries());
        return "Admin/AddBlock";
    }
    @RequestMapping(value = {"/admin/deleteBlock/{id}"}, method = RequestMethod.GET)
    public String removeBlock(@PathVariable(value = "id") long id) {
        blockService.deleteBlockById(id);

        return "redirect:/admin/block";
    }

    }

