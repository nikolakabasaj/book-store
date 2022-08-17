package graphpl.books.resolver.subscription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import graphpl.books.exception.BookNotFoundException;
import graphpl.books.exception.RatingNotFoundException;
import graphpl.books.input.UpdateRatingInput;
import graphpl.books.model.Book;
import graphpl.books.model.Rating;
import graphpl.books.repository.BookRepository;
import graphpl.books.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class BookSubscriptionResolver implements GraphQLSubscriptionResolver {
    private final BookRepository bookRepository;
    private final RatingRepository ratingRepository;
    private final SubscriptionPublisherFactory publisherFactory;

    public Publisher<Book> updateBookRating(UpdateRatingInput input) {
        Book updatedBook = updateBook(input);
        SubscriptionPublisher<Book> publisher = publisherFactory.createSubscriptionPublisher(Book.class);
        return publisher.publish(updatedBook);
    }

    public Publisher<List<Book>> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        SubscriptionPublisher<List<Book>> publisher = publisherFactory.createSubscriptionPublisher((Class<List<Book>>)(Object)List.class);
        return publisher.publish(books);
    }

    private Book updateBook(UpdateRatingInput input) {
        Book book = bookRepository.findById(input.getId())
                .orElseThrow(() -> new BookNotFoundException(input.getId()));
        Rating rating = ratingRepository.findByRating(input.getRating())
                .orElseThrow(() -> new RatingNotFoundException(input.getId()));
        book.setRating(rating);
        return bookRepository.save(book);
    }
}
