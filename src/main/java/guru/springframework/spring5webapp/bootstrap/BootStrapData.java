package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driver Design", "1212121");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without E2J", "32323332");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(eric);
        authorRepository.save(rod);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

        Publisher publisher = new Publisher("Publisher name",
                "my address line", "my city", "my state", "08021");
        publisherRepository.save(publisher);

        System.out.println("Number of publishers: " +  publisherRepository.count());


    }
}
