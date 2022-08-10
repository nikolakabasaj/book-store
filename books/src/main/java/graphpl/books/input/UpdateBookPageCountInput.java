package graphpl.books.input;

import lombok.Builder;
import lombok.Data;

@Data
public class UpdateBookPageCountInput {
    private Long id;
    private int pages;
}
