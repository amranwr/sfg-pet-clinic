package amr.springproject.sfgpetclinic.services;

import amr.springproject.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Set<Pet> findAll();
    Boolean save(Pet pet);
}
