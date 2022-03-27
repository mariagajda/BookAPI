package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.DTO.BookDTO;
import pl.coderslab.model.Book;
import pl.coderslab.interfaces.BookService;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity getList() {
        return ResponseEntity.ok(bookService.getBooksList());
    }

    @PostMapping("")
    public ResponseEntity addBook(BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.addBook(bookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity bookInfo(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateBookData(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.removeBook(id));
    }
}


