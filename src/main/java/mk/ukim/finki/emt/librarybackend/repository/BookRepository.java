package mk.ukim.finki.emt.librarybackend.repository;

import mk.ukim.finki.emt.librarybackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
