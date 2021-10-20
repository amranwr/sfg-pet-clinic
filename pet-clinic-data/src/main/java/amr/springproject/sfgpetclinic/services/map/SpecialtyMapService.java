package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Specialty;
import amr.springproject.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SpecialtyMapService extends MapService<Specialty,Long> implements SpecialtyService {
    public SpecialtyMapService() {
        super();
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
