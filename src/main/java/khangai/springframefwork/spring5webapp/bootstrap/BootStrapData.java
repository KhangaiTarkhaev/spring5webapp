package khangai.springframefwork.spring5webapp.bootstrap;

import khangai.springframefwork.spring5webapp.model.Author;
import khangai.springframefwork.spring5webapp.model.Book;
import khangai.springframefwork.spring5webapp.repositories.AuthorRepository;
import khangai.springframefwork.spring5webapp.repositories.BookRepository;
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
        Author eric = new Author("Eric", "Evans");
        Book springHeadFirst = new Book("Spring Head First", "123123");
        eric.getBooks().add(springHeadFirst);
        springHeadFirst.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(springHeadFirst);
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("NoEJB", "2424245");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started a Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());
    }
}
