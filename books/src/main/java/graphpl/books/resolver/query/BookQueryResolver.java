package graphpl.books.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphpl.books.exception.BookNotFoundException;
import graphpl.books.model.Book;
import graphpl.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookQueryResolver implements GraphQLQueryResolver {
    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        log.info("Finding all books");
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        log.info("Finding book by id: {}", id);
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public int countBooks() {
        log.info("Counting books");
        return bookRepository.findAll().size();
    }
}
