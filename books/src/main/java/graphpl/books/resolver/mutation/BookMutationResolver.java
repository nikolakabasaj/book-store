package graphpl.books.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphpl.books.exception.BookNotFoundException;
import graphpl.books.input.CreateBookInput;
import graphpl.books.input.UpdateBookPageCountInput;
import graphpl.books.model.Book;
import graphpl.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookMutationResolver implements GraphQLMutationResolver {
    private final BookRepository bookRepository;

    public Book saveBook(CreateBookInput input) {
        log.info("Saving book with title {}", input.getTitle());
        return bookRepository.save(
                Book.builder()
                        .title(input.getTitle())
                        .pages(input.getPages())
                        .build());
    }

    public boolean deleteBook(Long id) {
        log.info("Deleting book with id {}", id);
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(UpdateBookPageCountInput input) {
        log.info("Updating book page count to {}", input.getPages());
        Book book = bookRepository.findById(input.getId())
                .orElseThrow(() -> new BookNotFoundException(input.getId()));
        book.setPages(input.getPages());
        return bookRepository.save(book);
    }
}
