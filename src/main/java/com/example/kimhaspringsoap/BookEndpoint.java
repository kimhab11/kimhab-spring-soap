package com.example.kimhaspringsoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/books";

    @Autowired
    private BookService bookService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBookRequest")
    @ResponsePayload
    public Book getBook(@RequestPayload Book request) {
        Book response = new Book();
        Book book = bookService.getBook(request.getTitle());
        Book bookType = new Book();
        bookType.setTitle(book.getTitle());
        bookType.setAuthor(book.getAuthor());
        bookType.setYear(book.getYear());
        response = bookType;
        return response;
    }
}
