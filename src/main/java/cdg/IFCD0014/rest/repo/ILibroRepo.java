package cdg.IFCD0014.rest.repo;

import cdg.IFCD0014.rest.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepo extends JpaRepository<Libro, String> {
}
