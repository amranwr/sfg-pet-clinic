package amr.springproject.sfgpetclinic.repositories;

import amr.springproject.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OwnerRepo extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String LastName);
}
