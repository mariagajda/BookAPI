package pl.coderslab.interfaces;

import pl.coderslab.DTO.BookDTO;
import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooksList();
    Book getBookById(Long id);
    Book updateBookData(Long id, BookDTO bookDTO);
    Book removeBook(Long id);
    Book addBook(BookDTO bookDTO);
}
