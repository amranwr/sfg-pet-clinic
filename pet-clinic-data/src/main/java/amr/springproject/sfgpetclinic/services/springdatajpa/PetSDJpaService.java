package amr.springproject.sfgpetclinic.services.springdatajpa;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.model.Pet;
import amr.springproject.sfgpetclinic.repositories.OwnerRepo;
import amr.springproject.sfgpetclinic.repositories.PetRepo;
import amr.springproject.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springDataJPAService")
public class PetSDJpaService implements PetService {
    private final PetRepo petRepo;
    private final OwnerRepo ownerRepo;

    public PetSDJpaService(PetRepo petRepo, OwnerRepo ownerRepo) {
        this.petRepo = petRepo;
        this.ownerRepo = ownerRepo;
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

    @Override
    public Pet updateExistingPet(Long ownerId, Pet pet) {
        Optional<Owner> ownerOptional = ownerRepo.findById(ownerId);
        if(ownerOptional.isPresent()){
            Optional<Pet> temp = ownerOptional.get().getPets().stream()
                    .filter(pet1 -> pet1.getId().equals(pet.getId()))
                    .findFirst();
            if(temp.isPresent()){
                Pet originalPet = temp.get();
                originalPet.setOwner(ownerOptional.get());
                originalPet.setPetType(pet.getPetType());
                originalPet.setBirthDate(pet.getBirthDate());
                originalPet.setName(pet.getName());
                originalPet.setVisits(pet.getVisits());
                petRepo.save(originalPet);
                return originalPet;
            }else{
                throw new RuntimeException("there is no pet with that id : "+ pet.getId());
            }
        }else{
            throw new RuntimeException("there is no pet with that id : "+ ownerOptional.get().getId());
        }
    }
}
