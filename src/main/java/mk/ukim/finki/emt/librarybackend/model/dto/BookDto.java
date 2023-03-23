package mk.ukim.finki.emt.librarybackend.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.librarybackend.model.enumeration.BookCategory;

@Data
public class BookDto {

    private String title;
    private BookCategory category;
    private Long authorId;
    private Integer availableCopies;

    public BookDto() {
    }

}
