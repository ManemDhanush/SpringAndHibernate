package com.librarysystem.controller;

import com.librarysystem.entity.Book;
import com.librarysystem.service.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookController {
    final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String listBooks(Model theModel) {
        List<Book> theBooks = bookService.findAll();
        theModel.addAttribute("books", theBooks);
        return "list-books";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Book theBook = new Book();
        theModel.addAttribute("books", theBook);
        return "book-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theID, Model theModel) {
        Book theBook = bookService.findById(theID);
        theModel.addAttribute("books", theBook);
        return "book-form";
    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("books") Book theBook) {
        bookService.save(theBook);
        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {
        bookService.deleteById(theId);
        return "redirect:/books/list";
    }

    @GetMapping("/search")
    public String findBookByName(Model model, @Param("keyword") String keyword){
        model.addAttribute("books", bookService.findBookByName(keyword));
        return "list-books";
    }
}
