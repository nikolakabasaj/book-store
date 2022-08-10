package graphpl.books.service;

import graphpl.books.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Book findById(Long id);

    List<Book> findAll();
}
