package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import pl.coderslab.model.Book;

@Component
public class MockBookService implements BookService {
    private List<Book> booksList;


    public MockBookService() {
        booksList = new ArrayList<>();
        booksList.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        booksList.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        booksList.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public Optional<Book> getBookById(Long id) {
        return booksList.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book addBook(String isbn, String title, String author, String publisher, String type) {
        Long id = Long.parseLong(String.valueOf(booksList.size())) + 1;
        Book newBook = new Book(id, isbn, title, author, publisher, type);
        booksList.add(newBook);
        return newBook;
    }

    public void updateBookData(Long id, String isbn, String title, String author, String publisher, String type) {
        List<Book> books = booksList;

        for (Book bookToUpdate : books) {
            if (bookToUpdate.getId().equals(id)) {
                bookToUpdate.setIsbn(isbn);
                bookToUpdate.setTitle(title);
                bookToUpdate.setAuthor(author);
                bookToUpdate.setPublisher(publisher);
                bookToUpdate.setType(type);
            }
        }
    }

    public void removeBook(Long id) {
        booksList.removeIf(book -> book.getId().equals(id));

    }
}
