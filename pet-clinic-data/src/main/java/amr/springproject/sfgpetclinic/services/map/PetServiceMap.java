package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Pet;
import amr.springproject.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile("map")
public class PetServiceMap extends MapService<Pet,Long> implements PetService {
    @Override
    public Pet updateExistingPet(Long ownerId, Pet pet) {
        return null;
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
