package com.example.client;

import com.example.external.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOK-API")
public interface BookClient {
    @GetMapping("/book/getBook/{bookId}")
    Book getBookById(@PathVariable Long bookId);
}
