package com.spring.gantt.GanttBubbleSort.link;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/link")
public class LinkController {
 
    @Autowired
    private LinkRepository linkRepository;

    @PostMapping(path="/addLink")
    public @ResponseBody String addLink(@RequestParam int id,
                                        @RequestParam String source,
                                        @RequestParam String target,
                                        @RequestParam String type) {

      Link link = new Link(id,source,target,type);
      
      linkRepository.save(link);
      return "Saved";
    }

    @GetMapping(path="/getProjetos")
    public @ResponseBody ArrayList<Link> getAllLinks() {
        return linkRepository.findAll();
    }

}