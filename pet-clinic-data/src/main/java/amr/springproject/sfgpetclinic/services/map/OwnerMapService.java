package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.services.OwnerService;
import amr.springproject.sfgpetclinic.services.PetService;
import amr.springproject.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile("map")
public class OwnerMapService extends MapService<Owner, Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            object.getPets().forEach(pet -> {
                if(pet.getId() == null){
                    petService.save(pet);
                    System.out.println("pet wasn't saved but don't worry ;)");
                    if(pet.getPetType().getId() == null){
                        petTypeService.save(pet.getPetType());
                    }
                }
            });
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
