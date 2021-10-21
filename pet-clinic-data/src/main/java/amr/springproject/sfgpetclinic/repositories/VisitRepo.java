package amr.springproject.sfgpetclinic.repositories;

import amr.springproject.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit,Long> {
}
