package com.librarysystem.controller;

import com.librarysystem.entity.Publisher;
import com.librarysystem.service.PublisherService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/publisher")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublisherController {
    final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }


    @GetMapping("/list")
    public String listPublishers(Model theModel) {

        List<Publisher> thePublishers = publisherService.findAll();

        theModel.addAttribute("publishers", thePublishers);

        return "list-publishers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Publisher thePublisher = new Publisher();

        theModel.addAttribute("publishers", thePublisher);

        return "publisher-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("publisherId") int theID, Model theModel) {
        Publisher thePublisher = publisherService.findById(theID);
        theModel.addAttribute("publishers", thePublisher);
        return "publisher-form";
    }
    @PostMapping("/save")
    public String savePublisher(@ModelAttribute("publishers") Publisher thePublisher) {

        publisherService.save(thePublisher);

        return "redirect:/publisher/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("publisherId") int theId) {

        publisherService.deleteById(theId);

        return "redirect:/publisher/list";

    }
}
