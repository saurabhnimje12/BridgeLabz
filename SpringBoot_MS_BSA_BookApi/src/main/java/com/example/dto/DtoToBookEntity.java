package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DtoToBookEntity {
    @NotBlank(message = "Book name cannot be blank")
    @Size(max = 100, message = "Book name cannot exceed 100 characters")
    private String bookName;
    @NotBlank(message = "Book author cannot be blank")
    @Size(max = 100, message = "Book author cannot exceed 100 characters")
    private String bookAuthor;
    @NotBlank(message = "Book description cannot be blank")
    @Size(max = 500, message = "Book description cannot exceed 500 characters")
    private String bookDescription;
    @NotBlank(message = "Book logo cannot be blank")
    private String bookLogoMultipart;
    @NotNull(message = "Book price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Book price must be greater than zero")
    private Double bookPrice;
    @NotNull(message = "Book quantity cannot be null")
    @Min(value = 1, message = "Book quantity must be at least 1")
    private Integer bookQuantity;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookLogoMultipart() {
        return bookLogoMultipart;
    }

    public void setBookLogoMultipart(String bookLogoMultipart) {
        this.bookLogoMultipart = bookLogoMultipart;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }
}
