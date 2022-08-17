package graphpl.books.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphpl.books.model.Author;
import graphpl.books.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorQueryResolver implements GraphQLQueryResolver {
    private final AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        log.info("Finding all authors");
        return authorRepository.findAll();
    }

    public int countAuthors() {
        log.info("Counting authors");
        return authorRepository.findAll().size();
    }
}
