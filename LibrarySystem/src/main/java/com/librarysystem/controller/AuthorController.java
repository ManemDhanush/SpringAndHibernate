package com.librarysystem.controller;

import com.librarysystem.entity.Author;
import com.librarysystem.service.AuthorService;
import com.librarysystem.service.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorController {

    public static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    final BookService bookService;
    final AuthorService authorService;

    public AuthorController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping("/list")
    public String listAuthors(Model theModel) {
        List<Author> theAuthors = authorService.findAll();
        theModel.addAttribute("authors", theAuthors);
        return "list-authors";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Author theAuthor = new Author();
        theModel.addAttribute("authors", theAuthor);
        return "author-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("authorId") int theID, Model theModel) {
        Author theAuthor = authorService.findById(theID);
        theModel.addAttribute("authors", theAuthor);
        return "author-form";
    }
    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("authors") Author theAuthor) {
        authorService.save(theAuthor);
        return "redirect:/author/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("authorId") int theId) {
        authorService.deleteById(theId);
        return "redirect:/author/list";
    }
}
