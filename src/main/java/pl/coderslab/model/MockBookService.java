package pl.coderslab.model;

import java.awt.print.Book;
import java.util.List;

public class MockBookService {
    private List<Book> list;

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public MockBookService(List<Book> list) {
        this.list = list;
    }
}
