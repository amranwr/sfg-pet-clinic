package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Vet;
import amr.springproject.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends MapService<Vet,Long> implements VetService {
    @Override
    public Vet save(Long aLong, Vet object) {
        return super.save(aLong, object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
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
