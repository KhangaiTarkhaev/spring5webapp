package khangai.springframefwork.spring5webapp.repositories;

import khangai.springframefwork.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
