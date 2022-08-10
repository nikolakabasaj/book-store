package graphpl.books.resolver;

import graphpl.books.exception.AuthorNotFoundException;
import graphpl.books.model.Author;
import graphpl.books.model.Book;
import graphpl.books.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {
    private final AuthorRepository authorRepository;

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new AuthorNotFoundException(book.getAuthor().getId()));
    }
}
