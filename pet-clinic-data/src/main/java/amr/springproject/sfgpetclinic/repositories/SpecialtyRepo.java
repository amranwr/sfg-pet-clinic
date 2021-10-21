package amr.springproject.sfgpetclinic.repositories;

import amr.springproject.sfgpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface SpecialtyRepo extends CrudRepository<Specialty,Long> {
}
