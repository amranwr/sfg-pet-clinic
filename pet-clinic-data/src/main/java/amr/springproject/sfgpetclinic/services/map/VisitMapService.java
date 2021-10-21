package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Visit;
import amr.springproject.sfgpetclinic.repositories.VisitRepo;
import amr.springproject.sfgpetclinic.services.PetService;
import amr.springproject.sfgpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends MapService<Visit,Long> implements VisitService {
    private final PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Visit save(Visit object) {
        if(object.getId() == null || object.getPet().getId() == null || object.getPet().getPetType().getId() == null){
            throw new RuntimeException("invalid visit");
        }
        return super.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
