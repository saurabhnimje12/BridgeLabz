package org.ProblemStatements;

import java.util.ArrayList;
import java.util.Comparator;

class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BookRecommendations{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}

public class BookRecommendations {
    private String title;
    private double rating;

    public BookRecommendations(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }


    public static void main(String[] args) {
        ArrayList<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Dune", "Frank Herbert", "Science Fiction", 4.8));
        booksList.add(new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.6));
        booksList.add(new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.5));
        booksList.add(new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.7));
        booksList.add(new Book("The Martian", "Andy Weir", "Science Fiction", 4.9));
        booksList.add(new Book("1984", "George Orwell", "Dystopian", 4.3));
        booksList.add(new Book("Necromancer", "William Gibson", "Science Fiction", 4.2));
        booksList.add(new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.1));

//        1. Filter: Select books that are of genre "Science Fiction" with a rating greater than 4.0.
        booksList.stream()
                .filter(book -> book.getGenre().equals("Science Fiction") && book.getRating() > 4.0)
                .forEach(System.out::println);

        System.out.println("==========================================");

//        2. Transform: Create a new list of BookRecommendation objects containing title and rating.
//        booksList.stream()
//                .filter(book -> book.getGenre().equals("Science Fiction") && book.getRating() > 4.0)
//                .map(book -> new BookRecommendations(book.getTitle(), book.getRating())).forEach(System.out::println);
//        System.out.println("==========================================");

//        3. Sort: Sort these books by their rating in descending order.
        booksList.stream()
                .sorted(Comparator.comparing(Book::getRating).reversed())
                .forEach(System.out::println);
        System.out.println("==========================================");

//        4. Paginate: Return the top 10 books as a paginated result, assuming each page shows 5 books.
    }
}