package com.example;

import java.time.LocalDateTime;
import java.util.List;

import com.example.domain.Book;
import com.example.domain.BookRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = Replace.NONE) // NONE:실제 DB를 사용, ANY: H2 사용(in-memory DB)
public class BookJpaTest{
    private final static String BOOT_TEST_TITLE = "🦅";

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void Book_저장하기_테스트(){
        Book book = 
            Book.builder().title(BOOT_TEST_TITLE)
                .publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book);
        assertThat(bookRepository.getOne(book.getId()), is(book));
    }

    @Test
    public void BookList_저장하고_검색_테스트(){
        Book book1 = 
            Book.builder().title(BOOT_TEST_TITLE)
                .publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);

        Book book2 = 
            Book.builder().title(BOOT_TEST_TITLE)
                .publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);
        
        Book book3 = 
            Book.builder().title(BOOT_TEST_TITLE)
                .publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book3);

        List<Book> books = bookRepository.findAll();
        assertThat(books, hasSize(3));
        assertThat(books, contains(book1, book2, book3));
    }
}