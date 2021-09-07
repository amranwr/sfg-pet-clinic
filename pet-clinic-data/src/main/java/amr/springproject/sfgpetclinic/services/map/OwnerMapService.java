package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends MapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Long aLong, Owner object) {
        return super.save(aLong, object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
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
