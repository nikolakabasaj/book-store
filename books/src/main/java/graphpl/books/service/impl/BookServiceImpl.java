package graphpl.books.service.impl;

import graphpl.books.exception.BookNotFoundException;
import graphpl.books.model.Book;
import graphpl.books.repository.AuthorRepository;
import graphpl.books.repository.BookRepository;
import graphpl.books.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
