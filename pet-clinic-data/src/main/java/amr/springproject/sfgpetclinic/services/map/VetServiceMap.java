package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Specialty;
import amr.springproject.sfgpetclinic.model.Vet;
import amr.springproject.sfgpetclinic.services.SpecialtyService;
import amr.springproject.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile("map")
public class VetServiceMap extends MapService<Vet,Long> implements VetService {
    private  final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpecialities().size() != 0 ){
                object.getSpecialities().forEach(specialty -> {
                    if(specialty.getId() == null){
                        Specialty s1 = specialtyService.save(specialty);
                    }
                    System.out.println("specialty wasn't saved brohter .......");
                });
            }else{
                throw new RuntimeException("vet has to have some specialties......");
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
