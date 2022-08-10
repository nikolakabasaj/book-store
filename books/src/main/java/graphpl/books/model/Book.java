package graphpl.books.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
@Getter @Setter @ToString @NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "pages")
    private Integer pages;

    @OneToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Builder
    public Book(Long id, String title, Integer pages, Rating rating, Author author) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.rating = rating;
        this.author = author;
    }
}
