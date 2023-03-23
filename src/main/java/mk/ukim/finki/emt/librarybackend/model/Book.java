package mk.ukim.finki.emt.librarybackend.model;

import javax.persistence.*;
import lombok.Data;
import mk.ukim.finki.emt.librarybackend.model.enumeration.BookCategory;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(value = EnumType.STRING)
    private BookCategory category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Book() {
    }

    public Book(String title, BookCategory category, Author author, Integer availableCopies) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

}
