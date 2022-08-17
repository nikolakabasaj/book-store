package graphpl.books.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphpl.books.model.Book;
import graphpl.books.model.Rating;
import graphpl.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RatingResolver implements GraphQLResolver<Rating> {
    private BookRepository bookRepository;

    public Book getBook(Rating rating) {
        return bookRepository.findByRatingId(rating.getId()).stream()
                .findFirst()
                .orElseThrow();
    }
}
