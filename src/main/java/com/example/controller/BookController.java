package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.domain.Book;
import com.example.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/lists")
    public List<Book> getBookList() {
        return bookService.getBookList();
    }

    @GetMapping("/{user_id}")
    public Optional<Book> getOnebookByUserId(@PathVariable Integer userId) {
        return bookService.getOnebookByUserId(userId);
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }
}