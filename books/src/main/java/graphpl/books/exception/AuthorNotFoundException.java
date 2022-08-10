package graphpl.books.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorNotFoundException extends RuntimeException implements GraphQLError  {
    private Map<String, Object> extensions = new HashMap<>();

    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id %d not found", id));
        extensions.put("invalidId", id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
