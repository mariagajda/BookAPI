package pl.coderslab.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.DTO.BookDTO;
import pl.coderslab.interfaces.BookRepository;
import pl.coderslab.interfaces.BookService;
import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaBookService implements BookService {
   private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooksList() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Book updateBookData(Long id, BookDTO bookDTO) {
        return null;
    }

    @Override
    public Book removeBook(Long id) {
        return null;
    }

    @Override
    public Book addBook(BookDTO bookDTO) {
        return null;
    }
}
