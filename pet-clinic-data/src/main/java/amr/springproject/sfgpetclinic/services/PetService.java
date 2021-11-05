package amr.springproject.sfgpetclinic.services;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService extends CRUDService<Pet,Long>{
    Pet updateExistingPet(Long ownerId, Pet pet);
}
