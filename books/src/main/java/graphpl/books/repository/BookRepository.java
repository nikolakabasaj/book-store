package graphpl.books.repository;

import graphpl.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByRatingId(Long ratingId);

    List<Book> findAllByAuthorId(Long id);
}
