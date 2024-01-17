package com.example.kimhaspringsoap;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Book getBook(String title) {
        // Simulate fetching book details from a database
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor("John Doe");
        book.setYear(2020);
        return book;
    }
}
