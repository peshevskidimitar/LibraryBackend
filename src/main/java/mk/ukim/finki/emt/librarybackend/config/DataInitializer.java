package mk.ukim.finki.emt.librarybackend.config;


import mk.ukim.finki.emt.librarybackend.model.Author;
import mk.ukim.finki.emt.librarybackend.model.Book;
import mk.ukim.finki.emt.librarybackend.model.Country;
import mk.ukim.finki.emt.librarybackend.model.enumeration.BookCategory;
import mk.ukim.finki.emt.librarybackend.repository.AuthorRepository;
import mk.ukim.finki.emt.librarybackend.repository.BookRepository;
import mk.ukim.finki.emt.librarybackend.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void initData() {
        Country country1 = countryRepository.save(new Country("Russia", "Europe"));
        Country country2 = countryRepository.save(new Country("Macedonia", "Europe"));
        Country country3 = countryRepository.save(new Country("Japan", "Asia"));
        Country country4 = countryRepository.save(new Country("USA", "North America"));
        Country country5 = countryRepository.save(new Country("UK", "Europe"));

        Author author1 = authorRepository.save(new Author("Fyodor", "Dostoevsky", country1));
        Author author2 = authorRepository.save(new Author("Petre", "M. Andreevski", country2));
        Author author3 = authorRepository.save(new Author("Haruki", "Murakami", country3));
        Author author4 = authorRepository.save(new Author("Ernest", "Hemingway", country4));
        Author author5 = authorRepository.save(new Author("George", "Orwell", country5));

        Book book1 = bookRepository.save(new Book("The Brothers Karamazov", BookCategory.CLASSICS, author1, 25));
        Book book2 = bookRepository.save(new Book("Notes from Underground", BookCategory.NOVEL, author1, 20));
        Book book3 = bookRepository.save(new Book("Denicija", BookCategory.POETRY, author2, 55));
        Book book4 = bookRepository.save(new Book("Kafka on the Shore", BookCategory.NOVEL, author3, 35));
        Book book5 = bookRepository.save(new Book("South of the Border, West of the Sun", BookCategory.NOVEL, author3, 70));
        Book book6 = bookRepository.save(new Book("The Old Man and the Sea", BookCategory.NOVEL, author4, 30));
        Book book7 = bookRepository.save(new Book("1984", BookCategory.FANTASY, author5, 10));
    }

}
