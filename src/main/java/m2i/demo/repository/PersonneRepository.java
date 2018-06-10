package m2i.demo.repository;

import m2i.demo.model.Personne;
import org.springframework.data.repository.CrudRepository;

public interface PersonneRepository extends CrudRepository<Personne, String> {


}
