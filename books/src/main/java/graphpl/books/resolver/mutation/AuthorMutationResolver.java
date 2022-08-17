package graphpl.books.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphpl.books.input.CreateAuthorInput;
import graphpl.books.model.Author;
import graphpl.books.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorMutationResolver implements GraphQLMutationResolver {
    private final AuthorRepository authorRepository;

    public Author saveAuthor(CreateAuthorInput input) {
        log.info("Saving author with name {} {}", input.getFirstName(), input.getLastName());
        return authorRepository.save(
                Author.builder()
                        .firstName(input.getFirstName())
                        .lastName(input.getLastName())
                        .build());
    }
}
