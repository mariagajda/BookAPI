package pl.coderslab.model;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooksList();
    Optional<Book> getBookById(Long id);
    void updateBookData(Long id,String isbn, String title, String author, String publisher, String type);
    void removeBook(Long id);
    Book addBook(String isbn, String title, String author, String publisher, String type);
}
