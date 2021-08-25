package amr.springproject.sfgpetclinic.services;

import amr.springproject.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);
    Set<Owner> findAll();
    Boolean save(Owner owner);
}
