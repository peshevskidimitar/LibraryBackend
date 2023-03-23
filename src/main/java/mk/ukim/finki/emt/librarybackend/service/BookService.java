package mk.ukim.finki.emt.librarybackend.service;

import mk.ukim.finki.emt.librarybackend.model.Book;
import mk.ukim.finki.emt.librarybackend.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> save(Long id, BookDto bookDto);
    Optional<Book> deleteById(Long id);
    Optional<Book> borrow(Long id);
}
