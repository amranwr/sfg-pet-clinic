package amr.springproject.sfgpetclinic.services.springdatajpa;

import amr.springproject.sfgpetclinic.model.Pet;
import amr.springproject.sfgpetclinic.repositories.PetRepo;
import amr.springproject.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPAService")
public class PetSDJpaService implements PetService {
    private final PetRepo petRepo;

    public PetSDJpaService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }



    @Override
    public Pet save(Pet object) {
        return petRepo.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepo.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Pet object) {
        petRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepo.deleteById(aLong);
    }
}
