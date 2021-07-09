package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
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
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12231232");



        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Publisher vasile = new Publisher("Vasile Gheorghe", "Str Hlincea 65, Iasi");

 //       publisherRepository.save(vasile);

        bookRepository.save(ddd);
        ddd.setPublisher(vasile);
        vasile.getBooks().add(ddd);

        publisherRepository.save(vasile);

        authorRepository.save(eric);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "5453234543");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());





        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println(publisherRepository.findAll());

        System.out.println("Publisher Number of books " + publisherRepository.count());
    }
}
