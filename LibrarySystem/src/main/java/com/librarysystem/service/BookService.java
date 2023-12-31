package com.librarysystem.service;

import com.librarysystem.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int theId);

    void save(Book theBook);

    void deleteById(int theId);

    List<Book> findBookByName(String keyword);
}
