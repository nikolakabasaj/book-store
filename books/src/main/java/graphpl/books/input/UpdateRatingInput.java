package graphpl.books.input;

import lombok.Data;

@Data
public class UpdateRatingInput {
    private Long id;
    private int rating;
}
