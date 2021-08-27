package amr.springproject.sfgpetclinic.services;

import amr.springproject.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CRUDService{
    Owner findByLastName(String lastName);
}