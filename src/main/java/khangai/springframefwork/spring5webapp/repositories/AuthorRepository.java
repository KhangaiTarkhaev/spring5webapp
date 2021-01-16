package khangai.springframefwork.spring5webapp.repositories;

import khangai.springframefwork.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
