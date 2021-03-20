package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.BlockName;
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

    @RequestMapping(value = "/admin/blockList", method = RequestMethod.GET)
    public String getBlockListForm(@ModelAttribute("newBlock") Block block, Model model){
        model.addAttribute("blocks", blockService.getAllBlocks());
        return "Admin/blockList";
    }

    @RequestMapping(value = "/admin/ShowAddBlockForm", method = RequestMethod.GET)
    public String getAddBlockForm(Model model){
        model.addAttribute("entryList",entryService.getAllEntries());
       //  List<String> blocks = new ArrayList<>();
       //for(Block block:blockService.getAllBlocks()){
       //    blocks.add(block.getBlockName().toString());
       //}
         //model.addAttribute("blockList", blocks);


        return "Admin/addBlock";
    }

    @RequestMapping(value = {"/admin/block/newBlock"}, method = RequestMethod.POST)
    public String addBlock(@ModelAttribute("newBlock") @Validated Block block, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/addBlock";

        } else {

           Entry entry= entryService.findEntryByName(block.getEntryName());
              block.setEntry(entry);
            blockService.save(block);
                 entry.addBlock(blockService.getBlockByblockName(block.getBlockName()));

            model.addAttribute("blocks",blockService.getAllBlocks());

            return "Admin/blockList";
        }
    }

    @RequestMapping(value = {"/admin/deleteBlock/{id}"}, method = RequestMethod.GET)
    public String removeBlock(@PathVariable(value = "id") long id) {
        blockService.deleteBlockById(id);

        return "redirect:/admin/blockList";
    }

    @RequestMapping(value = {"/admin/updateBlock/{id}"}, method = RequestMethod.GET)
    public String getUpdateBlockForm(@PathVariable(value = "id") long id,Model model) {
        model.addAttribute("entryList",entryService.getAllEntries());

        return "Admin/updateBlock";
    }

    @RequestMapping(value = {"/admin/block/editBlock"}, method = RequestMethod.POST)
    public String updateBlock(@ModelAttribute("editBlock") @Validated Block block, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "Admin/updateBlock";

        } else {

            Entry entry= entryService.findEntryByName(block.getEntryName());
            block.setEntry(entry);
            blockService.save(block);

            model.addAttribute("blocks",blockService.getAllBlocks());

            return "Admin/blockList";
        }
    }


}
