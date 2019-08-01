package com.example.service;

import com.example.domain.Book;
import com.example.domain.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService{
    @Autowired
    BookRepository bookRepository;
    
    public List<Book> getBookList(){
        return bookRepository.findAll();
    }
    
    public Optional<Book> getOnebookByUserId(Integer userId) {
        return bookRepository.findById(userId);
    }

	public void createBook(Book book) {
		bookRepository.save(book);
	};
}