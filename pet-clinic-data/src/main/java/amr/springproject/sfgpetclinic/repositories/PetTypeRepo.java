package amr.springproject.sfgpetclinic.repositories;

import amr.springproject.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepo extends CrudRepository<PetType,Long> {
}
