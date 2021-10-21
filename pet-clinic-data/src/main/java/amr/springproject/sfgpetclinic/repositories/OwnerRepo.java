package amr.springproject.sfgpetclinic.repositories;

import amr.springproject.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OwnerRepo extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);
}
