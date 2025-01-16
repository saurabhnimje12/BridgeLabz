package com.example.service;

import com.example.dto.BookEntityToDto;
import com.example.dto.DtoToBookEntity;

import java.util.List;

public interface BookService {
    String addBook(DtoToBookEntity dtoToBookEntity);

    String deleteBook(Long bookId);

    List<BookEntityToDto> allBooks();

    BookEntityToDto getBook(Long bookId);

    String updateBook(Long bookId, DtoToBookEntity dtoToBookEntity);
}
