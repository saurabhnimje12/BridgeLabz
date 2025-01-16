package com.example.serviceImpl;

import com.example.dto.BookEntityToDto;
import com.example.dto.DtoToBookEntity;
import com.example.entity.Book;
import com.example.exception.CustomiseException;
import com.example.repo.BookRepo;
import com.example.service.BookService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @CircuitBreaker(name = "bookCircuitBreaker",fallbackMethod = "addBookFallback")
    @Override
    public String addBook(DtoToBookEntity dtoToBookEntity) {
        Book book = dtoToBookConverter(dtoToBookEntity);
        bookRepo.save(book);
        return "Book Added Successfully";
    }

    public String addBookFallback(Exception exception){
        return "Please Try After Some Time!!";
    }

    @Override
    public String deleteBook(Long bookId) {
        bookRepo.deleteById(bookId);
        return "Book Deleted Successfully";
    }

    @Override
    public List<BookEntityToDto> allBooks() {
        List<Book> list = bookRepo.findAll();
        return list.stream().map(this::bookToDtoConverter).collect(Collectors.toList());
    }

    @Override
    public BookEntityToDto getBook(Long bookId) {
        return bookToDtoConverter(bookRepo.findById(bookId).orElseThrow(() -> new CustomiseException("Invalid Book Id!!")));
    }

    @Override
    public String updateBook(Long bookId, DtoToBookEntity dtoToBookEntity) {
        Optional<Book> optionalBook = bookRepo.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            Book bookConverter = dtoToBookConverter(dtoToBookEntity);
            book.setBookPrice(bookConverter.getBookPrice());
            book.setBookQuantity(bookConverter.getBookQuantity());
            bookRepo.save(book);
            return "Book Updated Successfully";
        } else {
            return "Invalid Book Id!!";
        }
    }

    private Book dtoToBookConverter(DtoToBookEntity dtoToBookEntity) {
        Book book = new Book();
        book.setBookName(dtoToBookEntity.getBookName());
        book.setBookAuthor(dtoToBookEntity.getBookAuthor());
        book.setBookDescription(dtoToBookEntity.getBookDescription());
        book.setBookLogoMultipart(dtoToBookEntity.getBookLogoMultipart());
        book.setBookPrice(dtoToBookEntity.getBookPrice());
        book.setBookQuantity(dtoToBookEntity.getBookQuantity());
        return book;
    }

    private BookEntityToDto bookToDtoConverter(Book book) {
        BookEntityToDto bookEntityToDto = new BookEntityToDto();
        bookEntityToDto.setBookId(book.getBookId());
        bookEntityToDto.setBookName(book.getBookName());
        bookEntityToDto.setBookAuthor(book.getBookAuthor());
        bookEntityToDto.setBookDescription(book.getBookDescription());
        bookEntityToDto.setBookLogoMultipart(book.getBookLogoMultipart());
        bookEntityToDto.setBookPrice(book.getBookPrice());
        bookEntityToDto.setBookQuantity(book.getBookQuantity());
        return bookEntityToDto;
    }
}
