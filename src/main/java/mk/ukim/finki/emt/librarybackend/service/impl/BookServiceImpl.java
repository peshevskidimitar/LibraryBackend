package mk.ukim.finki.emt.librarybackend.service.impl;

import mk.ukim.finki.emt.librarybackend.model.Author;
import mk.ukim.finki.emt.librarybackend.model.Book;
import mk.ukim.finki.emt.librarybackend.model.dto.BookDto;
import mk.ukim.finki.emt.librarybackend.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.librarybackend.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.librarybackend.repository.BookRepository;
import mk.ukim.finki.emt.librarybackend.service.AuthorService;
import mk.ukim.finki.emt.librarybackend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = authorService.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getTitle(), bookDto.getCategory(), author, bookDto.getAvailableCopies());

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> save(Long id, BookDto bookDto) {
        Book book = findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        Author author = authorService.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        book.setTitle(bookDto.getTitle());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        Book book = findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(book);

        if (bookRepository.findById(id).isPresent())
            return Optional.empty();

        return Optional.of(book);
    }

    @Override
    public Optional<Book> borrow(Long id) {
        Book book = findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        if (book.getAvailableCopies() > 0)
            book.setAvailableCopies(book.getAvailableCopies() - 1);

        return Optional.of(bookRepository.save(book));
    }

}
