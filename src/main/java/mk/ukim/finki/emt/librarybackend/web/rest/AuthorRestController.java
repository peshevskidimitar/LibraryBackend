package mk.ukim.finki.emt.librarybackend.web.rest;

import mk.ukim.finki.emt.librarybackend.model.Author;
import mk.ukim.finki.emt.librarybackend.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

}
