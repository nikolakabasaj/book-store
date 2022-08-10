package graphpl.books.resolver;

import graphpl.books.exception.BookNotFoundException;
import graphpl.books.input.CreateAuthorInput;
import graphpl.books.input.CreateBookInput;
import graphpl.books.input.UpdateBookPageCountInput;
import graphpl.books.model.Author;
import graphpl.books.model.Book;
import graphpl.books.repository.AuthorRepository;
import graphpl.books.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Book saveBook(CreateBookInput input) {
        return bookRepository.save(
                        Book.builder()
                        .title(input.getTitle())
                        .pages(input.getPagesNumber())
                        .build());
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(UpdateBookPageCountInput input) {
        Book book = bookRepository.findById(input.getId())
                .orElseThrow(() -> new BookNotFoundException(input.getId()));
        book.setPages(input.getPages());
        return bookRepository.save(book);
    }

    public Author saveAuthor(CreateAuthorInput input) {
        return authorRepository.save(
                            Author.builder()
                            .firstName(input.getFirstName())
                            .lastName(input.getLastName())
                            .build());
    }
}
