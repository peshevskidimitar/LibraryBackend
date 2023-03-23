package mk.ukim.finki.emt.librarybackend.service;

import mk.ukim.finki.emt.librarybackend.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
}
