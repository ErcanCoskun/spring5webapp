package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ercan = new Author("Ercan", "Coşkun");
        Book ddd = new Book("Domain Driven Design", "121212");
        ercan.getBooks().add(ddd);
        ddd.getAuthors().add(ercan);

        authorRepository.save(ercan);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Jason");
        Book noEJB = new Book("No EJB", "223323");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started");
        System.out.println("Number of books:" + bookRepository.count());

    }
}
