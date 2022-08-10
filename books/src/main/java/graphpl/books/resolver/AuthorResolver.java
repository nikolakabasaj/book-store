package graphpl.books.resolver;

import graphpl.books.model.Author;
import graphpl.books.model.Book;
import graphpl.books.repository.AuthorRepository;
import graphpl.books.repository.BookRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {
    private final BookRepository bookRepository;

    public List<Book> getBooks(Author author) {
        return bookRepository.findAllByAuthorId(author.getId());
    }
}
