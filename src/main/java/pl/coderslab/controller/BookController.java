package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;
import pl.coderslab.model.MockBookService;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getList() {
        return bookService.getBooksList();
    }

    @PostMapping("")
    public Book addBook(String isbn, String title, String author, String publisher, String type) {
        return bookService.addBook(isbn, title, author, publisher, type);
    }

    @GetMapping("/{id}")
    public Book bookInfo(@PathVariable Long id) {
        return this.bookService.getBookById(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
    });
}

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, String isbn, String title, String author, String publisher, String type) {
        bookService.updateBookData(id, isbn, title, author, publisher, type);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.removeBook(id);
    }
}


