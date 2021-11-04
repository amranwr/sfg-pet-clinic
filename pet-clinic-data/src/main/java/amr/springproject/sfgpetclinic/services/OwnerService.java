package amr.springproject.sfgpetclinic.services;

import amr.springproject.sfgpetclinic.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CRUDService<Owner,Long>{
    Owner findByLastName(String lastName);
    List findByLastNameLike(String LastName);
}
