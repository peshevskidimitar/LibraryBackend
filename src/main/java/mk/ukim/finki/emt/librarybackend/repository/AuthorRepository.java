package mk.ukim.finki.emt.librarybackend.repository;

import mk.ukim.finki.emt.librarybackend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
