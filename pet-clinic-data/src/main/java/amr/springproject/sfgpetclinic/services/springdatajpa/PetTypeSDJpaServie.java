package amr.springproject.sfgpetclinic.services.springdatajpa;

import amr.springproject.sfgpetclinic.model.PetType;
import amr.springproject.sfgpetclinic.repositories.PetTypeRepo;
import amr.springproject.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPAService")
public class PetTypeSDJpaServie implements PetTypeService {
    private  final PetTypeRepo petTypeRepo;

    public PetTypeSDJpaServie(PetTypeRepo petTypeRepo) {
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepo.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepo.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepo.findById(aLong);
    }
}
