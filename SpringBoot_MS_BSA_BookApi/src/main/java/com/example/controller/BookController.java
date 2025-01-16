package com.example.controller;

//import com.example.client.UserClient;
import com.example.client.UserClient;
import com.example.dto.BookEntityToDto;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserClient userClient;

    @GetMapping("/test")
    public String test() {
        return "Spring Boot - BOOK_API";
    }

    @GetMapping("/test_FeignClient")
    public String testFeignClient() {
        return userClient.testUserApi();
    }


    @GetMapping("/allBooks")
    public ResponseEntity<List<BookEntityToDto>> getAllBooks() {
        return new ResponseEntity<List<BookEntityToDto>>(bookService.allBooks(), HttpStatus.OK);
    }

    @GetMapping("/getBook/{bookId}")
    public ResponseEntity<BookEntityToDto> getBook(@PathVariable Long bookId) {
        return new ResponseEntity<BookEntityToDto>(bookService.getBook(bookId), HttpStatus.OK);
    }
}