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

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Sanket Publication");
        publisher.setAddressLine1("B-8-A-501 Sudama, Vrindavan City, Jamtha");
        publisher.setCity("Nagpur");
        publisher.setState("Maharashtra");
        publisher.setZip(441122);

        publisherRepository.save(publisher);

        System.out.println("Publisher Count:" + publisherRepository.count());

        Author sanket = new Author("Sanket", "Gupte");

        Book ddd = new Book("Domain Driven Design", "123123");

        sanket.getBooks().add(ddd);
        ddd.getAuthors().add(sanket);

        authorRepository.save(sanket);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","3939459459");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Number of Books: " + bookRepository.count());

    }
}
