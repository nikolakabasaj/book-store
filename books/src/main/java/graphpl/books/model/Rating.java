package graphpl.books.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "rating")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rating_num")
    private int rating;

    @Column(name = "star")
    private String star;
}
