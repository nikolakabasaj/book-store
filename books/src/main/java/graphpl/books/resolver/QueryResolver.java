package graphpl.books.resolver;

import graphpl.books.exception.BookNotFoundException;
import graphpl.books.model.Author;
import graphpl.books.model.Book;
import graphpl.books.repository.AuthorRepository;
import graphpl.books.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public int countBooks() {
        return bookRepository.findAll().size();
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public int countAuthors() {
        return authorRepository.findAll().size();
    }
}
