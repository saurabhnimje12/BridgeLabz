package com.example.controller;

import com.example.dto.DtoToBookEntity;
import com.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookApi")
public class BookJwtController {
    private BookService bookService;

    public BookJwtController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestAttribute("role") String role, @RequestBody DtoToBookEntity dtoToBookEntity) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(bookService.addBook(dtoToBookEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Add Book", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity<String> addBook(@RequestAttribute("role") String role, @PathVariable Long bookId) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(bookService.deleteBook(bookId), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Delete Book", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateBook/{bookId}")
    public ResponseEntity<String> updateBook(@RequestAttribute("role") String role, @PathVariable Long bookId, @RequestBody DtoToBookEntity dtoToBookEntity) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(bookService.updateBook(bookId, dtoToBookEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Token is NOT Valid to Update Book", HttpStatus.NOT_FOUND);
        }
    }
}
