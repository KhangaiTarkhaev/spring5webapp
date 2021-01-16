package khangai.springframefwork.spring5webapp.bootstrap;

import khangai.springframefwork.spring5webapp.model.Author;
import khangai.springframefwork.spring5webapp.model.Book;
import khangai.springframefwork.spring5webapp.model.Publisher;
import khangai.springframefwork.spring5webapp.repositories.AuthorRepository;
import khangai.springframefwork.spring5webapp.repositories.BookRepository;
import khangai.springframefwork.spring5webapp.repositories.PublisherRepository;
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
        Publisher publisher = new Publisher();
        publisher.setName("GEOTAR");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book springHeadFirst = new Book("Spring Head First", "123123");
        eric.getBooks().add(springHeadFirst);
        springHeadFirst.getAuthors().add(eric);
        springHeadFirst.setPublisher(publisher);
        publisher.getBooks().add(springHeadFirst);

        authorRepository.save(eric);
        bookRepository.save(springHeadFirst);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("NoEJB", "2424245");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);



        System.out.println("Started a Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Publishers: "  + publisherRepository.count());
        System.out.println("Number of Books by Publisher: " + publisher.getBooks().size());
    }
}
